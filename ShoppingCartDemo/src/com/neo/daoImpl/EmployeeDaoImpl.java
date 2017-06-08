package com.neo.daoImpl;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.User;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dao.EmploeeDao;
import com.neo.model.User;


@Transactional
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmploeeDao
{
	
	/*@Autowired
	private SessionFactory sessionFactory;
	*/

	@Override
	public boolean create(User user) 
	{
		/*System.out.println("Register in Dao");
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(employee);
		return true;*/
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.save(user);
		transaction.commit();
		if(session!=null)
		{
			System.out.println("data inserted...");
			return true;
		}
		return false;
		
	}

	@Override
	public User getUserByName(String uname)
	{
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from User where username=?");
		query.setParameter(0, uname);
		List<User> allUsers=query.list();
		transaction.commit();
		if(allUsers.size()>0)
		{
			System.out.println("got list"+allUsers.get(0));
			for (User user : allUsers) 
			{
				allUsers.add(user);
				/*employee.setEmailId(allUsers.get(1));*/
				System.out.println(user.getUser_Role());
				System.out.println("role is"+user.getUser_Role() +"contact num"+user.getContactNumber() +"emailId"+user.getEmailId()+"password"+user.getPassword());
				
				return user;
			}
			
		}
		else
		{
			System.out.println("no list");
		}
		return null;
		
	}

}
