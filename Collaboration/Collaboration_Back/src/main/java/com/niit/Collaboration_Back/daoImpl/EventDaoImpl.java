package com.niit.Collaboration_Back.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Collaboration_Back.dao.EventDao;
import com.niit.Collaboration_Back.model.Event;
import com.niit.Collaboration_Back.model.Forum;
@Repository("eventDao")
@Transactional
public class EventDaoImpl implements EventDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addForum(Event event) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().save(event);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public boolean updateForum(Event event) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().update(event);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public boolean deleteForum(Event event) {
		// TODO Auto-generated method stub
		 try {
			 sessionFactory.getCurrentSession().delete(event);
			 return true;
		 }catch(Exception e) {
			 return false;
		 }
	}

	@Override
	public Event getById(int id) {
		// TODO Auto-generated method stub
		return (Event)sessionFactory.getCurrentSession().get(Event.class, id);
	}

	@Override
	public List<Event> getAllForum() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Event").getResultList();
	}

	@Override
	public List<Event> getByUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Event WHERE USERS_USERID =:id and FORUMSTATUS ='A'";
		return (List<Event>) session.createQuery(sql).setParameter("id", id).getResultList();
	}

}
