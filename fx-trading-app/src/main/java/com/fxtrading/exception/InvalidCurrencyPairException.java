package com.fxtrading.exception;

public class InvalidCurrencyPairException extends RuntimeException {
	public InvalidCurrencyPairException() {
	}
	
	public InvalidCurrencyPairException(String currencyPair) {
		super("Invalid Currency Pair !!! -> "+ currencyPair);
	}
}
