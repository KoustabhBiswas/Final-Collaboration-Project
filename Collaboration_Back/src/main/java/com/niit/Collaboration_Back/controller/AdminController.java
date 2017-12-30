package com.niit.Collaboration_Back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration_Back.dao.UserDao;
import com.niit.Collaboration_Back.model.Users;
@RestController
public class AdminController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/adminLogin", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> adminLogin(@RequestBody Users user){
		Users u = userDao.validateAdmin(user.getEmailId());
		if(user.getPassword().equals(u.getPassword())){
			return new ResponseEntity<Users>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}


}
