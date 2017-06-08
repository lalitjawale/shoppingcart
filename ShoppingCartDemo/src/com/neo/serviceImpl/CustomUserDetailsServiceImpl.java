package com.neo.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neo.model.User;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService,Serializable
{
	@Autowired
	UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException 
	{
	
		/*User employee = userServiceImpl.getUserByName(username);
		*/
		System.out.println("loadByUsername is called");
		User user=  userServiceImpl.getUserByName(username);
		
		
		System.out.println("loadByUsername after method user role is"+user);
		
		return new UserDetails() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername()
			{
				// TODO Auto-generated method stub
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() 
			{
				List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
				try{
				grantedAuthorities.add(new SimpleGrantedAuthority(user.getUser_Role()));
				}catch(Exception e)
				{
					e.printStackTrace();
					System.out.println();
					return null;
				}
				
				return grantedAuthorities;
			}
		};
	/*	return user;*/
		
        /*List<GrantedAuthority> authorities = buildUserAuthority(employee.getUser_Role());
        return (UserDetails) buildUserForAuthentication(employee, authorities);*/
      
	}

	/*private UserDetails buildUserForAuthentication(User employee,List<GrantedAuthority> authorities) 
	{
		return new User(employee.getUsername(), employee.getPassword(),
				true, true, true, true, authorities);
	}

	private GrantedAuthority buildUserAuthority(String user_Role)
	{
		GrantedAuthority result=(GrantedAuthority)user_Role;
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (Role userRole : roles) {
            System.out.println("****" + userRole);
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
	}*/

	

}
