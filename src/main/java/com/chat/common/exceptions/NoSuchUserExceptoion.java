/**
 * 
 */
package com.chat.common.exceptions;

import com.chat.rest.objs.User;

/**
 * @author Pavan
 *
 */
public class NoSuchUserExceptoion extends Exception {
	
	NoSuchUserExceptoion(String message){
		super(message);
	}

}
