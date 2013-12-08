/**
 * 
 */
package com.chat.rest.messages;

import java.util.Date;
import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.chat.common.ManagerFactory;
import com.chat.rest.objs.MessagesList;
import com.chat.rest.objs.Messgae;
import com.chat.rest.objs.OMessage;
import com.chat.rest.objs.RestResponse;
import com.chat.rest.objs.User;
import com.chat.service.implapi.IMessage;
import com.chat.service.implapi.IUser;

/**
 * @author Pavan
 *
 */
@Path("/message")
public class MessageRest {
	@POST
	@Path("/create")
	public RestResponse createMessage(@HeaderParam("message") String message,@HeaderParam("email") String  email,@HeaderParam("lat") String latitude,@HeaderParam("lang") String  langitude){
		RestResponse restResponse= new RestResponse();
		try{
			IMessage iMessage=ManagerFactory.getinstance().getMessage();
			IUser iUser=ManagerFactory.getinstance().getUser();
			if(message==null||email==null){
				restResponse.setMessage("Email or message is empty");
				restResponse.setStatus("Failed");
			}
			if(langitude==null||latitude==null){
				restResponse.setMessage("latitude or langitude is null");
				restResponse.setStatus("Failed");
			}
			User user = iUser.getUserByEmail(email);
			Messgae messageobj=new Messgae();
			messageobj.setCreatedBy(user.getName());
			messageobj.setMessage(message);
			messageobj.setCreatedTime(new Date());
			messageobj.setUserId(user.getGuid());
			messageobj.setLatitude(latitude);
			messageobj.setLangitude(langitude);
			iMessage.CreateMessage(messageobj);
			restResponse.setStatus("Success");
			restResponse.setMessage("Message posted successfully");
		}catch (Exception e) {
		restResponse.setMessage(e.getMessage());
		restResponse.setStatus("Failed");
		}
		
		return restResponse;
	}
	
	@GET
	@Path("/list")
	public RestResponse getMessagees(@HeaderParam("email") String email,@HeaderParam("Type") String type){
		RestResponse restResponse=new RestResponse();
		LinkedList<OMessage> list=new LinkedList<OMessage>();
		MessagesList mslist=new MessagesList();
		Messgae[] messages={};
		IMessage message=ManagerFactory.getinstance().getMessage();
		IUser iuser=ManagerFactory.getinstance().getUser();
		try{
			if(type.equalsIgnoreCase("all")){
				messages=message.getAllMessages();
			}else{
				User user=iuser.getUserByEmail(email);
				if(user!=null){
					messages=message.getUserMessages(user.getGuid());
				}
				
			}
			if(messages.length>0){
				for (Messgae messgae1 : messages) {
					OMessage omess=new OMessage();
					omess.setMessage(messgae1.getMessage());
					omess.setLatitude(messgae1.getLatitude());
					omess.setLangitude(messgae1.getLangitude());
					omess.setPostedBy(messgae1.getCreatedBy());
					omess.setTime(messgae1.getCreatedTime().toString());
					list.add(omess);
				}
		
		mslist.setMessageList(list);
		restResponse.setMessages(mslist);
		restResponse.setStatus("Success");
		restResponse.setMessage("Messages listed successfully");
			
			
				
			}else{restResponse.setStatus("Success");
			restResponse.setMessage("No Messages created by the users");
				
			}
		}catch (Exception e) {
		restResponse.setStatus("Failed");
		restResponse.setMessage(e.getMessage());
		}
		return restResponse;
		
	}

}
