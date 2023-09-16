package com.fxtrading.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fxtrading.model.CurrencyPair;
import com.fxtrading.service.CurrencyPairService;

@RestController
public class CurrencyPairController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyPairController.class);
	
	@Autowired
	CurrencyPairService currencyPairService;
	
	@PostMapping("add-currency")
	public String addCurrency (@RequestBody CurrencyPair currency) {
		logger.info("Recieved a GET request to 'add-currency'");
		return currencyPairService.addCurrency(currency);
	}

}
