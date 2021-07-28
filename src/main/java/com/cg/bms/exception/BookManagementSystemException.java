package com.cg.bms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookManagementSystemException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
	ErrorDetails details = new ErrorDetails(exception.getMessage(),request.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ErrorDetails> handleException(BookException exception, WebRequest request) {
	ErrorDetails details = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	HttpHeaders headers, HttpStatus status, WebRequest request) {

	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getFieldErrors()
	.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
