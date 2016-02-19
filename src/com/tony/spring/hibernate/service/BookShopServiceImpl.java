package com.tony.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.spring.hibernate.dao.BookShopDao;

@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	
	
	/**
	 * Spring hibernate transaction process
	 * 
	 * 1. Before gain method
	 * 	a. Gain Session
	 * 	b. Bind "Session" with current thread, so that can use "SessionFactory" in Dao
	 * 		getCurrentSession() method to get Session
	 * 	c. Starts transaction
	 * 
	 * 2. If method ends normally, then:
	 * 	a. Submit transaction
	 * 	b. Debinding Session from current thread
	 * 	c. Close Session
	 * 
	 * 
	 * 3. If method has "Exception", then:
	 * 	a. Roll back transaction
	 *  b. Debinding Session from current thread
	 * 	c. Close Session
	 * 
	 * 
	 */
	
	@Override
	public void purchase(String username, String isbn) {

		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		bookShopDao.updateBookStock(isbn);
		
		bookShopDao.updateUserAccount(username, price);
		
		
	}

}
