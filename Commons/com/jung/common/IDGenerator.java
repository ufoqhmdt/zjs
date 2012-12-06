package com.jung.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * @Description: ID生成器
 * @version Revision: V1.0 2012-8-31 下午04:36:18
 * @author GuoJun mailto: jackson@highcolu.com
 */
public class IDGenerator implements ServletContextListener {

	/*
	 * 用户权限
	 */
	private static int roleID;// 用户与角色关联表
	private static int rfulmID;// 角色与菜单关联表
	private static int ulmID;// 用户菜单关联表
	private static int rluID;//

	
	private Log logger = LogFactory.getLog(IDGenerator.class);


	/**
	 * 用户与角色关联表
	 */
	public static synchronized int getRoleID() {
		roleID = roleID + 1;
		return roleID;
	}

	/**
	 * 角色与菜单关联表
	 */
	public static synchronized int getRfulmID() {
		rfulmID = rfulmID + 1;
		return rfulmID;
	}

	/**
	 * 用户菜单关联表
	 */
	public static synchronized int getUlmID() {
		ulmID = ulmID + 1;
		return ulmID;
	}
	public static synchronized int getRluID(){
		rluID=rluID+1;
		return rluID;
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		roleID=getId("roleID","RoleForUser");
		rfulmID=getId("rfulmID","RoleForUserLinkMenu");
		//ulmID=getId("ulmID","UserLinkMenu");
		rluID=getId("rluID","RoleLinkUser");
	}

	private synchronized int getId(String idName, String tableName) {
		String sql = "SELECT MAX(" + idName + ") FROM " + tableName;
		Session session = HibernateSessionFactory.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		Object max_Id = sqlQuery.list().get(0);
		if (max_Id == null) {
			max_Id = 0;
		}
		HibernateSessionFactory.closeSession();
		return (Integer) max_Id;
	}
}
