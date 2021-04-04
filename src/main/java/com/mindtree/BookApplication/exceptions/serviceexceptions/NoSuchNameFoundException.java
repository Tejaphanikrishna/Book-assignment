package com.mindtree.BookApplication.exceptions.serviceexceptions;

public class NoSuchNameFoundException extends WriterServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchNameFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchNameFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchNameFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchNameFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchNameFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
