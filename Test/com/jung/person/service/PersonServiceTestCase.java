package com.jung.person.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "/applicationContext.xml",
		"/conf/spring/applicationContext-person.xml",
		"/conf/spring/applicationContext-resume.xml",
		"/conf/spring/applicationContext-industry.xml","/conf/spring/applicationContext-postskill.xml",
		"/conf/spring/applicationContext-role.xml",
		"/conf/spring/applicationContext-enterprise.xml",
		"/conf/spring/applicationContext-companypost.xml",
		"/conf/spring/applicationContext-resumeapplypost.xml",
		"/conf/spring/applicationContext-intention.xml",
		"/conf/spring/applicationContext-news.xml",
		"/conf/spring/applicationContext-onlineask.xml" })
@TransactionConfiguration(defaultRollback = false)
public class PersonServiceTestCase extends
		AbstractTransactionalJUnit38SpringContextTests {
	/*
	@Resource
	private PersonService personService;
	*/
	/**
	 * 添加个人用户信息[管理员添加]，功能类似于用户注册，用户名必须唯一
	 * */
	public void testAddPerson() {
		
	}

}
