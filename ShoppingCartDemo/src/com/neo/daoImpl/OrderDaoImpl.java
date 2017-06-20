package com.neo.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.neo.dao.OrderDao;
import com.neo.model.Billing;
import com.neo.model.User;

@Repository
public class OrderDaoImpl implements OrderDao
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public boolean saveOrder(Billing billing,int userId)
	{
		 Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("firstName",billing.getFirstName());
	        paramMap.put("LastName",billing.getLastName());
	        paramMap.put("emailId",billing.getEmailId());
	        paramMap.put("contactNumber",billing.getContactNumber());
	        paramMap.put("address",billing.getAddress());
	        paramMap.put("city",billing.getCity());
	        paramMap.put("state",billing.getState());
	        paramMap.put("postalCode",billing.getPostalCode());
	        paramMap.put("paymentOption",billing.getPaymentOption());
	        paramMap.put("user", userId);
	       
		
	        /*String sql="";
	         * new Object[]{billing.getFirstName(),billing.getLastName(),billing.getEmailId(),billing.getContactNumber(),billing.getAddress(),billing.getCity(),
						billing.getState(),billing.getPostalCode(),billing.getPaymentOption()}
	         * new Object[]{}*/
	
		int result=jdbcTemplate.update("insert into Billing(firstName,LastName,emailId,contactNumber,address,city,state,postalCode,paymentOption,id)values(?,?,?,?,?,?,?,?,?,?)",
				new Object[]{billing.getFirstName(),billing.getLastName(),billing.getEmailId(),billing.getContactNumber(),billing.getAddress(),billing.getCity(),
						billing.getState(),billing.getPostalCode(),billing.getPaymentOption(),userId});
		if(result>0)
		{
			System.out.println("ordered successfully...");
			return true;
		}
		return false;
		
	}
	

}
