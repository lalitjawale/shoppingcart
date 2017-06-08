package com.neo.configuration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import com.neo.service.UserService;


//Authentication failure class
public class CustomUrlAuthenticationFailureHandler implements AuthenticationFailureHandler
{
	@Autowired
	UserService logincontrollerserviceint;

	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception)throws IOException, ServletException 
	{
	System.out.println("failure");
	
		
		if(exception!=null)
		{
					String message="";
					message = "Authentication Failed!..";
					RequestDispatcher dispatcher = request.getRequestDispatcher("/loginError");
					request.setAttribute("message", message);
					dispatcher.forward(request, response);
		}
		
		else
		{
			System.out.println("login successfull.....");
		}
	}
}


