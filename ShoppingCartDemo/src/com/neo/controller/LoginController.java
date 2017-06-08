package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.User;



@Controller
public class LoginController 
{
	
	@RequestMapping(value="/logintest" ,method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username)
	{
		
		return new ModelAndView("homePage");
		
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView test()
	{
		System.out.println("chek loginView");
		return new ModelAndView("login","users",new User());
	}
}
