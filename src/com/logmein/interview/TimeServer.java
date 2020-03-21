package com.logmein.interview;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeServer {
	
	private static final Logger LOGGER = Logger.getLogger(TimeServer.class.getName());

	public static void main(String[] args) {
		
		LOGGER.log(Level.INFO, "TimeServer is starting...");
		
		// Get the port number from command line arguments
		int port = Integer.parseInt(args[0]);
		LOGGER.log(Level.CONFIG, "Listening on port " + port);
		
		UDPTimeServer udpTimeServer = null;
		TCPTimeServer tcpTimeServer = null;
		try {
			// start a UDP TimeServer
			LOGGER.log(Level.INFO, "Starting UDP server...");
			udpTimeServer = new UDPTimeServer(port);
			Thread udpServerThread = new Thread(udpTimeServer);
			udpServerThread.start();
			
			// start a TCP TimeServer
			LOGGER.log(Level.INFO, "Starting TCP server...");
			tcpTimeServer = new TCPTimeServer(port);
			Thread tcpServerThread = new Thread(tcpTimeServer);
			tcpServerThread.start();
			
			LOGGER.log(Level.INFO, "TimeServer is ready and waiting.");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		
	}

}
