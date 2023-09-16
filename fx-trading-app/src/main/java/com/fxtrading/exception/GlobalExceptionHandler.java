package com.fxtrading.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(CurrencyNotFoundException.class)
	public static ResponseEntity<ErrorResponse> handleCurrencyNotFoundException(CurrencyNotFoundException e) {
		logger.error("Exception Occured ... "+e.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCurrencyPairException.class)
	public static ResponseEntity<ErrorResponse> handleInvalidCurrencyPairException(InvalidCurrencyPairException e) {
		logger.error("Exception Occured ... "+ e.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidTradeAmountException.class)
	public static ResponseEntity<ErrorResponse> handleInvalidTradeAmountExceptloion(InvalidTradeAmountException e) {
		logger.error("Exception Occured ..."+e.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CurrencyPairAlreayExistsException.class)
	public static ResponseEntity<ErrorResponse> handleCurrencyPairAlreayExistsException(CurrencyPairAlreayExistsException e) {
		logger.error("Exception Occured ..."+e.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
