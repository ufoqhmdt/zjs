package com.jung.news.dao.impl;

import java.util.List;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;
import com.jung.news.dao.NewsHibernateDao;
import com.jung.news.model.News;

public class NewsHibernateDaoImpl extends HibernateEntityManagerImpl<News>
		implements NewsHibernateDao {
	public boolean addNews(News news) {
		try {
			super.saveOrUpdate(news);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteNews(News news) {
		try {
			super.remove(news);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteNewsById(int newsId) {
		String sql = "delete from news where newsID=" + newsId;
		try {
			super.executeSQLUpdate(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public News getNewsById(int id) {
		String hql = "from News where id=" + id;
		try {
			List newsList = super.executeHql(hql);
			if (newsList != null && newsList.size() > 0) {
				return (News) newsList.get(0);
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<News> findNewest(int type) {
		String hql = " from News  where  newsType =" + type
				+ " order by publishTime desc ";
		try {
			List newsList = super.executeHql(hql);
			if (newsList != null && newsList.size() > 0) {
				return newsList;
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Class<News> getEntityType() {
		return News.class;
	}
}
