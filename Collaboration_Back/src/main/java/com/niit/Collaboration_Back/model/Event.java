package com.niit.Collaboration_Back.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	private String forumName;
	private String forumTitle;
	private String forumDescription;
	
	private Date forumCreateDate;
	private String forumStatus;
	@OneToOne
	private Users users;
	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumDescription() {
		return forumDescription;
	}

	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
	}

	public Date getForumCreateDate() {
		return forumCreateDate;
	}

	public void setForumCreateDate(Date forumCreateDate) {
		this.forumCreateDate = forumCreateDate;
	}

	public String getForumStatus() {
		return forumStatus;
	}

	public void setForumStatus(String forumStatus) {
		this.forumStatus = forumStatus;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	
}
