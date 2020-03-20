package com.logmein.interview;

import java.io.IOException;
import java.net.SocketException;

public class InterviewLogMeIn {

	public static void main(String[] args) {
		
		// Get the port number from command line arguments
		int port = Integer.parseInt(args[0]);
		
		// start a UDPTimeServer
		UDPTimeServer udpTimeServer = null;
		TCPTimeServer tcpTimeServer = null;
		try {
			udpTimeServer = new UDPTimeServer(port);
			Thread udpServerThread = new Thread(udpTimeServer);
			
			tcpTimeServer = new TCPTimeServer(port);
			Thread tcpServerThread = new Thread(tcpTimeServer);
			
			udpServerThread.start();
			tcpServerThread.start();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			udpTimeServer.stop();
		}
		
	}

}
