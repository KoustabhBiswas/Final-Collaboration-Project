package com.niit.Collaboration_Back;

import java.util.Date;

import org.junit.Assert;

//import java.sql.Date;

//import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration_Back.dao.ForumDao;
import com.niit.Collaboration_Back.dao.UserDao;
import com.niit.Collaboration_Back.model.Forum;
import com.niit.Collaboration_Back.model.Users;

public class ForumTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static UserDao userdao;
	@Autowired
	static ForumDao forumDao;
	
	/*@Autowired
	static Users users;*/
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Collaboration_Back");
		context.refresh();
		userdao= (UserDao)context.getBean("userdao");
		forumDao = (ForumDao)context.getBean("forumDao");
		//users=(Users)context.getBean("users");
	}
	@Ignore
	@Test
	public void addForum() {
		Forum forum =new Forum();
		Users user = userdao.getById(22);
		System.out.println(user.getAddress());
		
		forum.setForumCreateDate(new Date());
		forum.setForumDescription("This is a Ecommerce Forum");
		forum.setForumName("Ecommerce");
		System.out.println(user.getPhoneNo());
		forum.setUsers(user);
		System.out.println(user.getEmailId());
		
		Assert.assertEquals(true, forumDao.addForum(forum));
	}
}
