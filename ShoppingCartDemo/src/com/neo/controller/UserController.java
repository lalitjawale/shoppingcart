package com.neo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.User;
import com.neo.service.UserService;




@Controller
public class UserController 
{
	@Autowired
	 UserService  userService;
	
	
	@RequestMapping(value="/register")
	public ModelAndView registerView()
	{
		System.out.println("Welcome to registeration...");
		return  new ModelAndView("registerpage","users",new User());
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("User") User user)
	{
		System.out.println("In controller to register new user..");
		userService.create(user);
		System.out.println("after query ");
		return new ModelAndView("indexpage","employee",new User());
	}
	
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	 public String accessDenied(ModelMap model, Principal principal) 
	{
	  String username = principal.getName();
	  model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
	  return "403";
	 }

	

	}
	