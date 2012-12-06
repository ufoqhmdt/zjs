package com.jung.user.dao;

import com.jung.user.model.User;

/**
 *  @Description: User Dao
 *  @version Revision: V1.0 2012-11-5 下午4:27:52
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public interface UserHibernateDao {
	public User getUserByUserName(String userName);
}
