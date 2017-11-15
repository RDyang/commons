package com.rdyang.hibernate.dao.exception;

public class CreateHqlException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateHqlException() {
		super();
	}

	public CreateHqlException(String message) {
		super(message);
	}

	public CreateHqlException(Throwable cause) {
		super(cause);
	}

	public CreateHqlException(String message, Throwable cause) {
		super(message, cause);
	}

	protected CreateHqlException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
