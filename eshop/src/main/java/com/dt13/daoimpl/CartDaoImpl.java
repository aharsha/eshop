package com.dt13.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt13.dao.CartDao;
import com.dt13.model.Cart;

@Component
public class CartDaoImpl implements CartDao
{
@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean addToCart(Cart cart) 
	{
		Session  session=null;
		try
		{
		 session=sessionFactory.openSession();
		session.save(cart);
		Transaction  transaction=session.beginTransaction();
		transaction.commit();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			session.close();
		}
		
	}
	@Override
	public List<Cart> getAllCartItems() {

Session session=sessionFactory.openSession();
Query query=session.createQuery("from Cart");		
List<Cart>  cartList=query.list();
System.out.println(cartList);
session.close();
return cartList;
	}

}
