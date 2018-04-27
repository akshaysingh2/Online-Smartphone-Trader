package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.bean.Order;
import com.me.bean.Product;

public class OrderDao extends Dao {
	public Order createorder(Order order) {
		try {
	        begin();
	        
	        getSession().save(order);
	        commit();
	        return order;
	    } catch (HibernateException e) {
	        rollback();
	        //throw new AdException("Could not create the category", e);
	        throw new HibernateException("Exception while creating order: " + e.getMessage());
	    }

	}
	public List<Order> getOrdr(String username,int userid)
	{ 
		begin();
	Query q = getSession().createQuery("from Order where username=:username and userid=:userid");
	q.setString("username", username);
	q.setInteger("userid", userid);
	 List<Order> orderList=q.list();
	 commit();
	 return  orderList;
	
		
	}
		

}
