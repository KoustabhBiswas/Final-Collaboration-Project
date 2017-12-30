package com.niit.Collaboration_Back.model;

public class Message {
	private int id;
	private String message;
	private String fullName;
public Message(){
		
	}
	
	public Message(int id,String message,String fullName ){
		this.id=id;
		this.message=message;
		this.fullName=fullName;
	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
