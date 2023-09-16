package com.fxtrading.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtrading.model.CurrencyPair;
import com.fxtrading.model.Trade;
import com.fxtrading.service.TradeService;

@RestController
public class TradeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);
	
	@Autowired
	TradeService tradeService;
	
	@GetMapping("get-all-trade")
	public List<Trade> getAllTrades () {
		logger.info("Recieved a GET request to 'get-all-trades'");
		return tradeService.getAllTrades();
	}
	
	@PostMapping("book-trade")
	public String bookTrade(@RequestBody Trade trade) {
		logger.info("Recieved a GET request to 'book-trade'");
		return tradeService.bookTrade(trade);
		
	}
}
