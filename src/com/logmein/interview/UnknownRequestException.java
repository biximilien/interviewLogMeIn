package com.logmein.interview;

public class UnknownRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3913984055154310595L;

	public UnknownRequestException() {
		super();
	}

	public UnknownRequestException(String message) {
		super(message);
	}

	public UnknownRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownRequestException(Throwable cause) {
		super(cause);
	}

}
