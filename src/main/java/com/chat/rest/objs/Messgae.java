package com.chat.rest.objs;

import java.util.Date;

/**
 * @author Pavan
 *
 */
public class Messgae {
	private String message;
	private String createdBy;
	private Date createdTime;
	private String userId;
	private String latitude;
	private String langitude;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the latitude
	 */
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
