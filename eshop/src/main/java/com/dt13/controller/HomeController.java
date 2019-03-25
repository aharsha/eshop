package com.dt13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dt13.dao.ProductDao;
import com.dt13.dao.UserDao;
import com.dt13.model.Product;
import com.dt13.model.UserDetails;

@Controller
public class HomeController {
	@Autowired
	ProductDao pdaoImpl;
	
	@Autowired
	UserDao userDao;
	
	
public HomeController() {
	System.out.println("from Home Controller");
}
	
	@RequestMapping("/home")
	public String goAdminHome()
	{
		//PrductDaoImpl daoImpl=new PrductDaoImpl();
		pdaoImpl.addProduct(new Product());
		
		return "AdminHome";
	}
	
	@RequestMapping("/register")
	public ModelAndView goToRegForm()
	{
		ModelAndView mv=new ModelAndView("register","user",new UserDetails());
		return mv;
	}
	
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") UserDetails userDetails)
	{
		System.out.println(userDetails.getEmail());
		System.out.println(userDetails.getMobile());
	
		userDao.addUser(userDetails);
		
		return "redirect:/";
	}
	
}
