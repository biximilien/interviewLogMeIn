package com.logmein.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPTimeServer extends AbstractTimeServer implements Runnable {
	
	private static final Logger LOGGER = Logger.getLogger(UDPTimeServer.class.getName());

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	
	public UDPTimeServer(int port) throws SocketException {
		this.socket = new DatagramSocket(port);
	}

	@Override
	public void run() {
        running = true;

        LOGGER.log(Level.INFO, "TimeServer is listening for datagrams on UDP socket address " + socket.getLocalAddress() + " and port " + socket.getLocalPort());
        while (running) {
        	
        	// receive a datagram
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}

            // get incoming address and port
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            // receive incoming packet
            String received = new String(packet.getData(), 0, packet.getLength());
            received = received.trim();
            LOGGER.log(Level.INFO, "Received datagram request `" + received + "`");
            
            // prepare the response message
            String response = "";
			try {
				response = requestHandler(received);
			} catch (UnknownRequestException e) {
				response = "unknown request";
			}
			LOGGER.log(Level.INFO, "Sending datagram response `" + response + "`");
			
			// craft the response datagram
			response = response + "\n";
			packet = new DatagramPacket(response.getBytes(), response.length(), address, port);
            
            try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        LOGGER.log(Level.INFO, "Closing UDP socket...");
        socket.close();
        LOGGER.log(Level.INFO, "Done.");
    }
	
	public void stop() {
		running = false;
	}



}
