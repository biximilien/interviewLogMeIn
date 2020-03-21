package com.logmein.interview;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPTimeServerThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(TCPTimeServerThread.class.getName());

	private Socket socket;
	private TCPTimeServer server;

	public TCPTimeServerThread(Socket socket, TCPTimeServer server) {
		this.socket = socket;
		this.server = server;
	}

	@Override
	public void run() {
		while (socket.isConnected() && !socket.isClosed()) {
			// setup input stream
			BufferedReader inFromClient = null;
			try {
				inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e3) {
				break;
			}

			// setup output stream
			DataOutputStream outToClient = null;
			try {
				outToClient = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e3) {
				break;
			}

			// read request from client
			String request = "";
			try {
				request = inFromClient.readLine();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if (request != null) {
				request.trim();
			} else {
				break;
			}
			LOGGER.log(Level.INFO, "Received TCP request `" + request + "`");

			// prepare response
			String response;
			try {
				response = server.requestHandler(request);
			} catch (UnknownRequestException e1) {
				response = "unknown request";
			}
			LOGGER.log(Level.INFO, "Sending TCP response `" + response + "`");

			response = response + "\n";

			// send response to client
			try {
				outToClient.writeBytes(response);
			} catch (IOException e) {
				break;
			}
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
