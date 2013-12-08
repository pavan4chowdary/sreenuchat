/**
 * 
 */
package com.chat.common;

import com.chat.service.impl.MessgaeImpl;
import com.chat.service.impl.UserImpl;
import com.chat.service.implapi.IMessage;
import com.chat.service.implapi.IUser;

/**
 * @author Pavan
 *
 */
public class ManagerFactory {
	private static ManagerFactory instance =null;
public static ManagerFactory getinstance(){
	
	if(instance==null){
		 instance=new ManagerFactory();
	}
	return instance;
	
	
}
public  ManagerFactory(){
	
}
public IUser getUser(){
	return new UserImpl();
}
public IMessage getMessage(){
	IMessage message= new MessgaeImpl();
	return message;
}
}
