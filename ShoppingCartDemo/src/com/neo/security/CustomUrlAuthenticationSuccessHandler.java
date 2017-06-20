package com.neo.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;






//Authentication success class
/*@Component*/
public class CustomUrlAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
implements AuthenticationSuccessHandler 
{
	private JdbcTemplate jdbcTemplate;
	
	private final String user_id= "SELECT u.id from user u where u.username=? and u.password=?";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
@Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
	throws IOException, ServletException
{
	int  id=jdbcTemplate.queryForObject(user_id, new Object[]{auth.getName(),auth.getCredentials().toString()},Integer.class);
	HttpSession session=request.getSession();
	session.setAttribute("userId", id);
	System.out.println(id);
		if ("true".equals(request.getHeader("AJAX"))) 
		{
	response.getWriter().print("Ok");
	response.getWriter().flush();
		}
		else
		{
			super.onAuthenticationSuccess(request, response, auth);
		}

}

}


