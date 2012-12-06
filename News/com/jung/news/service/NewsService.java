package com.jung.news.service;

import java.util.List;

import com.jung.common.JqueryGridService;
import com.jung.news.model.News;

public interface NewsService extends JqueryGridService {

	public boolean addNews(News news);

	public boolean deleteNewsById(int id);

	public News findNewsById(int id);

	public  List<News> findNewest(int type);

	String deleteNewses(String ids);
}
