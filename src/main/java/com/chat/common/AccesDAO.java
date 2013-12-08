/**
 * 
 */
package com.chat.common;

import com.chat.model.dao.MessageDAO;
import com.chat.model.dao.UserDAO;
import com.chat.model.daoapi.IMessageDAO;
import com.chat.model.daoapi.IUserDAO;

/**
 * @author Pavan
 *
 */
public class AccesDAO {
	
	
	private static AccesDAO instance=null;
	
	public static AccesDAO getInstance(){
		if(instance==null){
			instance=new AccesDAO();
		}
		return instance;
		
	}
	public IUserDAO getUserDAO(){
		IUserDAO instance=new UserDAO();
		return instance;
	}
	public IMessageDAO getMessageDAO(){
		IMessageDAO instance=new MessageDAO();
		return instance;
	}

}
