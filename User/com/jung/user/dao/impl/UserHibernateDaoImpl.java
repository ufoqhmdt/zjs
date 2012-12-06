package com.jung.user.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.exception.SkeletonException;
import com.jung.user.dao.UserHibernateDao;
import com.jung.user.model.User;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-11-5 下午4:28:57
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public class UserHibernateDaoImpl extends HibernateEntityManagerImpl implements UserHibernateDao {
	Logger logger = Logger.getLogger("console"); 
	/**
	 *  @Description: TODO
	 *  @param:@param userName
	 *  @param:@return
	 *  @author GuoJun mailto: jackson@highcolu.com
	 */
	@Override
	public User getUserByUserName(String userName) {
		String hql = "from User where userName='" + userName + "'";
		Object object = null;
		try {
			List userList = super.executeHql(hql);
			if (userList == null || userList.size() < 1) {
				return null;
			}
			object = userList.get(0);
		} catch (SkeletonException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		User user = (User) object;
		return user;
	}

	/**
	*  @Description: 
	*  @param:@return
	*  @author GuoJun mailto: jackson@highcolu.com
	*/
	@Override
	public Class<User> getEntityType() {
		return User.class;
	}

}
