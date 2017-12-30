package com.niit.Collaboration_Back.dao;

import java.util.List;

import com.niit.Collaboration_Back.model.Event;
//import com.niit.Collaboration_Back.model.Forum;

public interface EventDao {
	boolean addForum(Event event);
	boolean updateForum(Event event);
	boolean deleteForum(Event event);
	Event getById(int id);
	List<Event> getAllForum();
	 List<Event> getByUser(int id);
}
