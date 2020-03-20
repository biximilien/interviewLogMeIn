package com.logmein.interview;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTimeServer extends AbstractTimeServer implements Runnable {

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
			} catch (IOException e) {
				continue;
			}

			while (connectionSocket.isConnected() && !connectionSocket.isClosed()) {
				BufferedReader inFromClient = null;
				try {
					inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				} catch (IOException e3) {
					continue;
				}

				DataOutputStream outToClient = null;
				try {
					outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				} catch (IOException e3) {
					continue;
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
					continue;
				}
				System.out.println(request);

				String response;
				try {
					response = requestHandler(request);
				} catch (UnknownRequestException e1) {
					response = "unknown request";
				}
				response = response + "\n";

				try {
					outToClient.writeBytes(response);
				} catch (IOException e) {
					continue;
				}
			}
		}
	}

}
