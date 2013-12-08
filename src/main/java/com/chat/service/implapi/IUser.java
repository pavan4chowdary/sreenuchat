/**
 * 
 */
package com.chat.service.implapi;

import com.chat.rest.objs.User;

/**
 * @author Pavan
 *
 */
public interface IUser {
	public void createUser(User user) throws Exception;
	public User getUserByEmail(String email);
	public User getUserById(String UserID);
	public void updateUser(User user) throws Exception;

}
