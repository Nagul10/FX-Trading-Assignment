package com.fxtrading.FX.Trading.com.controller;

import java.util.ArrayList;
import java.util.List;

import com.fxtrading.FX.Trading.com.entity.Trade;
import com.fxtrading.FX.Trading.com.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradeController {
	@Autowired
	TradeService tradeService;
	private List<Trade> trades = new ArrayList<>();
	
	@PostMapping("/booktrade")
	public String recieveTradeS(@RequestBody Trade trade) {
		String message;
		message = tradeService.bookTrade(trade);
		if(message!=null) {
			trades.add(trade);
			message = "Trade Details \n"+message;
			} else {
			message = "Invalid Currency Pair Trade Not Booked";
			
		}
		return message;
	}
	
	@GetMapping("/print_trade")
	public List<Trade> getAllTrades() {
		return trades;
	}

}
