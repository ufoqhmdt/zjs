package com.jung.competence.dao.impl;

import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.jung.competence.dao.RoleForUserDao;
import com.jung.competence.model.RoleForUser;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-10-24 下午02:25:47
 *  @author YINYU mailto: yinyu@highcolu.com
 */
public class RoleForUserDaoImpl extends HibernateBaseDao implements
		RoleForUserDao {

	/**
	 *  @Description: TODO
	 *  @param:@return
	 *  @author YINYU mailto: yinyu@highcolu.com
	 */
	@Override
	public Class getEntityType() {
		// TODO Auto-generated method stub
		return RoleForUser.class;
	}

}
