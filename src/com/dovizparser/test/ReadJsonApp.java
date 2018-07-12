package com.dovizparser.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dovizparser.entity.Kurlar;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonApp implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		System.out.println("HelloWorld Listener has been shutdown");

	}

	

	
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		try {
			Kurlar kurlar = new Kurlar();
			List<Kurlar> theKurlar = new ArrayList<>();

			URL jsonUrl = new URL("https://www.doviz.com/api/v1/currencies/all/latest");
			ObjectMapper objmapper = new ObjectMapper();
			theKurlar = objmapper.readValue(jsonUrl, new TypeReference<ArrayList<Kurlar>>() {
			});

			DaoFactory factory = new DaoFactory();
			factory.truncate();
			int cnt = 0;
			for (int i = 0; i < 3; i++) {

				System.out.println(theKurlar.get(cnt).getName());
				System.out.println(theKurlar.get(cnt).getBuying());
				System.out.println(theKurlar.get(cnt).getSelling());

				kurlar.setName(theKurlar.get(cnt).getName());
				kurlar.setBuying(theKurlar.get(cnt).getBuying());
				kurlar.setSelling(theKurlar.get(cnt).getSelling());

				factory.save(kurlar);

				cnt++;
			}

		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}


		TimerTask vodTimer = new VodTimerTask();

		Timer timer = new Timer();
		timer.schedule(vodTimer, 10000, (10000*150000));

	}

	class VodTimerTask extends TimerTask {

		@Override
		public void run() {
			contextInitialized(null);
			System.out.println("TimerTask " + new Date().toString());		}
	}
}

