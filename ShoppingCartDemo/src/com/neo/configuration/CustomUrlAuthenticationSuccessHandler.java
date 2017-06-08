package com.neo.configuration;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.neo.service.UserService;

//Authentication success class
public class CustomUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
	@Autowired
	UserService userService;
	

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	public void onAuthenticationSuccess(HttpServletRequest request,	HttpServletResponse response, Authentication authentication)throws IOException, ServletException 
	{
		System.out.println("888888888888888888888888888888888");
		
		
		String targetUrl = determineTargetUrl(authentication); 
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication)
	{
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains("ROLE_Admin")) {
        	return "/adminSuccess.jsp";
        } 
        else if(authorities.contains("ROLE_User")) 
        	return "/shippingAndBilling.jsp";
       
        else {
            throw new IllegalStateException();
        }
    }

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

		
		
	}
	
	
	