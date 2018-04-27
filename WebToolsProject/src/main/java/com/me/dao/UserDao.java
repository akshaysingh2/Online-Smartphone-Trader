package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.bean.User;
import com.me.bean.Cart;

public class UserDao extends Dao {
	public User createuser(User user)
	{
		try {
		//	Cart cart = new Cart();
	        begin();
	      //  cart.setUser(user);
			//user.setCart(cart);
	        getSession().save(user);
	        
	        
			//it is to set CartId for customer table
			//user.setCart(cart);//set the cart to the customer
			//if we omit this statement, hen it will insert null for customerid in cart
			//to set the customerid in cart table
			
			
	        commit();
	        return user;
	    } catch (HibernateException e) {
	        rollback();
	        //throw new AdException("Could not create the category", e);
	        throw new HibernateException("Exception while creating category: " + e.getMessage());
	    }

		}
	public User getUser(String emailId,String password) {
		
	         begin();
	         System.out.println("inside actress DAOOOOO");
	        
	         Query q = getSession().createQuery("from usersfinalpro where emailId = :emailId and password = :password");
	         q.setString("emailId",emailId);
	         q.setString("password",password);
	         User user = (User)q.setMaxResults(1).uniqueResult();
	         
	         commit();
	        
	         return user;
	     	 	
	    }
	public List<User> getAllUsers() {
		begin();
		//List<Product> products = session.createQuery("from Product").list();
		Query q = getSession().createQuery("from usersfinalpro");
	 List<User> users=q.list();
	
	 commit();
		
		return users;
	}
}
