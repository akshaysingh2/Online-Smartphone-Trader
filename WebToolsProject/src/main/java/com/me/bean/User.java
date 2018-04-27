package com.me.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@javax.persistence.Entity(name = "usersfinalpro")
public class User implements Serializable {

	private static final long serialVersionUID = 2681531852204068105L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="emailId")
	private String emailId;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="enabled")
private boolean enabled;
@Column(name="city")
	private String city;
@Column(name="address")
	private String address;
@Column(name="mobileno")
	private String mobileno;
@Column(name="zipcode")
	private String zipcode;
@Column(name="country")
	private String country;

@OneToOne
@JoinColumn(name="cartId")
private Cart cart;

/*@OneToOne
@JoinColumn(name="orderId")
private Order order;*/
	
	public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
/*public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}*/
public static long getSerialversionuid() {
	return serialVersionUID;
}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

	
}
