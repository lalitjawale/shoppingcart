package com.neo.dao;

import com.neo.model.Billing;

public interface OrderDao 
{

	public boolean saveOrder(Billing billing,int userId);
}
