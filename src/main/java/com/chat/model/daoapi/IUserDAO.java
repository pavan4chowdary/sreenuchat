package com.chat.model.daoapi;

import com.chat.rest.objs.User;

public interface IUserDAO {
	
	public void createUser(User user);
	public void updateUser(User user);
	public User getUserByEmail(String email);
	public User getUserByID(String id);
	

}
