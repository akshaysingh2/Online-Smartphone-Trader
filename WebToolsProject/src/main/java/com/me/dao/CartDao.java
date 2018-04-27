package com.me.dao;

import org.hibernate.Session;

import com.me.bean.Cart;

public class CartDao extends Dao {
	public Cart getCartByCartId(String CartId) {
	
		Cart cart = (Cart) getSession().get(Cart.class, CartId);
		// System.out.println(cart.getCartId() + " " + cart.getCartItem());
		System.out.println(cart);
		close();
		return cart;

	}
}
