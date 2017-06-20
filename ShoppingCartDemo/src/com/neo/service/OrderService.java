package com.neo.service;

import com.neo.model.Billing;

public interface OrderService
{
	public boolean saveOrder(Billing billing,int userId);

}
