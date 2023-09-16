package com.fxtrading.exception;

public class CurrencyPairAlreayExistsException extends RuntimeException{
	public CurrencyPairAlreayExistsException() {
	}
	
	public CurrencyPairAlreayExistsException(String currencyPair) {
		super("Currency pair Already Exists !!! -> " + currencyPair);
	}

}
