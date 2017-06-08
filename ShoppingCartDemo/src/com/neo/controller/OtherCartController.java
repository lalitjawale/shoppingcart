package com.neo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.CartBean;
import com.neo.model.CartItemBean;

@Controller
public class OtherCartController
{/*
	@RequestMapping(value="/checkOut")
	public ModelAndView viewChekOutPage()
	{
		return new ModelAndView("index");
	}*/
	
	@RequestMapping(value="/shippingAndBillingAction")
	public ModelAndView viewPaymentModes()
	{
		return new ModelAndView("paymentOption");
	}
	
	@RequestMapping(value="/paymentAction")
	public ModelAndView viewPayment()
	{
		return new ModelAndView("/");
	}
	
}
