/**
 * 
 */
package com.chat.rest.user;

import java.util.Date;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.chat.common.ManagerFactory;
import com.chat.rest.objs.RestResponse;
import com.chat.rest.objs.User;
import com.chat.service.implapi.IUser;

/**
 * @author Pavan
 *
 */
@Path("/user")
public class UserRest  {
	@POST
	@Path("/signIn")
	public RestResponse singInUser(@HeaderParam("name") String name,@HeaderParam("email") String email, @HeaderParam("token") String devToken){
		
		RestResponse respone=new RestResponse();
		try{
		IUser iUser =ManagerFactory.getinstance().getUser();
		System.out.println("name-----"+name);
		System.out.println("email-----"+email);
		System.out.println("token-----"+devToken);
		if(name!=null&&email!=null&&devToken!=null){
			if(name.trim().length()<1){
				respone.setStatus("Failed");
				respone.setMessage("Name should not be empty");
			}
			if(email.trim().length()<1){
				respone.setStatus("Failed");
				respone.setMessage("Name should not be empty");
			}
			if(devToken.trim().length()<1){
				respone.setStatus("Failed");
				respone.setMessage("Name should not be empty");
			}
			User user = iUser.getUserByEmail(email);
			if(user!=null){
				if(!user.getDevicetoken().equalsIgnoreCase(devToken)){
					user.setDevicetoken(devToken);
				}
				if(!user.getName().equalsIgnoreCase(name)){
					user.setDevicetoken(name);
				}
				user.setLastLogin(new Date());
				iUser.updateUser(user);
				respone.setMessage("User updated successfully");
			}else{
				User usernew=new User();
				usernew.setEmail(email);
				usernew.setName(name);
				usernew.setDevicetoken(devToken);
				usernew.setLastLogin(new Date());
				iUser.createUser(usernew);
				respone.setMessage("User created successfully");
			}
			
			respone.setStatus("Success");
		}else{
			respone.setStatus("Failed");
			respone.setMessage("Fields shound not be null");
		}
		
		}catch (Exception e) {
			respone.setStatus("Failed");
			respone.setMessage(e.getMessage());
		}
		
		return respone;
		
	}

	
	
}
