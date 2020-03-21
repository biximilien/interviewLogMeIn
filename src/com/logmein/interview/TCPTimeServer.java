package com.logmein.interview;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPTimeServer extends AbstractTimeServer implements Runnable {
	
	private static final Logger LOGGER = Logger.getLogger(TCPTimeServer.class.getName());

	private ServerSocket socket;
	private boolean running;

	public TCPTimeServer(int port) throws IOException {
		this.socket = new ServerSocket(port);
	}

	@Override
	public void run() {
		running = true;
		
		while (running) {
			Socket connectionSocket = null;

			try {
				connectionSocket = socket.accept();
				LOGGER.log(Level.INFO, "Time Server accepted a connection on address " + socket.getInetAddress() + " and port " + socket.getLocalPort());
			} catch (IOException e) {
				continue;
			}

			while (connectionSocket.isConnected() && !connectionSocket.isClosed()) {
				BufferedReader inFromClient = null;
				try {
					inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				} catch (IOException e3) {
					break;
				}

				DataOutputStream outToClient = null;
				try {
					outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				} catch (IOException e3) {
					break;
				}

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

				String response;
				try {
					response = requestHandler(request);
				} catch (UnknownRequestException e1) {
					response = "unknown request";
				}
				LOGGER.log(Level.INFO, "Sending TCP response `" + response + "`");
				
				response = response + "\n";

				try {
					outToClient.writeBytes(response);
				} catch (IOException e) {
					break;
				}
			}
		}
	}

}
