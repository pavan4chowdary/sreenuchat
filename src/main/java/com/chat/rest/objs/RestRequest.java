/**
 * 
 */
package com.chat.rest.objs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pavan
 *
 */
@XmlRootElement(name = "Request")
public class RestRequest {
	
	private String email;
	private String message;
	

	
	/**
	 * @return the message
	 */
	@XmlElement(name="message")
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timeStamp
	 */
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

	
}
