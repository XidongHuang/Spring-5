package com.tony.spring.hibernate.service;

import java.util.List;

public interface Cashier {

	public void checout(String username, List<String> isbns);
}
