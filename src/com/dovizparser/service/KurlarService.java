package com.dovizparser.service;

import java.util.List;

import com.dovizparser.entity.Kurlar;

public interface KurlarService {
	
	public List<Kurlar> getKurlar();
	
	public void saveKurlar(Kurlar theKurlar);

	//public void saveKurlar(List<Kurlar> doviz);

	
}
