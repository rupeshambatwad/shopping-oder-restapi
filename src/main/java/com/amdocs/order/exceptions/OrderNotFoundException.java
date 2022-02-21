package com.amdocs.order.exceptions;

public class OrderNotFoundException extends RuntimeException{

	 public OrderNotFoundException() {

	    }
	    public OrderNotFoundException(String errorCode, String errorMessage) {
	        super(errorCode +"Invalid input request for"+errorMessage);
	    }
}
