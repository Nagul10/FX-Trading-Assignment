package com.fxtrading.exception;

public class InvalidTradeAmountException extends RuntimeException{
	public InvalidTradeAmountException() {

	}
	
	public InvalidTradeAmountException(double amount) {
		super("Invalid Amount For Transaction !!! -> "+ amount);
	}
}
