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

import com.niit.Collaboration_Back.dao.BlogDao;
import com.niit.Collaboration_Back.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDao blogDao;
	@Autowired
	Blog blog;
	@GetMapping(value="/get")	
	public List<Blog> getuser(){
		System.out.println("Test");
		List<Blog> list = blogDao.getAllBlog() ;
		 for(Blog b : list) {
			 System.out.println(b.getBlogName());
		 }
		return list;
	}
	@PostMapping(value = "/insert", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> insertBlog(@RequestBody Blog blog){
		if(blog.getBlogId() == 0) {
			blog.setBlogStatus("NA");
		blogDao.addBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}else {
			blogDao.updateBlog(blog);
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
	}
	@PostMapping(value = "/likeupdate/{id}")
	public ResponseEntity<Blog> likeUpdate(@PathVariable("id") int id){
		Blog blog = blogDao.getById(id);
		blog.setBlogLikes(blog.getBlogLikes()+1);
		blogDao.updateBlog(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	@PostMapping(value = "/delete/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id  ){
		//Blog blog = blogDao.getById(id);
		Blog  blog = blogDao.getByUserId(id);
		 
		blogDao.deleteBlog(blog);
		
		return new ResponseEntity<Blog>(HttpStatus.OK);
		 
	}
	@GetMapping(value = "/getblog/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){
		Blog blog = blogDao.getById(id);
		 
		//blogDao.getById(id);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@GetMapping("/myBlog/{id}")
	public List<Blog> getMyBlog(@PathVariable("id") int id){
		List<Blog> list =  blogDao.getByUser(id);
		return list;
	}
	@PostMapping(value = "/approveblog/{id}")
	public ResponseEntity<Blog> approveBlog(@PathVariable("id") int id){
		Blog blog = blogDao.getById(id);
		blog.setBlogStatus("A");
		blogDao.updateBlog(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
}
