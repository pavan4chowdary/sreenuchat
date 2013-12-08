/**
 * 
 */
package com.chat.model.dao;

import java.util.Date;

import com.chat.common.ConnectionManager;
import com.chat.model.daoapi.IUserDAO;
import com.chat.rest.objs.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author Pavan
 *
 */
public class UserDAO implements IUserDAO{

	public void createUser(User user) {
	MongoClient client;
		try{
			client=ConnectionManager.getInstance().getConnection();
			DB db=client.getDB("Chat");
			DBCollection coll=db.getCollection("Users");
			BasicDBObject userdbobj=new BasicDBObject();
			userdbobj.put("Name", user.getName());
			userdbobj.put("Email", user.getEmail());
			userdbobj.put("LVTime", user.getLastviewTime());
			userdbobj.put("DToken", user.getDevicetoken());
			coll.insert(userdbobj);
			
		}catch (Exception e) {
		System.out.println(e.getStackTrace());
		}
		
	}

	public void updateUser(User user) {
		MongoClient client;
		try{
			client=ConnectionManager.getInstance().getConnection();
			DB db=client.getDB("Chat");
			DBCollection coll=db.getCollection("Users");
			BasicDBObject query=new BasicDBObject();
			query.append("Email", user.getEmail());
			DBCursor find = coll.find(query);
			if(find.hasNext()){
				BasicDBObject userdbobj=new BasicDBObject();
				userdbobj.put("Name", user.getName());
				userdbobj.put("Email", user.getEmail());
				userdbobj.put("LVTime", user.getLastviewTime());
				userdbobj.put("DToken", user.getDevicetoken());
				userdbobj.put("LastLogin", user.getLastLogin());
				
				coll.update(find.next(), userdbobj);
			}
			
			
		}catch (Exception e) {
		System.out.println(e.getStackTrace());
		}
		
	}

	

	public User getUserByEmail(String email) {
		MongoClient client;
		User user=null;
		try{
			client=ConnectionManager.getInstance().getConnection();
			DB db=client.getDB("Chat");
			DBCollection coll=db.getCollection("Users");
			BasicDBObject query=new BasicDBObject();
			query.append("Email", email);
			DBCursor result = coll.find(query);
			if(result.hasNext()){
				DBObject userdbobj = result.next();
				user=new User();
				user.setEmail(userdbobj.get("Email").toString());
				user.setName(userdbobj.get("Name").toString());
				user.setDevicetoken(userdbobj.get("DToken").toString());
				user.setLastLogin((Date)userdbobj.get("LastLogin"));
				user.setLastviewTime((Date)userdbobj.get("Lview"));
				user.setGuid(userdbobj.get("_id").toString());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	return user;		
	}

	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
