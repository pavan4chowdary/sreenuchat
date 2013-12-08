/**
 * 
 */
package com.chat.model.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chat.common.ConnectionManager;
import com.chat.model.daoapi.IMessageDAO;
import com.chat.rest.objs.Messgae;
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
public class MessageDAO implements IMessageDAO{
MongoClient client;
	public Messgae[] getAllMessages() throws UnknownHostException {
		List<Messgae> list=new ArrayList<Messgae>();
		client=ConnectionManager.getInstance().getConnection();
		DB db=client.getDB("Chat");
		DBCollection coll=db.getCollection("messages");
		DBCursor result = coll.find().sort(new BasicDBObject().append("_id", -1));
		Messgae message;
		while (result.hasNext()) {
			DBObject obj = result.next();
			message=new Messgae();
			message.setMessage(obj.get("Mess").toString());
			message.setCreatedTime((Date)obj.get("CT"));
			message.setCreatedBy(obj.get("CB").toString());
			message.setLangitude(obj.get("lang").toString());
			message.setLatitude(obj.get("lat").toString());
			list.add(message);
			
		}
		return list.toArray(new Messgae[0]);
	}

	public Messgae[] getUserMessages(String userId) throws UnknownHostException {
	
			List<Messgae> list=new ArrayList<Messgae>();
			client=ConnectionManager.getInstance().getConnection();
			DB db=client.getDB("Chat");
			DBCollection coll=db.getCollection("messages");
			BasicDBObject query=new BasicDBObject();
			query.put("UId", userId);
			DBCursor result = coll.find(query).sort(new BasicDBObject().append("_id", -1));
			Messgae message;
			while (result.hasNext()) {
				DBObject obj = result.next();
				message=new Messgae();
				message.setMessage(obj.get("Mess").toString());
				message.setCreatedTime((Date)obj.get("CT"));
				message.setCreatedBy(obj.get("CB").toString());
				message.setLangitude(obj.get("lang").toString());
				message.setLatitude(obj.get("lat").toString());
				list.add(message);
				
			}
			return list.toArray(new Messgae[0]);
	}

	public void createMessage(Messgae message) throws UnknownHostException {
		client=ConnectionManager.getInstance().getConnection();
		DB db=client.getDB("Chat");
		DBCollection coll=db.getCollection("messages");
		BasicDBObject query=new BasicDBObject();
		query.put("Mess", message.getMessage());
		query.put("CT", message.getCreatedTime());
		query.put("CB", message.getCreatedBy());
		query.put("UId", message.getUserId());
		query.put("lat", message.getLatitude());
		query.put("lang", message.getLangitude());
		coll.insert(query);
		
	}
	

}
