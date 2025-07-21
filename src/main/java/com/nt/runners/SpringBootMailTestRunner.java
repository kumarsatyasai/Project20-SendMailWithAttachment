package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseOrderMgmtService;

@Component
public class SpringBootMailTestRunner implements CommandLineRunner {

	@Autowired
	private IPurchaseOrderMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {

		String msg = service.purchase(new String[] {"Shirt","Trouser","Hat"}, new Double[] {5000.00d, 6000.00d,8000.00d}, new String[] {"tulasikumarkande@gmail.com","suryavarmaroyality@gmail.com","issapurisreeharshavardhan@gmail.com","balajigummalla11@gmail.com"});
		System.out.println(msg);
	}

}
