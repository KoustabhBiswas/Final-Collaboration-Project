package com.niit.Collaboration_Back;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;

import com.niit.Collaboration_Back.dao.UserDao;
import com.niit.Collaboration_Back.model.Users;

public class UserTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	@Autowired
	static UserDao userdao;
	/*@Autowired
	static Users users;*/
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.Collaboration_Back");
		context.refresh();
		userdao= (UserDao)context.getBean("userdao");
		//users=(Users)context.getBean("users");
	}
	//@Ignore
	@Test
	public void save() {
		 Users users = new Users();
		//Persons user=new Persons();
		users.setUserName("Koustabh");
		
		users.setAddress("Camac Street");
		
		users.setEmailId("biswas.koustabh@gmail.com");
		
		users.setPhoneNo(98652);
		
		
		Assert.assertEquals(true, userdao.saveUser(users));
	}
	/*@Test
	public void update() {
		Users users = userdao.getById(21);
		users.setEmailId("biswas@yahoo.com");
		users.setPhoneNo(456458);
		Assert.assertEquals(true, userdao.updateUser(users));
	}*/
	/*@Test
	public void update() {
		Users users = userdao.getById(21);
		 
		Assert.assertEquals(true, userdao.deleteUser(users));
	}*/
}
