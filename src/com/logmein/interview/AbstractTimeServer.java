package com.logmein.interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class AbstractTimeServer implements DateService, DateTimeService, TimeService {

	@Override
	public LocalTime timeRequest() {
		LocalTime time = LocalTime.now();
		return time;
	}

	@Override
	public LocalDateTime dateTimeRequest() {
		LocalDateTime dateTime = LocalDateTime.now();
		return dateTime;
	}

	@Override
	public LocalDate dateRequest() {
		LocalDate date = LocalDate.now();
		return date;
	}
	
	

}
