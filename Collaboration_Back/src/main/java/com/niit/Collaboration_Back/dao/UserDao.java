package com.niit.Collaboration_Back.dao;

import java.util.List;

import com.niit.Collaboration_Back.model.Users;

public interface UserDao {
	boolean saveUser(Users user);
	boolean updateUser(Users user);
	boolean deleteUser(Users user);
	boolean validateUser(Users user);
	Users validate(String username, String password);
	Users getById(int id);
	Users getByUsername(String username);
	Users validateAdmin(String emailid);
	List<Users> getAll();
}
