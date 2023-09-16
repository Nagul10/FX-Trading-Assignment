package com.fxtrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtrading.dao.CurrencyPairDao;
import com.fxtrading.exception.CurrencyPairAlreayExistsException;
import com.fxtrading.exception.InvalidCurrencyPairException;
import com.fxtrading.model.CurrencyPair;

@Service
public class CurrencyPairService {
	@Autowired
	CurrencyPairDao currencyPairDao;
	
	public String addCurrency (CurrencyPair currency) {
		if(isAlreadyExist(currency.getCurrencyPair())) {
			throw new CurrencyPairAlreayExistsException(currency.getCurrencyPair());
		} else {
			return currencyPairDao.addCurrency(currency);
		}
	}
	
	public boolean isValidCurrencyPair (String currencyPair) {
		List<CurrencyPair> allCurrencyPairs = currencyPairDao.getAllCurrencyPairs();
		if(currencyPair.length()!=6) {
			throw new InvalidCurrencyPairException(currencyPair);
		} else {
			for(CurrencyPair currency:allCurrencyPairs) {
				if(currency.getCurrencyPair().equalsIgnoreCase(currencyPair)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isAlreadyExist (String currencyPair) {
		List<CurrencyPair> allCurrencyPairs = currencyPairDao.getAllCurrencyPairs();
		for(CurrencyPair currency:allCurrencyPairs) {
			if(currency.getCurrencyPair().equalsIgnoreCase(currencyPair)) {
				return true;
			}
		}
		return false;
	}
	
}
