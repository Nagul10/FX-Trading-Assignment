package com.fxtrading.FX.Trading.com.entity;


public class Trade {
	private String customerName;
    private String currencyPair;
    private double amountToTransfer;
    private String rate;
    private double transferredAmount;
    private String confirmation;
    private final double usdintr = 66;
    
	public Trade() {

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

}
