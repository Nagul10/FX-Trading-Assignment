package com.fxtrading.dao;

import java.util.Currency;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxtrading.model.CurrencyPair;
import com.fxtrading.model.Trade;

@Repository
public class TradeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void bookTrade(Trade trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
	}

	public List<Trade> getAllTrades() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();
	}

}
