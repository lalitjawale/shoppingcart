package com.neo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neo.model.CartBean;
import com.neo.model.CartItemBean;

@Controller
public class CartController 
{
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart()
	{
		return new ModelAndView("shoppingCartpage");
	}

	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ModelAndView addToCart(@ModelAttribute("products")CartItemBean cartItemBean ,HttpServletRequest request)
	{
						//System.out.println("object given to add to cart " +cartItemBean);
					
						  HttpSession session = request.getSession();
						  String strModelNo = cartItemBean.getPartNumber();
						  String strDescription = cartItemBean.getModelDescription();
						  double strPrice = cartItemBean.getUnitCost();
						  int strQuantity = cartItemBean.getQuantity();
						  ArrayList<CartItemBean> list=null;
						  HashMap<Integer, Integer> hashMapObjet=null;
						
						  CartBean   cartBean =null;
						 Object objCartBean = session.getAttribute("cart");
						
						  //add item to cart if adding products for first time
						  if(objCartBean==null)
							  {
							 
									  //initialise the arraylist
									list = new ArrayList<CartItemBean>();
										  
									 //initialise bean object
									 cartBean = new CartBean();
									 list.add(cartItemBean);
									 System.out.println("list size for the first time " +list.size() +" and ibdex of the item " +list.indexOf(cartItemBean));
									 session.setAttribute("list", list);
									 session.setAttribute("cart", cartBean);
									 cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
									 int index=list.indexOf(cartItemBean);
									 int quan=cartItemBean.getQuantity();
									 	
									 hashMapObjet=new HashMap<>();
									 hashMapObjet.put(index, quan);
									 session.setAttribute("hashMapObjet", hashMapObjet);
							  }
							  
						  else
							 {
							  			 //got session list
										  list=(ArrayList<CartItemBean>) session.getAttribute("list");
										  //chek if item exists already
										  int index=list.indexOf(cartItemBean);
										  
										  //if exists in list
										  if(index != -1)
										  {
											  System.out.println("aleady exits");
											  hashMapObjet=(HashMap<Integer, Integer>) session.getAttribute("hashMapObjet");
											  int q=hashMapObjet.get(index);
											  System.out.println("quantity is  "+q);
											  q++;
											  strQuantity=q;
											  System.out.println("after incresing quantity is  "+strQuantity);
											  hashMapObjet.replace(index, strQuantity);
											  cartBean = (CartBean) objCartBean ;
					  						 	session.setAttribute("cartBean", cartBean);
					  						 	cartBean.updateCartItem(index, strQuantity);
					  						 	session.setAttribute("strQuantity", strQuantity);
					  						 	session.setAttribute("hashMapObjet", hashMapObjet);
					  						 	
											  
											  
										  }
										  
										  else
										  //if do not exists in list
										  {
											  System.out.println("adding for first time");
											  		//add that item to list
											  		list.add(cartItemBean);
											  		
											  		//get index and quantity of that item
											  		int indexOfCartItem=list.indexOf(cartItemBean);
													int quantity=cartItemBean.getQuantity();
													hashMapObjet=(HashMap<Integer, Integer>) session.getAttribute("hashMapObjet");
													hashMapObjet.put(indexOfCartItem, quantity);
													
													session.setAttribute("hashMapObjet", hashMapObjet);
													session.setAttribute("list", list);
													  //session.setAttribute("strQuantity", strQuantity);
													  cartBean = (CartBean) objCartBean ;
													  cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
													  session.setAttribute("strQuantity", quantity);
										 
										  }
										  
																 	
							 }	
						  
						  
						  
						  	return new ModelAndView("productpage");
		 }	
		
	
	
	@RequestMapping( value="/functions" , params="UpdateAction", method=RequestMethod.POST)
	public ModelAndView updateCart(HttpServletRequest request)
	{
		System.out.println("in update" +request.getParameter("quantity"));
		HttpSession session = request.getSession();
		  int strQuantity = Integer.parseInt(request.getParameter("quantity"));
		  int strItemIndex = Integer.parseInt(request.getParameter("itemIndex"));
		  int in=strItemIndex-1;
		  CartBean cartBean = null;
		   
		  Object objCartBean = session.getAttribute("cart");
		  if(objCartBean!=null) 
		  {
			  cartBean = (CartBean) objCartBean ;
			  
		  } 
		  else 
		  {
			  cartBean = new CartBean();
		  }
		  
		  cartBean.updateCartItem(in, strQuantity);
		  System.out.println("after upadate");
		  return new ModelAndView("shoppingCartpage");
	}
	
	
	@RequestMapping( value="/functions" , params="DeleteAction", method=RequestMethod.POST)
	public ModelAndView deleteCart(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		  int strItemIndex = Integer.parseInt(request.getParameter("itemIndex"));
		  CartBean cartBean = null;
		   
		  Object objCartBean = session.getAttribute("cart");
		  if(objCartBean!=null)
		  {
			  	cartBean = (CartBean) objCartBean ;
		  }
		  else
		  {
			  cartBean = new CartBean();
		  }
		  
		  cartBean.deleteCartItem(strItemIndex);
		  return new ModelAndView("shoppingCartpage");
		
	}
	
}
