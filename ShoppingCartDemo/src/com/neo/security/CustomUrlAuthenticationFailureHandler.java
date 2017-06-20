package com.neo.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;







//Authentication failure class
@Component
public class CustomUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private String authenticationFailureUrl;

	public void setAuthenticationFailureUrl(String authenticationFailureUrl) {
		this.authenticationFailureUrl = authenticationFailureUrl;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException auth) throws IOException, ServletException {
		if ("true".equals(request.getHeader("AJAX"))) {
			response.getWriter().print("Error");
			response.getWriter().flush();
		} else {
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, auth);
			response.sendRedirect(authenticationFailureUrl);
		}
	}
}
 

/*implements AuthenticationFailureHandler
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


*/