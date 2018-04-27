package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.bean.Product;
import com.me.bean.User;
import com.me.dao.ProductDao;
import com.me.dao.UserDao;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("userdao")
	UserDao userdao;
	
	@Autowired
	@Qualifier("productdao")
	ProductDao productdao;
	
	@RequestMapping(value="/admin")
	public ModelAndView viewuser(@ModelAttribute("user") User user,HttpServletRequest r,HttpServletResponse re) {
		List<User> userList=userdao.getAllUsers();
		HttpSession session=r.getSession();
		session.setAttribute("userl", userList);
		return new ModelAndView("userinfo");
		
	}
	
	@RequestMapping(value="/admin/product")
	public ModelAndView homepageproduct(HttpServletRequest r,HttpServletResponse re)
	{
		return new ModelAndView("AddProduct","p",new Product());
	}
	
	}
