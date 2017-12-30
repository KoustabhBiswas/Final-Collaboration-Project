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

import com.niit.Collaboration_Back.dao.EventDao;
import com.niit.Collaboration_Back.model.Event;
import com.niit.Collaboration_Back.model.Forum;
@RestController
public class EventController {
	/*@Autowired
	Event event;*/
	@Autowired
	EventDao eventDao;
	@PostMapping(value="/addevent" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> addForum(@RequestBody Event event){
		if(event.getForumId() == 0) {
			event.setForumStatus("NA");
			eventDao.addForum(event);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
		}else {
			eventDao.updateForum(event);
			return new ResponseEntity<Event>(event,HttpStatus.OK);
		}
	}
	@GetMapping(value = "/oneevent/{id}")
	public ResponseEntity<Event> getBlogById(@PathVariable("id") int id){
		Event event = eventDao.getById(id);
		 
		//blogDao.getById(id);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
	@GetMapping(value="/getevent")	
	public List<Event> getuser(){
		System.out.println("Test");
		List<Event> list = eventDao.getAllForum() ;
		 for(Event b : list) {
			 System.out.println(b.getForumName());
		 }
		return list;
	}
	
	@GetMapping("/myEvent/{id}")
	public List<Event> getMyForum(@PathVariable("id") int id){
		List<Event> list =  eventDao.getByUser(id);
		return list;
	}
	
	@PostMapping(value = "/deleteevent/{id}")
	public ResponseEntity<Event> deleteBlog(@PathVariable("id") int id  ){
		//Blog blog = blogDao.getById(id);
		Event event = eventDao.getById(id);
		 
		eventDao.deleteForum(event);
		
		return new ResponseEntity<Event>(HttpStatus.OK);
		 
	}
	
	@PostMapping(value = "/approveevent/{id}")
	public ResponseEntity<Event> approveForum(@PathVariable("id") int id){
		Event event = eventDao.getById(id);
		event.setForumStatus("A");
		eventDao.updateForum(event);
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
}
