package com.digitalbook.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digitalbook.exception.AuthorServiceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AuthorServiceException.class)
	public ResponseEntity<ApiResponse> handleException(AuthorServiceException ex) {
		String message= ex.getMessage();
	    ApiResponse apiResponse=new ApiResponse(404,message);
	    return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
