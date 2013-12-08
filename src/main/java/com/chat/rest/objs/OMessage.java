/**
 * 
 */
package com.chat.rest.objs;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Pavan
 *
 */
public class OMessage {
	private String message;
	private String postedBy;
	private String time;
	private String latitude;
	private String langitude;
	
	@XmlElement(name="post")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@XmlElement(name="By")
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	@XmlElement(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the latitude
	 */
	@XmlElement(name="lat")
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the langitude
	 */
	@XmlElement(name="lang")
	public String getLangitude() {
		return langitude;
	}
	/**
	 * @param langitude the langitude to set
	 */
	public void setLangitude(String langitude) {
		this.langitude = langitude;
	}
	

}
