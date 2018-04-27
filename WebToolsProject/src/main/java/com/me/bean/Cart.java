package com.me.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.me.bean.CartItem;

@Entity
@Table(name="ShoppingCart")
public class Cart {
@Column(name="productname")
private String productname;
@Id
@GeneratedValue
@Column(name="cartId")
private String cartId;
@OneToMany
@JoinColumn(name="productId")
private List<Product> product;
@OneToOne(mappedBy="cart")
private User user;
/*@OneToMany(mappedBy="cart")
private List<Order> order;*/
@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
private List<CartItem> cartItem;
public List<CartItem> getCartItem() {
	return cartItem;
}
public void setCartItem(List<CartItem> cartItem) {
	this.cartItem = cartItem;
}
public String getCartId() {
	return cartId;
}
public void setCartId(String cartId) {
	this.cartId = cartId;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
/*public List<Order> getOrder() {
	return order;
}
public void setOrder(List<Order> order) {
	this.order = order;
}*/
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
}
