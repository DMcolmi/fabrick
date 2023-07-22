package com.fabrick.colmi.davidemaria.exceptionhandling;

public class FabrickRestException extends RuntimeException {
	
	private static final long serialVersionUID = 1186745538219917323L;	

    public FabrickRestException(String message, Throwable cause) {
    	super(message, cause);
    }
}
