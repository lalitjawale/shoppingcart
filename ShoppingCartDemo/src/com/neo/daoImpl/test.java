package com.neo.daoImpl;

import com.neo.model.User;

public class test 
{
	public static void main(String[] args) 
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		
		User user=new User();
		user.setUsername("ADMIN");
		user.setPassword("123");
		user.setEmailId("admin@gmail.com");
		user.setContactNumber("88888888888");
		user.setUser_Role("ADMIN");
		employeeDaoImpl.create(user);
		
	}

}
