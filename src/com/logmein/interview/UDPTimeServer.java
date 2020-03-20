package com.logmein.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPTimeServer extends AbstractTimeServer implements Runnable {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	
	public UDPTimeServer(int port) throws SocketException {
		this.socket = new DatagramSocket(port);
	}

	@Override
	public void run() {
        running = true;

        while (running) {
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
//            packet = new DatagramPacket(buf, buf.length, address, port);
            String received = new String(packet.getData(), 0, packet.getLength());
            received = received.trim();
            System.out.println(received);
            
            String response = "";
            
			try {
				response = requestHandler(received);
			} catch (UnknownRequestException e) {
				response = "unknown request";
			}
			
			response = response + "\n";
			packet = new DatagramPacket(response.getBytes(), response.length(), address, port);
//			packet.setData(response.getBytes());
//			packet.setLength(response.getBytes().length);
            
            try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        socket.close();
    }
	
	public void stop() {
		running = false;
	}



}
