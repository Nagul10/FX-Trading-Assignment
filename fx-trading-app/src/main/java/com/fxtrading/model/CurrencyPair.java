package com.fxtrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CurrencyPair {
	@Id
	private String currencyPair;
	private String baseCurrency;
	private String targetCurrency;
	private double rate;

}
