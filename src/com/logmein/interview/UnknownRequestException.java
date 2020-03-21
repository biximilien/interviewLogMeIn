/**
 * @author Maxime 'biximilien' Gauthier 
 */
package com.logmein.interview;

/**
 * The Class UnknownRequestException.
 */
public class UnknownRequestException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3913984055154310595L;

	/**
	 * Instantiates a new unknown request exception.
	 */
	public UnknownRequestException() {
		super();
	}

	/**
	 * Instantiates a new unknown request exception.
	 *
	 * @param message the message
	 */
	public UnknownRequestException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new unknown request exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public UnknownRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new unknown request exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public UnknownRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new unknown request exception.
	 *
	 * @param cause the cause
	 */
	public UnknownRequestException(Throwable cause) {
		super(cause);
	}

}
