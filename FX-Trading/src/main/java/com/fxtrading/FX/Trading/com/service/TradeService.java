package com.fxtrading.FX.Trading.com.service;

import org.springframework.stereotype.Service;

import com.fxtrading.FX.Trading.com.entity.Trade;

@Service
public class TradeService {
	public String bookTrade(Trade trade) {
		String message;
		String bookMessage;
		if(!trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
//			trade.setMessage("Invalid Currency Pair Trade Not Booked");
			return null;
		}
		trade.setTransferredAmount(trade.getAmountToTransfer()*trade.getUSDINR());
		if(trade.getRate().equals("yes")) {
			message="\nYou are transferring INR "+trade.getTransferredAmount()+" to "+trade.getCustomerName();
		} else {
			message="";
		}
		if(trade.getConfirmation().equals("book")) {
		bookMessage = "\nTrade for "+trade.getCurrencyPair()+" has been booked with rate "+trade.getUSDINR()+
				" , The amount of INR "+trade.getTransferredAmount()+" will be transferred in 2 working days to "+trade.getCustomerName();
	
		} else {
			bookMessage = "\nBooking Cancelled";
		}
		//trade.setMessage(message+bookMessage);
		return message+bookMessage;
	}
}
