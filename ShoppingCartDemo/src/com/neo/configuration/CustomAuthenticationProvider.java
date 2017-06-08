
package com.neo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.neo.model.User;
import com.neo.serviceImpl.CustomUserDetailsServiceImpl;
/*import com.neo.serviceImpl.CustomUserDetailsService;*/
/*import com.neo.serviceImpl.UserServiceImpl;*/

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider 
{
	

	@Autowired
	CustomUserDetailsServiceImpl userDetailsService;
	

	@Override
	public Authentication authenticate(Authentication authentication)throws AuthenticationException
	{
		String username=authentication.getName();
		String password=(String)authentication.getCredentials();
		System.out.println("in custom auth manager"+username+password);
		UserDetails user = null;
		User currentUser = null;
		String credentials=username;

		user =  userDetailsService.loadUserByUsername(username);

		/*currentUser.setLoginattemptcount("" + 0);
		logincontrollerserviceint.updateLoginAttemptOfSystemUser(currentUser);*/

		System.out.println("after auth"+user);
		/*List<GrantedAuthority>  authorities = user.getAuthorities();*/
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		try{
			grantedAuthorities.addAll((user.getAuthorities()));
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println();
				return null;
			}
		
		System.out.println("granted authorities..."+grantedAuthorities);

		return new UsernamePasswordAuthenticationToken(user, password,grantedAuthorities);
		
		
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
	
		return true;
	}

}
