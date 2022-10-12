package com.digitalbook.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.digitalbook.exception.ReaderServiceException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ReaderServiceException.class)
	public ResponseEntity<?> handleException(ReaderServiceException e) {
		return ResponseEntity.ok(new ErrorResponse(e.getMessage(), e.getClass().toString()));
	}
}
