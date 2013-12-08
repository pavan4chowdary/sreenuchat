/**
 * 
 */
package com.chat.service.impl;

import com.chat.common.AccesDAO;
import com.chat.model.daoapi.IUserDAO;
import com.chat.rest.objs.User;
import com.chat.service.implapi.IUser;

/**
 * @author Pavan
 *
 */
public class UserImpl implements IUser{
IUserDAO userDAO=AccesDAO.getInstance().getUserDAO();
	
	public User getUserByEmail(String email) {
		User user=null;
		if(email!=null){
			user=userDAO.getUserByEmail(email);
		}else{
		System.out.println("email should not be empty");
		}
		return user;
	}

	public User getUserById(String UserID) {
		User user=null;
		if(UserID!=null){
			user=userDAO.getUserByEmail(UserID);
		}else{
		System.out.println("email should not be empty");
		}
		return user;
	}

	public void updateUser(User user) throws Exception {
		if(user==null){
			throw new Exception("User is not exit");
		}
userDAO.updateUser(user);
		
	}

	public void createUser(User user) throws Exception {
		try{
			if(user==null){
				throw new Exception("User should not e empty");
			}
		
		userDAO.createUser(user);
			}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
