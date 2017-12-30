package com.niit.Collaboration_Back;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaboration_Back.dao.BlogDao;
import com.niit.Collaboration_Back.model.Blog;
 

public class BlogTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static BlogDao blogDao;
	@Autowired
	static Blog blog;
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Collaboration_Back");
		context.refresh();
		blogDao =(BlogDao)context.getBean("blogDao");
		blog = (Blog)context.getBean("blog");
	}
@Ignore
	@Test
	public void addBlog() {
		 
		blog.setBlogName("Shopping Website");
		blog.setBlogPost("This a Shopping Website");
		blog.setBlogStatus("NA");
		blog.setBlogLikes(3);
		blog.setCreateDate(new Date());
		Assert.assertEquals(true, blogDao.addBlog(blog));
	}
	/*@Test
	public void updateBlog() {
		blog = blogDao.getById(41);
		blog.setBlogName("Collaboration Website");
		blog.setBlogPost("This a Collaboration Website");
		blog.setBlogStatus("NA");
		blog.setBlogLikes(25);
		blog.setCreateDate(new Date());
		Assert.assertEquals(true, blogDao.updateBlog(blog));
	}
	@Test
	public void deleteBlog() {
		blog= blogDao.getById(41);
		Assert.assertEquals(true, blogDao.deleteBlog(blog));
	}
	@Test
	public void approveBlog() {
		blog= blogDao.getById(42);
		Assert.assertEquals(true, blogDao.approveBlog(blog));
	}*/
}
