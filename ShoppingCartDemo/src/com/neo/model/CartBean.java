package com.neo.model;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.SessionAttributes;

@Scope("session")
public class CartBean
{
	
	private ArrayList<CartItemBean> alCartItems = new ArrayList<CartItemBean>();
	 private double dblOrderTotal ;
	 
	 //setter and getters
	 public ArrayList<CartItemBean> getCartItems()
	 {
	  return alCartItems;
	 }
	 public void setCartItems(ArrayList<CartItemBean> alCartItems)
	 {
	  this.alCartItems = alCartItems;
	 }
	 
	 
	 public double getOrderTotal()
	 {
	  return dblOrderTotal;
	 }
	 
	 
	 public void setOrderTotal(double dblOrderTotal) 
	 {
	  this.dblOrderTotal = dblOrderTotal;
	 }
	  
	 //returns number of items in the cart
	 public int getLineItemCount()
	 {
		  return alCartItems.size();
	 }

	 public void deleteCartItem(int strItemIndex)
	 {
		  int iItemIndex = 0;
		  try 
		  {
		   iItemIndex = (strItemIndex);
		   alCartItems.remove(iItemIndex - 1); //------------------------------removes item from list
		   calculateOrderTotal();
		  } 
		  catch(NumberFormatException nfe) 
		  {
		   System.out.println("Error while deleting cart item: "+nfe.getMessage());
		   nfe.printStackTrace();
		  }
	 }
/*-------------------updates the quantity  and cost-------------------*/		  
		 public void updateCartItem(int index1, int strQuantity) 
		 {
			 System.out.println("in update bean");
				  double dblTotalCost = 0.0;
				  double dblUnitCost = 0.0;
				  int iQuantity = 0;
				  int iItemIndex = 0;
				  CartItemBean cartItem = null;
				  try {
						   iItemIndex = (index1);
						   iQuantity = (strQuantity);//Integer.parseInt
						   if(iQuantity>0)
						   {
							   //i have changed (itemIndex-1)
						    cartItem = (CartItemBean)alCartItems.get(iItemIndex);
						    dblUnitCost = cartItem.getUnitCost();
						    
						    dblTotalCost = dblUnitCost*iQuantity;
						    
						    cartItem.setQuantity(iQuantity);
						    cartItem.setTotalCost(dblTotalCost);
						    calculateOrderTotal();
						   }
				  		} 
				catch (NumberFormatException nfe) 
						{
						   System.out.println("Error while updating cart: "+nfe.getMessage());
						   nfe.printStackTrace();
						  }
		 }
		 
/*--------------------------------Add item to arraylist--------------------*/		  
		 public boolean addCartItem(String strModelNo, String strDescription,double strPrice, int strQuantity) 
		 {
			
				  double dblTotalCost = 0.0;
				  double dblUnitCost = 0.0;
				  int iQuantity = 0;
				  String index=null;
				  CartItemBean cartItem = new CartItemBean();
				  try {
						   dblUnitCost = strPrice;
						   iQuantity = (strQuantity);
						   if(iQuantity>0)
						   {
						    dblTotalCost = dblUnitCost*iQuantity;
						    cartItem.setPartNumber(strModelNo);
						    cartItem.setModelDescription(strDescription);
						    cartItem.setUnitCost(dblUnitCost);
						    cartItem.setQuantity(iQuantity);
						    cartItem.setTotalCost(dblTotalCost);
						    alCartItems.add(cartItem);
						 /* index=Integer.toString(alCartItems.indexOf(cartItem));
						   
						    System.out.println("checking the index"+alCartItems.indexOf(cartItem));*/
						    calculateOrderTotal();
//						    return alCartItems;
						   }		    
				  	}
				  catch (NumberFormatException nfe)
				  {
					   System.out.println("Error while parsing from String to primitive types: "+nfe.getMessage());
					   nfe.printStackTrace();
				  }
				/*return alCartItems;*/
				return true;
				 
		 }
		  
		 public void addCartItem(CartItemBean cartItem)
		 {
			/*System.out.println("in add  bean"  +cartItem);*/
			 	alCartItems.add(cartItem);
			 	
		 }
		 
		 
		 public CartItemBean getCartItem(int iItemIndex) 
		 {
			 /*System.out.println("in getCartItemIndex"+iItemIndex);*/
				  CartItemBean cartItem = null;
				  if(alCartItems.size()>iItemIndex)
					  {
					   cartItem = (CartItemBean) alCartItems.get(iItemIndex);
					  }
				  return cartItem;
		 }
		  
		 
		 
		 
		 //calculate total of the items
		 protected void calculateOrderTotal() {
		  double dblTotal = 0;
		  for(int counter=0;counter<alCartItems.size();counter++) 
		  {
		   CartItemBean cartItem = (CartItemBean) alCartItems.get(counter);
		   dblTotal+=cartItem.getTotalCost();
		    
		  }
		  setOrderTotal(dblTotal);
		 }
		 
		 protected void update()
		 {
			 
		 }
		 
		
		}


