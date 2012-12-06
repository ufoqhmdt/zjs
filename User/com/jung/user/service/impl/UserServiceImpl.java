package com.jung.user.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.hp.util.PageContext;
import com.jung.user.dao.UserHibernateDao;
import com.jung.user.model.User;
import com.jung.user.service.UserService;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-11-5 下午4:20:34
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public class UserServiceImpl implements UserService {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	Logger logger = Logger.getLogger(this.getClass()); 
	private static final long serialVersionUID = 8788933754402863849L;
	private UserHibernateDao userHibernateDao;
	@Resource
	public void setUserHibernateDao(UserHibernateDao userHibernateDao) {
		this.userHibernateDao = userHibernateDao;
	}
	@Override
	public User getUserByUserName(String userName) {
		return userHibernateDao.getUserByUserName(userName);
	}
	/**@Description:
	 *  @param:@param user
	 *  @param:@return
	 *  @author GuoJun mailto: jackson@highcolu.com
	 */
	@Override
	public boolean validateUserByUserNameAndPassword(User user) {
		if (null != user) {
				User  tempUser = getUserByUserName(user.getUserName());
				if(tempUser!=null){
					if (tempUser.isAvailable() != null
							&& tempUser.isAvailable()
							&& tempUser.getPassword().equals(user.getPassword())) {
						return true;
					}
				}
		}
		return false;
	}
	/**
	*  @Description: 分页组件
	*  @param:@param pageContext
	*  @param:@param queryConditions
	*  @param:@param orderProperty
	*  @param:@param orderMode
	*  @param:@return
	*  @author GuoJun mailto: jackson@highcolu.com
	*/
	@Override
	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		return null;
	}
	/**
	*  @Description: TODO
	*  @param:@param entityName
	*  @param:@return
	*  @author GuoJun mailto: jackson@highcolu.com
	*/
	@Override
	public boolean support(String entityName) {
		if (entityName != null && entityName.trim().length() != 0) {
			if (entityName.equals(User.REF)) {
				return true;
			}
		}
		return false;
	}

}
