/**
 * @author Maxime 'biximilien' Gauthier 
 */
package com.logmein.interview;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Class AbstractTimeServer implements shared behavior of UDPTimeServer and
 * TCPTimeServer. It provides implementation for the service interfaces and
 * provides a request handler for the 3 requests types to ensure consistent
 * behavior on both TCP and UDP.
 */
public abstract class AbstractTimeServer implements DateService, DateTimeService, TimeService {

	@Override
	public String timeRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format(DateTimeFormatter.ISO_OFFSET_TIME);
	}

	@Override
	public String dateTimeRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}

	@Override
	public String dateRequest() {
		ZonedDateTime zdt = ZonedDateTime.now();
		return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE);
	}

	/**
	 * Request handler provides implementation behavior for responding to requests.
	 * The 3 possibles requests types are `date`, `time` and `datetime`. The
	 * response will be an appropriate ISO 8601 compliant formatted string.
	 *
	 * @param request either of `date`, `time` or `datetime`
	 * @return an ISO 8601 compliant date or time formatted string
	 * @throws UnknownRequestException thrown when any other request occur
	 */
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
