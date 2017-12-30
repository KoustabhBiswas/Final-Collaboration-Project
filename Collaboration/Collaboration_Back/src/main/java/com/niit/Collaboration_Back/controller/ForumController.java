package com.niit.Collaboration_Back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaboration_Back.dao.ForumDao;
import com.niit.Collaboration_Back.model.Blog;
import com.niit.Collaboration_Back.model.Forum;

@RestController
public class ForumController {
	@Autowired
	Forum forum;
	@Autowired
	ForumDao forumDao;
	@PostMapping(value="/addforum" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum){
		if(forum.getForumId() == 0) {
			forum.setForumStatus("NA");
			forumDao.addForum(forum);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}else {
			forumDao.updateForum(forum);
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
	}
	@GetMapping(value = "/oneforum/{id}")
	public ResponseEntity<Forum> getBlogById(@PathVariable("id") int id){
		Forum forum = forumDao.getById(id);
		 
		//blogDao.getById(id);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	@GetMapping(value="/getforum")	
	public List<Forum> getuser(){
		System.out.println("Test");
		List<Forum> list = forumDao.getAllForum() ;
		 for(Forum b : list) {
			 System.out.println(b.getForumName());
		 }
		return list;
	}
	
	@GetMapping("/myForum/{id}")
	public List<Forum> getMyForum(@PathVariable("id") int id){
		List<Forum> list =  forumDao.getByUser(id);
		return list;
	}
	
	@PostMapping(value = "/deleteforum/{id}")
	public ResponseEntity<Forum> deleteBlog(@PathVariable("id") int id  ){
		//Blog blog = blogDao.getById(id);
		Forum forum = forumDao.getById(id);
		 
		forumDao.deleteForum(forum);
		
		return new ResponseEntity<Forum>(HttpStatus.OK);
		 
	}
	
	@PostMapping(value = "/approveforum/{id}")
	public ResponseEntity<Forum> approveForum(@PathVariable("id") int id){
		Forum forum = forumDao.getById(id);
		forum.setForumStatus("A");
		forumDao.updateForum(forum);
		return new ResponseEntity<Forum>(HttpStatus.OK);
	}
}
