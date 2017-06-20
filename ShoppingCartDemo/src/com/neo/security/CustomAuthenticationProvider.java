
package com.neo.security;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neo.model.User;



/*@Component*/
@Scope("session")
public class CustomAuthenticationProvider implements AuthenticationManager 
{
	private JdbcTemplate jdbcTemplate;
	private final String USER_CNT = "SELECT count(*) FROM user where username=? and password=?";
	private final String user_id= "SELECT u.id from user u where u.username=? and u.password=?";
	private final String USER_LIST = "SELECT r.role FROM roles r INNER JOIN users_roles ur ON r.role_id = ur.role_id WHERE ur.user_id = ?;";
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException
	{
		String userName = auth.getName();
		String passWord = (String) auth.getCredentials();
		
		if (jdbcTemplate.queryForObject(USER_CNT,new Object[]{userName, passWord},Integer.class) < 1) {
			throw new BadCredentialsException("Invalid Login Details");
		}
		
		
		int  id=jdbcTemplate.queryForObject(user_id, new Object[]{userName,passWord},Integer.class);
		
		System.out.println("user id is" +id);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(USER_LIST,id);
		if (rows.size() > 0 && rows != null)
		{
			/*System.out.println("to chek id"+rows.get(0));
			*/

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, passWord,
					getRole((String) rows.get(0).get("role")));
			
			/*authToken.setDetails();*/
			return authToken;
		}
		throw new BadCredentialsException("Invalid Login Details");
	}

	public Collection<GrantedAuthority> getRole(String role)
	{
		/*System.out.println("user role is "+role);*/
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(role.toUpperCase()));
		return authList;
	}

}
 



























/*implements AuthenticationProvider 
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

		currentUser.setLoginattemptcount("" + 0);
		logincontrollerserviceint.updateLoginAttemptOfSystemUser(currentUser);

		System.out.println("after auth"+user);
		List<GrantedAuthority>  authorities = user.getAuthorities();
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
*/