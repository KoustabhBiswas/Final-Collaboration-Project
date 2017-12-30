package com.niit.Collaboration_Back.dao;

import java.util.List;

import com.niit.Collaboration_Back.model.Blog;

public interface BlogDao {
	boolean addBlog(Blog blog);
	boolean updateBlog(Blog blog);
	boolean deleteBlog(Blog blog);
	boolean approveBlog(Blog blog);
	Blog getById(int id);
	Blog getByUserId(int id);
	List<Blog> getAllBlog();
	 List<Blog> getByUser(int id);
	 

}
