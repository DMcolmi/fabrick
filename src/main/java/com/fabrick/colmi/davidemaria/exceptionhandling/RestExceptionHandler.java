package com.fabrick.colmi.davidemaria.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	private static final int FABRICK_ERROR_STAUS_CODE = 441;
	
	@ExceptionHandler(FabrickRestException.class)
    public ResponseEntity<String> handleCustomException(FabrickRestException ex) {
        return ResponseEntity.status(FABRICK_ERROR_STAUS_CODE).body(ex.getMessage() + " " + ex.getCause().getMessage());
    }
	
}
