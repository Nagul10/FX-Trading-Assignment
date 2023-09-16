package com.fxtrading.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CurrencyNotFoundException extends RuntimeException {
	public CurrencyNotFoundException() {

	}
	
	public CurrencyNotFoundException(String currencyPair){
		super("Invalid Currency Pair !!! -> "+currencyPair);
	}
}
