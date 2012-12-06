package com.jung.news.dao;

import java.util.List;

import com.jung.news.model.News;

public interface NewsHibernateDao {
	public boolean addNews(News news);

	public boolean deleteNews(News news);

	public boolean deleteNewsById(int newsId);

	public News getNewsById(int id);

	public List<News> findNewest(int type);// 根据新闻类型获取新闻列表,网站公告 0活动公告 1 文献资料 2
}
