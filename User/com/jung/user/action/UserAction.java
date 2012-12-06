package com.jung.user.action;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;

import com.jung.common.JqueryGridAction;
import com.jung.user.model.User;
import com.jung.user.service.UserService;

/**
 *  @Description: 
 *  @version Revision: V1.0 2012-11-5 下午3:31:26
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public class UserAction extends JqueryGridAction{
	
	private UserService userService;
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 4880506056139267238L;
	public String login(){
		if(userService.validateUserByUserNameAndPassword(user)){
			return SUCCESS;
		}
		return INPUT;
	}
}
