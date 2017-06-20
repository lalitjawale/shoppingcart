package com.neo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.OrderDao;
import com.neo.model.Billing;
import com.neo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService
{

	@Autowired
	OrderDao orderDao;
	
	@Override
	public boolean saveOrder(Billing billing,int userId)
	{
		boolean flag=orderDao.saveOrder(billing,userId);
		if(flag)
			return true;
		else
			return false;
	}

}
