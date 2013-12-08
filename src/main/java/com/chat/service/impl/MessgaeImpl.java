/**
 * 
 */
package com.chat.service.impl;

import java.net.UnknownHostException;

import com.chat.common.AccesDAO;
import com.chat.model.daoapi.IMessageDAO;
import com.chat.rest.objs.Messgae;
import com.chat.service.implapi.IMessage;

/**
 * @author Pavan
 *
 */
public class MessgaeImpl implements IMessage{
IMessageDAO messageDAO=AccesDAO.getInstance().getMessageDAO();
	public Messgae[] getAllMessages() throws UnknownHostException {
		System.out.println("Entered in message IMPL of all messages");
		Messgae[] messages=null;
		messages=messageDAO.getAllMessages();
		System.out.println("Exited from message IMPL of all  messages");
		return messages;
	}

	
	public Messgae[] getUserMessages(String userId) throws UnknownHostException {
		System.out.println("Entered in message IMPL of user messages");
		Messgae[] messages=null;
		messages=messageDAO.getUserMessages(userId);
		System.out.println("Exited from message IMPL of user messages");
		return messages;
	}

	public void CreateMessage(Messgae message) {
		try{
			if(message==null){
				throw new Exception("Message object is null");
			}
			messageDAO.createMessage(message);
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}
		
	}
	

}
