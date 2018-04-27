package com.me.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.me.bean.Cart;

import com.me.bean.Product;
import com.me.bean.User;
import com.me.dao.CartItemDao;
import com.me.dao.OrderDao;
import com.me.dao.ProductDao;
import com.me.dao.UserDao;
import com.me.bean.CartItem;
import com.me.bean.Order;


@Controller
public class CartController {
@Autowired
@Qualifier("productdao")
ProductDao productdao;
@Autowired
@Qualifier("userdao")
UserDao userdao;
@Autowired
@Qualifier("cartitemdao")
CartItemDao cartitemdao;
@Autowired
@Qualifier("orderdao")
OrderDao orderdao;

	@RequestMapping(value="/cart")
	protected ModelAndView viewcart(@ModelAttribute("product") Product product,HttpServletRequest r,HttpServletResponse re)
	{
		HttpSession s=r.getSession();
		if(s.getAttribute("user")==null)
		{
			return new ModelAndView("login");
		}
		else {
		String[] cartval=r.getParameterValues("cartval");
		List<Product> productlist=productdao.getAllProducts();
		HttpSession session=r.getSession();
		session.setAttribute("productu", productlist);
		return new ModelAndView("UserProductView");
		}
		
	}
	/*@RequestMapping(value="/cart/view", method=RequestMethod.GET)
	protected @ResponseBody ModelAndView addcart(@PathVariable(value="val") int productId, @ModelAttribute("product") Product product,HttpServletRequest r,HttpServletResponse re)
	{ int x=productId;
	
		String btn=r.getParameter("cartval");
		if(btn!=null)
		{
			System.out.println(x);
		}
		
		product=productdao.getProductById(productId);
		HttpSession session=r.getSession();
		session.setAttribute("product", product);
		return new ModelAndView();
		
		
	}*/
	@RequestMapping(value="/cart/view")
	public @ResponseBody ModelAndView viewcart(@RequestParam("val") int val,@ModelAttribute("product")Product product,HttpServletRequest r,HttpServletResponse re)
	{
		System.out.println("The value of productid is"+val);
		product=productdao.getProductById(val);
		HttpSession s=r.getSession();
		s.setAttribute("productabc", product);
		return new ModelAndView("cvproduct","productdekh",product);
	}
	@RequestMapping(value="/cart/confirmbooking" ,method=RequestMethod.POST)
	public ModelAndView finalcart(@ModelAttribute("user")User user,@ModelAttribute("product")Product product,@ModelAttribute("cart") Cart cart,HttpServletRequest r,HttpServletResponse re)
	{
		
		String q=r.getParameter("quantity");
		int x=Integer.parseInt(q);
		String submitval=r.getParameter("productsubmit");
		HttpSession s=r.getSession();
		user=(User)s.getAttribute("user");
		String username=user.getUsername();
		int userid=user.getUserId();
		
	
		product=(Product)s.getAttribute("productabc");
		String f=product.getPname();
		int pid=product.getProductId();
		System.out.println(f);
		
		
		Cart c=new Cart();
		//List<CartItem>ci=c.getCartItem();
		//if(ci.isEmpty())
		//{
		/*	List<CartItem> ci=new ArrayList<CartItem>();
			 product = productdao.getProductById(pid);
			 CartItem cartitem=new CartItem();
			 cartitem.setProduct(product);
			 cartitem.setPrice(product.getPrice());
			 cartitem.setQuality(x);
			 ci.add(cartitem);
			 cartitemdao.addcartitem(cartitem);
			 cart.setCartItem(ci);
			 s.setAttribute("finalcart", cartitem);
		}*///	
		/*else
		{
			ci=c.getCartItem();
			 product = productdao.getProductById(pid);
			 CartItem cartitem=new CartItem();
			 cartitem.setProduct(product);
			 cartitem.setPrice(product.getPrice());
			 cartitem.setQuality(x);
			 ci.add(cartitem);
			 cartitemdao.addcartitem(cartitem);
			 cart.setCartItem(ci);
			 s.setAttribute("finalcart", cartitem);
		}*/
	/* product = productdao.getProductById(pid);
	 CartItem cartitem=new CartItem();
	 cartitem.setProduct(product);
	 cartitem.setPrice(product.getPrice());
	 cartitem.setQuality(x);
	 ci.add(cartitem);
	 cartitemdao.addcartitem(cartitem);
	 cart.setCartItem(ci);*/
	// s.setAttribute("finalcart", cartitem);
	 
	 
	 
		//user.setCart(cart);
		int y=product.getPrice();
		int totalprice=x*y;
		HttpSession u=r.getSession();
		u.setAttribute("tp", totalprice);
		
		String z=product.getStock();
		Order order=new Order();
		order.setOrderquantity(x);
		order.setPrice(totalprice);
		order.setUsername(username);
		order.setProductname(product.getPname());
		order.setUserid(userid);
		orderdao.createorder(order);
		
		//int x=Integer.parseInt(z);
		//int available=x-quantity;
		
		
		
		return new ModelAndView("thankyou");
	
		
	}
	/*@RequestMapping(value="/cart/view")
	public ModelAndView addCartItem(@RequestParam("val") int productId,HttpServletRequest r,HttpServletResponse re) {
		HttpSession s=r.getSession();
		User user=(User)s.getAttribute("user");
		String email=user.getEmailId();
		String password=user.getPassword();
		User customer =userdao.getUser(email, password);
		
		
		Cart cart=customer.getCart() ;
	 s.setAttribute("usercart", cart);
	 if(null!=s.getAttribute("usercart"))
	 {
		 cart=(Cart)s.getAttribute("usercart");
	 }
	 else
	 {
		 cart=new Cart();
		 
		 
	 }
		System.out.println(cart);
		List<CartItem> cartItems = cart.getCartItem();
		Product product = productdao.getProductById(productId);
		if(cartItems!=null && !cartItems.isEmpty()) {
		for (int j=0; j < cartItems.size(); j++) {
			CartItem cartItem = cartItems.get(j);
			if (product.getProductId()==(cartItem.getProduct().getProductId())) {
				cartItem.setQuality(cartItem.getQuality() + 1);
				cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getPrice());
				cartitemdao.addcartitem(cartItem);
				
			}
		}}
		else {
		CartItem cartItem = new CartItem();
		cartItem.setQuality(1);
		cartItem.setProduct(productdao.getProductById(productId));
		cartItem.setPrice(product.getPrice() * 1);
		cartItem.setCart(cart);
		cartitemdao.addcartitem(cartItem);
	 s.setAttribute("cart", cartItem);}
	 return new ModelAndView("hola");
	}*/
}
