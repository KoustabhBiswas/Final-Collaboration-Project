package com.niit.Collaboration_Back.dao;

import java.util.List;

import com.niit.Collaboration_Back.model.Blog;
import com.niit.Collaboration_Back.model.Forum;

public interface ForumDao {
	boolean addForum(Forum forum);
	boolean updateForum(Forum forum);
	boolean deleteForum(Forum forum);
	Forum getById(int id);
	List<Forum> getAllForum();
	 List<Forum> getByUser(int id);
}
