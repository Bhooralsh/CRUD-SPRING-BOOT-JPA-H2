package com.car.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CarNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CarNotFoundException() {
		
		
	}
	
	public CarNotFoundException(String message,Throwable throwable) {
		
		super(message,throwable);
	}

	
}
