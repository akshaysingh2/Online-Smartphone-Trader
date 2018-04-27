package com.me.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.bean.Product;
import com.me.bean.Cart;
import com.me.bean.CartItem;

public class CartItemDao extends Dao {
	public CartItem addcartitem(CartItem ci) {
		begin();
		
			getSession().save(ci);
			
        
        commit();
        return ci;
    } 

}
