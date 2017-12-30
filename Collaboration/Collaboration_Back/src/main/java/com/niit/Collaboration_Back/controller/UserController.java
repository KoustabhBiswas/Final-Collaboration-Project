package com.niit.Collaboration_Back.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Collaboration_Back.dao.BlogDao;
import com.niit.Collaboration_Back.dao.UserDao;
import com.niit.Collaboration_Back.model.Blog;
import com.niit.Collaboration_Back.model.Users;

@RestController
public class UserController {
	@Autowired
	BlogDao blogDao;
	@Autowired
	Blog blog;
	 @Autowired
	 Users newuser;
	 @Autowired
	 UserDao userDao;
	  
	 @Autowired
	 HttpSession session;
	 

	@RequestMapping("/")
	public ModelAndView test() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST   )
	public ResponseEntity<Users> registerUser(@RequestBody Users user) {
	user.setUserType("User");
	userDao.saveUser(user);
	System.out.println("In RestController 2");
		 return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
	@RequestMapping(value="/login" ,method=RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> login(@RequestBody Users user){
 		
		 System.out.println("Entering Rest Controller");
		 System.out.println(user.getEmailId()+" "+user.getPassword());
		 
		Users u = userDao.validate(user.getEmailId(), user.getPassword());
		if(u == null)
		{
			
			return new ResponseEntity("Invalid Username and Password", HttpStatus.NOT_FOUND);
		}
		else
		{
			System.out.println("Validate Username and password");
			session.setAttribute("username",user.getEmailId());
			
			return new ResponseEntity<Users>(u,HttpStatus.OK);
		}
	}
	
}
