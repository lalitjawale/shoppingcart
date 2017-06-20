package com.neo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.Billing;
import com.neo.model.User;

@Controller

public class LoginController 
{

	@RequestMapping(value="/")
	public String testIndex()
	{
		return "indexpage";
		/*new ModelAndView()*/
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("loginpage","user",new User());
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}		
		 return "redirect:/login";
	}

	@RequestMapping(value = "/accessdenied.do", method = RequestMethod.GET)
	public String accessdeniedPage() {
		return "accessdenied";
	}
	
	@RequestMapping("/chek")
	public ModelAndView chekingLogin(HttpServletRequest request,HttpSession session)
	{
		
		System.out.println("after successfull login");
		return new ModelAndView("orderPage","billing",new Billing());
		
		
	}
}
