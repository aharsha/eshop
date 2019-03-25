package com.dt13.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt13.dao.UserDao;
import com.dt13.model.UserDetails;
@Component
public class UserDaoImpl implements UserDao
{
@Autowired
SessionFactory  sessionFactory;
	@Override
	public void addUser(UserDetails userDetails) {

Session session=sessionFactory.openSession();
		
session.save(userDetails);
Transaction transaction=session.beginTransaction();
transaction.commit();
session.close();	
	}

}
