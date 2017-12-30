package com.niit.Collaboration_Back.daoImpl;

import java.util.List;

//import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration_Back.dao.UserDao;
import com.niit.Collaboration_Back.model.Users;

 

@Repository("userdao")
@Transactional
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
	public boolean saveUser(Users user) {
		// TODO Auto-generated method stub
		try {
			System.out.println("heelo");
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public Users getById(int id) {
		// TODO Auto-generated method stub
		return (Users)sessionFactory.getCurrentSession().get(Users.class, id) ;
	}

	public boolean deleteUser(Users user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from users").getResultList();
	}

	@Override
	public Users getByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Entering");
		String sql = "from Users WHERE emailId = :userame";
		Users user = (Users)session.createQuery(sql).setParameter("username", username).getSingleResult();
		return user;
	}

	@Override
	public boolean validateUser(Users user) {
		// TODO Auto-generated method stub
		List<Users> list = sessionFactory.getCurrentSession().createQuery("from users").getResultList();
		Users u = (Users) list;
		/*for(Users u : list) {
			if(u.getEmailId() == user.getEmailId() && u.getPassword() == user.getPassword()) {
				return true;
			} 
			else {
				return false;
			}
		}*/
		if(user.getEmailId() == u.getEmailId() && user.getPassword() == u.getPassword()) {
			return true;
		}else {
			return false;
		}
		 
		
	}

	@Override
	public Users validate(String emailid, String password) {
		// TODO Auto-generated method stub
		 System.out.println("Entering Rest Controller");
			  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Users.class);
			  criteria.add(Expression.eq("emailId", emailid));
			  System.out.println(emailid);
			  criteria.add(Expression.eq("password", password));
			  System.out.println(password);
			  return (Users) criteria.uniqueResult();
			 
	}

	@Override
	public Users validateAdmin(String emailid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Users WHERE EMAILID =:emailid and USERTYPE ='Admin' ";
		return (Users) session.createQuery(sql).setParameter("emailid", emailid).getSingleResult();
	}

}
