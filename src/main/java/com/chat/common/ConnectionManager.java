package com.chat.common;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class ConnectionManager {
	private static ConnectionManager instance=null;
	public static ConnectionManager getInstance(){
		if(instance==null){
			instance=new ConnectionManager();
		}
		return instance;
	}
	public MongoClient getConnection() throws UnknownHostException{
		return new MongoClient();
		
	}

}
