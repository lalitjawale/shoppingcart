package com.neo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.Billing;
import com.neo.model.User;
import com.neo.service.OrderService;

@Controller
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/placeOrder")
	public ModelAndView loginRegisterView()
	{
		System.out.println("in place order");
		return new ModelAndView("orderPage","billing",new Billing());
	}
	
	@RequestMapping(value="/saveOrderAddress",method=RequestMethod.POST)
	public ModelAndView saveOrder(@ModelAttribute("billing") Billing billing,@RequestParam("id") int id)
	{
		System.out.println("in billing"+billing.getPaymentOption() +"user id in order is "+id);
		String paymentOption=billing.getPaymentOption();
		if(paymentOption.equalsIgnoreCase("cash"))
		{
			Billing billingObject=new Billing();
			billingObject.setFirstName(billing.getFirstName());
			billingObject.setLastName(billing.getLastName());
			billingObject.setEmailId(billing.getEmailId());
			billingObject.setContactNumber(billing.getContactNumber());
			billingObject.setAddress(billing.getAddress());
			billingObject.setCity(billing.getCity());
			billingObject.setState(billing.getState());
			billingObject.setPostalCode(billing.getPostalCode());
			billingObject.setPaymentOption(billing.getPaymentOption());
			
			User user=new User();
			user.setId(id);
			billingObject.setUser(user);
			
			/*user.getBillings().add(billingObject);*/
			
			boolean orderStatus=orderService.saveOrder(billingObject,id);
			if(orderStatus)
				return new ModelAndView("orderSuccessPage","message","Order is Successfull");
			else
				return new ModelAndView("orderPage","message","Please fill up  billing details");
			
		}
		return null;
	}

}
