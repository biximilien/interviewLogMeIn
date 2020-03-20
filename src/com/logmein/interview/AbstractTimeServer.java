package com.logmein.interview;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractTimeServer implements DateService, DateTimeService, TimeService {

	@Override
	public String timeRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format( DateTimeFormatter.ISO_OFFSET_TIME );
	}

	@Override
	public String dateTimeRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format( DateTimeFormatter.ISO_OFFSET_DATE );
	}

	@Override
	public String dateRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
	}

	public String requestHandler(String request) throws UnknownRequestException {
		switch (request) {
		case "date":
			return dateRequest();
		case "time":
			return timeRequest();
		case "datetime":
			return dateTimeRequest();
		default:
			throw new UnknownRequestException("don't know how to handle request `" + request + "`");
		}
	}



}
