package com.dovizparser.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dovizparser.entity.Kurlar;

public class DaoFactory {

	public void save(Kurlar kurlar) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(kurlar);
		session.getTransaction().commit();
	}

	public void truncate() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("truncate table dovizkuru").executeUpdate();
		tx.commit();

	}

}
