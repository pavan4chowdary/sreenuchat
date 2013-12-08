package com.chat.rest.objs;
import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;

public class MessagesList {
	/**
	 * @author Pavan
	 *
	 */
	LinkedList<OMessage> messageList = new LinkedList<OMessage>();
	@XmlElement(name="posts")
	public LinkedList<OMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(LinkedList<OMessage> messageList) {
		this.messageList = messageList;
	}

	
	
	
}
