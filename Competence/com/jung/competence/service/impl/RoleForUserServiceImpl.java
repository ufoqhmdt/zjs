package com.jung.competence.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;

import com.hp.util.Page;
import com.hp.util.PageContext;
import com.hp.xquery.Restrictions;
import com.hp.xquery.SimpleQuery;
import com.jung.common.PageContextNew;
import com.jung.competence.dao.RoleForUserDao;
import com.jung.competence.model.RoleForUser;
import com.jung.competence.service.RoleForUserService;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-10-24 下午02:27:50
 *  @author YINYU mailto: yinyu@highcolu.com
 */
public class RoleForUserServiceImpl implements RoleForUserService {

	
	private RoleForUserDao roleForUserDao;
	/**
	 *  @Description: TODO
	 *  @param:@param pageContext
	 *  @param:@param queryConditions
	 *  @param:@param orderProperty
	 *  @param:@param orderMode
	 *  @param:@return
	 *  @author YINYU mailto: yinyu@highcolu.com
	 */
	@Override
	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SimpleQuery query = roleForUserDao.getSimpleQuery();
		if(queryConditions!=null){
			String rolecName = queryConditions.get("roleSimp").trim();
			if(StringUtils.hasLength(rolecName)){
				query.addFilter(Restrictions.like("roleSimp", "%" + rolecName
						+ "%"));
			}
		}
		if (orderProperty != null && !"".equals(orderProperty)) {
			if (orderMode.equals("asc")) {
				query.addOrder(orderProperty, true);
			} else if (orderMode.equals("desc")) {
				query.addOrder(orderProperty, false);
			}
		}
		Page page = roleForUserDao.find(query, pageContext.getPageNumber(),
				pageContext.getPageSize());
		pageContext.setPage(page);
		return pageContext;
	}

	/**
	 *  @Description: TODO
	 *  @param:@param entityName
	 *  @param:@return
	 *  @author YINYU mailto: yinyu@highcolu.com
	 */
	@Override
	public boolean support(String entityName) {
		// TODO Auto-generated method stub
		if (entityName != null && entityName.trim().length() != 0) {
			if (entityName.equals(RoleForUser.REF)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param roleForUserDao the roleForUserDao to set
	 */
	@Resource
	public void setRoleForUserDao(RoleForUserDao roleForUserDao) {
		this.roleForUserDao = roleForUserDao;
	}



}
