package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.bean.Product;
import com.me.bean.User;
import com.me.dao.ProductDao;

@Controller
@RequestMapping(value="admin/addp")
public class ProductController {

	@Autowired
	@Qualifier("productdao")
	ProductDao productdao;
	
	@RequestMapping(value="admin/addp" ,method = RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("p") Product p ,HttpServletRequest r,HttpServletResponse re)
	{
		
		String name=r.getParameter("pname");
		String brand=r.getParameter("brand");
		String price=r.getParameter("price");
		String stock=r.getParameter("stock");
		p.setBrand(brand);
		p.setPname(name);
		p.setPrice(Integer.parseInt(price));
		p.setStock(stock);
		productdao.createproduct(p);
		HttpSession s=r.getSession();
	
		return new ModelAndView("productsuccess");
		
		
	}
	@RequestMapping(value="/viewp")
	public ModelAndView viewproduct(HttpServletRequest r,HttpServletResponse re) {
		List<Product> productlist=productdao.getAllProducts();
		HttpSession session=r.getSession();
		session.setAttribute("productl", productlist);
		return new ModelAndView("viewproduct");
		
	}

}
