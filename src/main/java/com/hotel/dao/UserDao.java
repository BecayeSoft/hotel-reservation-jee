package com.hotel.dao;

import com.hotel.models.User;

public interface UserDao extends Dao<User> {
	
	//public void saveUser();
	public void findUserById();
	public User loginUser(String username, String password);
}
