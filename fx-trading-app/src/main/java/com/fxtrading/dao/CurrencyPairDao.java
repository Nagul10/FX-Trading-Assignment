package com.fxtrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxtrading.model.CurrencyPair;

@Repository
public class CurrencyPairDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<CurrencyPair> getAllCurrencyPairs() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();
	}

	public String addCurrency(CurrencyPair currency) {
		Session session = sessionFactory.openSession();
		session.save(currency);
		session.beginTransaction().commit();
		return null;
	}

	public CurrencyPair getCurrencyPair(String currencyPair) {
		Session session = sessionFactory.openSession();
		Criteria criteria =session.createCriteria(CurrencyPair.class);
		criteria.add(Restrictions.eq("currencyPair", currencyPair));
		return (CurrencyPair) criteria.list().get(0);
	}

}
