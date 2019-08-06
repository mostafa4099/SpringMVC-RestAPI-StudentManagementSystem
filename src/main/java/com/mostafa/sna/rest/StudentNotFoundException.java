package com.mostafa.sna.rest;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuperSession, boolean writableStackTrace) {
		super(message, cause, enableSuperSession, writableStackTrace);
	}

}
