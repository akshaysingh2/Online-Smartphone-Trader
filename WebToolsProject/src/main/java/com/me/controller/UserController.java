package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.UserDao;
import com.me.validator.Validation;
import com.me.bean.User;

@Controller

public class UserController {

	 @Autowired
	 @Qualifier("userdao")
	 UserDao userdao;
	 @Autowired
		@Qualifier("validation")
		Validation validation;

		@InitBinder
		private void InitBinder(WebDataBinder binder) {
			binder.setValidator(validation);
		}
	// @RequestMapping(value="/user/add",method = RequestMethod.GET)
/*	protected ModelAndView addUser() throws Exception {
		 User user1=new User();
			return new ModelAndView("register", "user", user1);
		}*/
	 
	 @RequestMapping(value="/user/add", method = RequestMethod.POST)
		public ModelAndView adduser(@ModelAttribute("user") User user,HttpServletRequest r,HttpServletResponse re,BindingResult result)  {
		 validation.validate(user, result);
			if(result.hasErrors()) {
				return new ModelAndView("error", "user",user);
			}
			userdao.createuser(user);
				
			HttpSession x=r.getSession();
			x.setAttribute("user", user);
			return new ModelAndView("registersuccess","user", user);
			
		
		

		}
		
	 @RequestMapping(value="/user/logout" ,method=RequestMethod.POST)
	 public ModelAndView logout(HttpSession session) {
		 
		 session.invalidate();
		 
		 return new ModelAndView("index");
	 } 

	}
	
