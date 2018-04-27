package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.me.bean.Order;
import com.me.bean.User;
import com.me.dao.OrderDao;

@Controller
public class FinalController {
	@Autowired
	@Qualifier("orderdao")
	OrderDao orderdao;
	@RequestMapping(value="/final.htm")
public ModelAndView vieworder(HttpServletRequest r)
{
	HttpSession s=r.getSession();
	User u=(User)s.getAttribute("user");
	String username=u.getUsername();
	int userid=u.getUserId();
      List<Order> ul=orderdao.getOrdr(username,userid);
     return new ModelAndView("viewcart","orderlist",ul);
	
	}
}
