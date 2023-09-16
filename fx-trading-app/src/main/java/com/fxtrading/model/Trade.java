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
public class Trade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeId;
	private String customerName;
	private String currencyPair;
	private double sentAmount;
	private double transferredAmount;
	
}
