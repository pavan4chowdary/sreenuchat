/**
 * 
 */
package com.chat.model.daoapi;

import java.net.UnknownHostException;

import com.chat.rest.objs.Messgae;


/**
 * @author Pavan
 *
 */
public interface IMessageDAO {
	
	public Messgae[] getAllMessages() throws UnknownHostException;
	public Messgae[] getUserMessages(String userId) throws UnknownHostException;
	public void createMessage(Messgae message)throws UnknownHostException;
	

}
