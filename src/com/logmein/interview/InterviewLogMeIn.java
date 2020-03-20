package com.logmein.interview;

import java.net.SocketException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class InterviewLogMeIn {

	public static void main(String[] args) {
		
		// Get the port number from command line arguments
		int port = Integer.parseInt(args[0]);
		
		UDPTimeServer udpTimeServer = null;
		try {
			udpTimeServer = new UDPTimeServer(port);
			Thread thread = new Thread(udpTimeServer);
			thread.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			udpTimeServer.stop();
		}
		
//		System.out.println("PORT:" + port);
//		
//		String time = ZonedDateTime.now().format( DateTimeFormatter.ISO_OFFSET_TIME );
//		System.out.println(time);
//		
//		String date = ZonedDateTime.now().format( DateTimeFormatter.ISO_OFFSET_DATE );
//		System.out.println(date);
//		
//		String datetime = ZonedDateTime.now().format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
//		System.out.println(datetime);
	}

}
