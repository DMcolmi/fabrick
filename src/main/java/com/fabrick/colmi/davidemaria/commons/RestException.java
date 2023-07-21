package com.fabrick.colmi.davidemaria.commons;

public class RestException extends RuntimeException {
	
	private static final long serialVersionUID = 1186745538219917323L;	

    public RestException(String message, Throwable cause) {
    	super(message, cause);
    }
}
