package com.hotel.dao;

import com.hotel.models.User;

public interface UserDao {
	
	public void saveUser(User user);
	public User loginUser(String username, String password);
	
	//public User findUserById(int id);
}
