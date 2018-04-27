package com.me.controller;



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


import com.me.bean.User;
import com.me.dao.UserDao;

@Controller
@RequestMapping("home.htm")
public class Homecontroller {
	 @Autowired
	 @Qualifier("userdao")
	 UserDao userdao;
	
	@RequestMapping(value="/home.htm",method = RequestMethod.POST)
	protected ModelAndView abc(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") User user)  {
	ModelAndView mv=null;
		String check=request.getParameter("Yes");
		System.out.println(check);
		String subr=request.getParameter("subr");
		String email=request.getParameter("email");
		String pass=request.getParameter("pwd");
		String sub=request.getParameter("sub");
		
		if(null!=check && null!=subr) {
		mv=new ModelAndView("register","user",new User());

	}
		else if (email!=null && pass!=null && sub!=null) {

	          	System.out.println("inside title");
	               user = userdao.getUser(email, pass);
	               if(user==null)
	               {
	            	   return new ModelAndView("error");
	               }
	               else if(email.equals("admin@xyz.com")&&(pass.equals("admin"))&& sub!=null)
	               {
	            	   return new ModelAndView("AdminWork");
	               }
	               HttpSession x=request.getSession();
	   			x.setAttribute("user", user);
	          	 mv=new ModelAndView("index");
	          	   }
		
		else 
		{
			mv=new ModelAndView("error");
		}
		
		
		return mv;
}
	@RequestMapping(value="/home.htm",method = RequestMethod.GET)
	public ModelAndView validateUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") User user)
	{
		ModelAndView mv=null;
		 
          	 mv=new ModelAndView("AdminWork");
          	 return mv;
	}
	
}