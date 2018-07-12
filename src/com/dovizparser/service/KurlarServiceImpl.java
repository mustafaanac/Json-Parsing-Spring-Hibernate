package com.dovizparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dovizparser.dao.KurlarDAO;
import com.dovizparser.entity.Kurlar;

@Service
public class KurlarServiceImpl implements KurlarService {

	@Autowired
	private KurlarDAO kurlarDAO;

	public KurlarServiceImpl(KurlarDAO kurlarDAO) {
		this.kurlarDAO = kurlarDAO;
	}

	@Override
	@Transactional
	public List<Kurlar> getKurlar() {

		return kurlarDAO.getKurlar();
	}

	@Override
	@Transactional
	public void saveKurlar(Kurlar theKurlar) {

		kurlarDAO.saveKurlar(theKurlar);

	}

}
