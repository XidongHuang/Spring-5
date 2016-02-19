package com.tony.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	@Override
	public void checout(String username, List<String> isbns) {

		for(String isbn: isbns){
			
			bookShopService.purchase(username, isbn);
			
		}
		
		
	}

}
