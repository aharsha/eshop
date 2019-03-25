package com.dt13.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/Login")
	public String goToLoginForm()
	{
		return "Login";
	}
	
	@RequestMapping("/on_login_success")
	public String onLoginSuccess(HttpSession session)
	{
		//get Authentication object to get login user 

Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
//get login user 	
String un=authentication.getName();
		
	session.setAttribute("uname",un);

	Collection<GrantedAuthority> list=	(Collection<GrantedAuthority>)authentication.getAuthorities();
	String page="";
	for(GrantedAuthority authoritie:list)
	{
		if(authoritie.getAuthority().equals("ROLE_USER"))
		{
			page="guesthome";
		}
		else
		{
			page="AdminHome";
		}
	}
	return page;
	}
	}
	

