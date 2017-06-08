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

/*@Controller*/
public class OtherCartController
{
	/*private List<CartItemBean> cartItemBeanList=new ArrayList();
*/
	/*@RequestMapping("/viewCart")
	public ModelAndView viewCart()
	{
		return new ModelAndView("ShoppingCart");
	}
	*/
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ModelAndView addToCart(@ModelAttribute("products")CartItemBean cartItemBean ,HttpServletRequest request)
	{
		System.out.println("in controller");
	CartBean cartBean=new CartBean();
		List<CartItemBean> cartItemBeanList=cartBean.getCartItems();
		if(cartItemBeanList.indexOf(cartItemBean)== -1)
		{
			System.out.println();
			cartItemBeanList.add(cartItemBean);
		}
		else
		{
			int quantity=cartItemBean.getQuantity();
			quantity++;
			cartItemBean.setQuantity(quantity);
			System.out.println(cartItemBean.getQuantity());
			
		}
		
		/*System.out.println(cartItemBean);
		if(cartItemBeanList.indexOf(cartItemBean)== -1)
		{
			System.out.println();
			cartItemBeanList.add(cartItemBean);
		}
		else
		{
			int quantity=cartItemBean.getQuantity();
			quantity++;
			cartItemBean.setQuantity(quantity);
			System.out.println(cartItemBean.getQuantity());
			
		}
	*/	
		return new ModelAndView("products");
	
	}
	
}
