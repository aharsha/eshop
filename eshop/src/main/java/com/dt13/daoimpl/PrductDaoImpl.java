package com.dt13.daoimpl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dt13.dao.ProductDao;
import com.dt13.model.Product;
@Component
//@Repository
public class PrductDaoImpl implements ProductDao {
@Autowired
SessionFactory sessionFactory;


public void testSessionFactory()
{
	System.out.println("testing sessionfactory"+sessionFactory);
}

	@Override
	public void addProduct(Product product) {
		
		
		Session  session=sessionFactory.openSession();

		session.save(product);
Transaction transaction=session.beginTransaction();
transaction.commit();
session.close();
	}

	@Override
	public List<Product> getProducts() {

Session session=sessionFactory.openSession();
Query query = session.createQuery("from Product");
List<Product> proList = query.list();		
session.close();
return proList;
	}

	@Override
	public Product getProduct(int productId) {

Session session=sessionFactory.openSession();
Product product=session.get(Product.class,productId);
session.close();		
return product;
	}

}
