package com.fxtrading.FX.Trading.com.entity;

import java.util.HashMap;


public class Trade {
	private String customerName;
    private String currencyPair;
    private double amountToTransfer;
    private String rate;
    private double transferredAmount;
    private String confirmation;
    private final double usdintr = 66;
    private static HashMap<String,Double> exchangeRate = new HashMap<>();
    
	public Trade() {
        exchangeRate.put("USDINR",66.00);

	}


	public Trade(String customerName, String currencyPair, double amountToTransfer, String rate, String confirmation) {
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amountToTransfer = amountToTransfer;
		this.rate = rate;
		this.confirmation = confirmation;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCurrencyPair() {
		return currencyPair;
	}
	
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	
	public double getAmountToTransfer() {
		return amountToTransfer;
	}
	
	public void setAmountToTransfer(double amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}
	
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	
	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	public Double getUSDINR() {
		return usdintr;
	}


	@Override
	public String toString() {
		return "Trade ["
				+ "customerName=" + customerName + ", currencyPair=" + currencyPair 
				+ ", amountToTransfer=" + amountToTransfer + ", rate=" + rate + ", "
				+ "transferredAmount=" + transferredAmount + ", confirmation=" + confirmation + "]";
	}



//	public void bookTrade(Trade trade) {
//		trade.setTransferredAmount(trade.amountToTransfer*exchangeRate.get(getCurrencyPair()));
//		if(trade.getRate().equals("yes")) {
//			message="\nYou are transferring INR "+transferredAmount+" to "+customerName;
//		} else {
//			message="";
//		}
//		if(trade.getConfirmation().equals("book")) {
//		bookMessage = "Trade for "+currencyPair+" has been booked with rate "+exchangeRate.get(currencyPair)+
//				" , The amount of INR "+transferredAmount+" will be transferred in 2 working days to "+customerName;
//	
//		} else {
//			bookMessage = "Booking Cancelled";
//		}
//	}
	
	

//	public String displayTrade() {
//		return "Trade Confirmed \n"
//				+ "customerName= " + customerName + 
//				"\ncurrencyPair= " + currencyPair + 
//				"\namountToTransfer= " + amountToTransfer + 
//				  message;
//	}
    
    

}
