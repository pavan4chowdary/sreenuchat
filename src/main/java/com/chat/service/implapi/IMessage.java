package com.chat.service.implapi;

import java.net.UnknownHostException;

import com.chat.rest.objs.Messgae;

public interface IMessage {
	
	public Messgae[] getAllMessages() throws UnknownHostException;
	public Messgae[] getUserMessages(String userId) throws UnknownHostException;
	public void CreateMessage(Messgae message)throws UnknownHostException;
	
	

}
