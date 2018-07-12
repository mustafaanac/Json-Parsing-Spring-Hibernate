package com.dovizparser.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dovizparser.entity.Kurlar;

@Repository
public class KurlarDAOImpl implements KurlarDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Kurlar> getKurlar() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Kurlar> theQuery = currentSession.createQuery("from Kurlar", Kurlar.class);

		List<Kurlar> kurlar = theQuery.getResultList();

		return kurlar;
	}

/*	@Override
	public void saveKurlar(Kurlar theKurlar) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theKurlar);
	}*/

	@Override
	public void saveKurlar(Kurlar theKurlar) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theKurlar);		
		
	}

	

}
