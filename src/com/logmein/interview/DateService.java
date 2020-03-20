/*
 * @author Maxime 'biximilien' Gauthier 
 */
package com.logmein.interview;

/**
 * The Interface DateService is an abstraction of the service handling the date
 * request and returns an ISO 8601 compliant date.
 */
public interface DateService {

	/**
	 * Date request service handles the 'date' request.
	 *
	 * @return the date as an ISO 8601 compliant text string
	 */
	public String dateRequest();
}
