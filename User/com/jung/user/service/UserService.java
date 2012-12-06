package com.jung.user.service;

import com.jung.common.JqueryGridService;
import com.jung.user.model.User;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-11-5 下午4:19:15
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public interface UserService extends JqueryGridService{
	public boolean validateUserByUserNameAndPassword(User user);
	public User getUserByUserName(String userName);
}
