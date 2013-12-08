/**
 * 
 */
package com.chat.rest.objs;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pavan
 *
 */
@XmlRootElement(name = "Response")
public class RestResponse {
	/**
	 * 
	 */
	public RestResponse(){
		
	}
	private MessagesList messages=null;
	private String status;
	private String message;
	
	/**
	 * @return the status
	 */
	@XmlAttribute(name="status")
	public String getStatus() {
		return status;
	}

	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the messages
	 */
	@XmlElement(name="Messages")
	public MessagesList getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(MessagesList messages) {
		this.messages = messages;
	}
	/**
	 * @return the message
	 */
	@XmlElement(name="Message")
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	}
