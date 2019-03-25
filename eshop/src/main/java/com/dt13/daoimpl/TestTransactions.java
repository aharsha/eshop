package com.dt13.daoimpl;

import com.dt13.model.Product;

public class TestTransactions {

	public static void main(String[] args) {

		PrductDaoImpl daoImpl=new PrductDaoImpl();
		daoImpl.addProduct(new Product());
		
	}

}
