package com.logmein.interview;

import java.io.IOException;
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
				LOGGER.log(Level.INFO, "Time Server accepted a connection on address " + socket.getInetAddress()
						+ " and port " + socket.getLocalPort());
			} catch (IOException e) {
				continue;
			}

			TCPTimeServerThread threadedSocket = new TCPTimeServerThread(connectionSocket, this);
			threadedSocket.start();
		}

		// close the socket if server is stopped
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		running = false;
	}

}
