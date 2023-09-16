package com.fxtrading.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Service;

import com.fxtrading.dao.CurrencyPairDao;
import com.fxtrading.dao.TradeDao;
import com.fxtrading.exception.CurrencyNotFoundException;
import com.fxtrading.exception.GlobalExceptionHandler;
import com.fxtrading.exception.InvalidCurrencyPairException;
import com.fxtrading.exception.InvalidTradeAmountException;
import com.fxtrading.model.CurrencyPair;
import com.fxtrading.model.Trade;

@Service
public class TradeService {
	
	Logger logger = LoggerFactory.getLogger(TradeService.class);
	
	TradeDao tradeDao;
	CurrencyPairService currencyPairService;
	CurrencyPairDao currencyPairDao;
	
	@Autowired
	public TradeService (TradeDao tradeDao,CurrencyPairService currencyPairService,CurrencyPairDao currencyPairDao) {
		this.tradeDao = tradeDao;
		this.currencyPairService = currencyPairService;
		this.currencyPairDao = currencyPairDao;
	}
	
	public List<Trade> getAllTrades () {
		return tradeDao.getAllTrades();
	}
	
	public String bookTrade (Trade trade) {
		CurrencyPair currencyPair = null;
		if(currencyPairService.isValidCurrencyPair(trade.getCurrencyPair())) {
			currencyPair = currencyPairDao.getCurrencyPair(trade.getCurrencyPair());
		} else {
			throw new CurrencyNotFoundException(trade.getCurrencyPair());
		}
		if(trade.getSentAmount()<=0) {
			throw new InvalidTradeAmountException(trade.getSentAmount());
		}
		trade.setTransferredAmount(trade.getSentAmount()*currencyPair.getRate());
		tradeDao.bookTrade(trade);
		return "Trade Booked";
	}

}
