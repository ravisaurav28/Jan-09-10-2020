package com.synechron.exceptions;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorInformation> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest webRequest) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setDescription(webRequest.getDescription(false));
		errorInformation.setTimestamp(Timestamp.from(Instant.now()));
		errorInformation.setMessage("Account Number " + ex.getMessage() + " not found");
		errorInformation.setStatus(500);
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorInformation> handleInsufficientBalanceException(InsufficientBalanceException ex, WebRequest webRequest) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setDescription(webRequest.getDescription(false));
		errorInformation.setTimestamp(Timestamp.from(Instant.now()));
		errorInformation.setMessage("Insufficient Balance: " + ex.getMessage());
		errorInformation.setStatus(500);
		return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}











