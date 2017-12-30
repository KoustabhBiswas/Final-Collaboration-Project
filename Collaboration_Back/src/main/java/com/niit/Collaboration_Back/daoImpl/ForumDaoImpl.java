package com.niit.Collaboration_Back.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration_Back.dao.ForumDao;
import com.niit.Collaboration_Back.model.Blog;
import com.niit.Collaboration_Back.model.Forum;
@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {
	
	 @Autowired
	 SessionFactory sessionFactory;
	@Override
	public boolean addForum(Forum forum) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().save(forum);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().update(forum);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public boolean deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().delete(forum);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public Forum getById(int id) {
		// TODO Auto-generated method stub
		 
			return (Forum)sessionFactory.getCurrentSession().get(Forum.class, id);
			 
		 
	}

	@Override
	public List<Forum> getAllForum() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Forum").getResultList();
	}

	@Override
	public List<Forum> getByUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Forum WHERE USERS_USERID =:id and FORUMSTATUS ='A'";
		return (List<Forum>) session.createQuery(sql).setParameter("id", id).getResultList();
	}

}
