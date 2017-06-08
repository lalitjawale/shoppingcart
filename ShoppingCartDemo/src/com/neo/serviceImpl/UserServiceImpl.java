package com.neo.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;







import com.neo.dao.EmploeeDao;
import com.neo.model.User;
import com.neo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService,Serializable
{
	@Autowired
	EmploeeDao employeeDao;
	

	@Override
	public boolean create(User user)
	{
		
		boolean flag=employeeDao.create(user);
		return true;
	}


	@Override
	public User getUserByName(String uname)
	{
		User user=employeeDao.getUserByName(uname);
		/*System.out.println("user role in com.neo.serviceImpl" +employee.getUser_Role());*/
		return user;
	}

	
}
