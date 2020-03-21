/**
 * @author Maxime 'biximilien' Gauthier 
 */
package com.logmein.interview;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class TCPTimeServer.
 */
public class TCPTimeServer extends AbstractTimeServer implements Runnable {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(TCPTimeServer.class.getName());

	/** The socket. */
	private ServerSocket socket;
	
	/** The running. */
	private boolean running;

	/**
	 * Instantiates a new TCP time server.
	 *
	 * @param port the port the TCP Time Server should bind on
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
				connectionSocket.setKeepAlive(false);
				connectionSocket.setSoTimeout(5000);
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
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * Stop the TCP server.
	 */
	public void stop() {
		running = false;
	}

}
