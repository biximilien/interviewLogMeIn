/**
 * @author Maxime 'biximilien' Gauthier 
 */
package com.logmein.interview;

/**
 * The Interface DateTimeService is an abstraction of the service handling the date-time
 * request and returns an ISO 8601 compliant date-time.
 */
public interface DateTimeService {
	
	/**
	 * Date Time request service handles the 'datetime' request.
	 *
	 * @return the date-time as an ISO 8601 compliant text string
	 */
	public String dateTimeRequest();
}
