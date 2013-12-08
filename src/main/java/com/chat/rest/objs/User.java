package com.chat.rest.objs;

import java.util.Date;

/**
 * @author Pavan
 *
 */
public class User {

	private String name;
	private String email;
	private String password;
	private String devicetoken;
	private Date lastviewTime;
	private Date lastLogin;
	private String guid;
	/**
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * @param guid the guid to set
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDevicetoken() {
		return devicetoken;
	}
	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}
	public Date getLastviewTime() {
		return lastviewTime;
	}
	public void setLastviewTime(Date lastviewTime) {
		this.lastviewTime = lastviewTime;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	
}
