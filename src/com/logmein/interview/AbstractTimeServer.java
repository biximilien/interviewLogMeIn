package com.logmein.interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class AbstractTimeServer implements DateService, DateTimeService, TimeService {

	@Override
	public LocalTime timeRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime dateTimeRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate dateRequest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
