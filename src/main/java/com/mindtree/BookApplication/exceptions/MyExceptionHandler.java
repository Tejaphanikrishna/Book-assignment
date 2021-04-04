package com.mindtree.BookApplication.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mindtree.BookApplication.exceptions.ControllerException.ControllerException;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<?> exceptionHandler(ControllerException ce, WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), ce.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}

}
