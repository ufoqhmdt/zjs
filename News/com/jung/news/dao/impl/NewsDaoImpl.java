package com.jung.news.dao.impl;

import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.jung.news.dao.NewsDao;
import com.jung.news.model.News;

public class NewsDaoImpl extends HibernateBaseDao implements NewsDao{

	@Override
	public Class getEntityType() {
		return News.class;
	}

}
