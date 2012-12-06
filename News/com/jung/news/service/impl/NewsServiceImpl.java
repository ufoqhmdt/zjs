package com.jung.news.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;

import com.hp.util.Page;
import com.hp.util.PageContext;
import com.hp.xquery.LikeMatchMode;
import com.hp.xquery.Restrictions;
import com.hp.xquery.SimpleQuery;
import com.jung.common.ConvertUtil;
import com.jung.news.dao.NewsDao;
import com.jung.news.dao.NewsHibernateDao;
import com.jung.news.model.News;
import com.jung.news.service.NewsService;

@SuppressWarnings("serial")
public class NewsServiceImpl implements NewsService {

	private NewsHibernateDao newsHibernateDao;
	private NewsDao newsDao;

	@Resource
	public void setNewsHibernateDao(NewsHibernateDao newsHibernateDao) {
		this.newsHibernateDao = newsHibernateDao;
	}

	@Resource
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		/**
		 * 公司新闻 0 法务服务 1 人事派遣 2 代理代办 3 招聘服务 4 政策查询 5 支点分析 6 办事指引 8 公司刊物 100 服务分类
		 * 20
		 */

		Integer queryType = -1;
		if (queryConditions.get("queryType") != null
				&& !"".equals(queryConditions.get("queryType"))) {
			queryType = Integer.parseInt(queryConditions.get("queryType"));
		}
		// String title = queryConditions.get("title");
		SimpleQuery query = newsDao.getSimpleQuery();
		if (queryType == 1000) {// 表示从新闻，政策查询，支点分析中查询
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(0);
			typeList.add(5);
			typeList.add(6);
			/*
			 * Junction junction = new Junction(Symbol.OR);
			 * junction.add(Restrictions.eq(News.TYPE,0));
			 * junction.add(Restrictions.eq(News.TYPE,5));
			 * junction.add(Restrictions.eq(News.TYPE,6));
			 * query.addFilter(junction);
			 */
			// query.addFilter(Restrictions.in(News., typeList));
		} else if (queryType != -1 && queryType != 1000) {
			// query.addFilter(Restrictions.eq(News.TYPE,queryType));
		}
		if (queryType == 5) {
			String firstCatalogName = queryConditions.get("firstCatalogName");
			if (StringUtils.hasLength(firstCatalogName)) {
				// query.addFilter(Restrictions.eq(News.FIRST_CATALOGNAME,firstCatalogName));
			}
			String catalogName = queryConditions.get("catalogName");
			if (StringUtils.hasLength(catalogName)) {
				// query.addFilter(Restrictions.eq(News.CATALOGNAME,catalogName));
			}
		}
		/*
		 * if(org.springframework.util.StringUtils.hasLength(title)){
		 * query.addFilter
		 * (Restrictions.like(News.TITLE,title,LikeMatchMode.ANYWHERE)); }
		 */
		/**
		 * Add by luxinglin
		 * */
		if (null != queryConditions) {
			if (queryConditions.get("title") != null
					&& queryConditions.get("title").trim().length() > 0) {
				try {
					String fuzzyTitle = java.net.URLDecoder.decode(
							queryConditions.get("title").trim(), "UTF-8");
					LikeMatchMode matchMode = LikeMatchMode.ANYWHERE;
					query.addFilter(Restrictions.like("title", fuzzyTitle,
							matchMode));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (queryConditions.get("start_date") != null
					&& queryConditions.get("start_date").trim().length() > 0) {
				try {
					String lowDate = java.net.URLDecoder.decode(queryConditions
							.get("start_date").trim(), "UTF-8");
					java.util.Date tmpLow = ConvertUtil.toDate(lowDate,
							"yyyy-MM-dd");
					query.addFilter(Restrictions.ge("publishTime", tmpLow));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (queryConditions.get("end_date") != null
					&& queryConditions.get("end_date").trim().length() > 0) {
				try {
					String highDate = java.net.URLDecoder.decode(
							queryConditions.get("end_date").trim(), "UTF-8");
					java.util.Date tmpHigh = ConvertUtil.toDate(highDate,
							"yyyy-MM-dd");
					query.addFilter(Restrictions.le("publishTime", tmpHigh));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		if (orderProperty != null && !"".equals(orderProperty)) {
			if (orderMode.equals("asc")) {
				query.addOrder(orderProperty, true);
			} else if (orderMode.equals("desc")) {
				query.addOrder(orderProperty, false);
			}
		} else {
			// query.addOrder(News.PUBLISHTIME, false);
		}
		if (queryConditions.get("status") != null
				&& !"".equals(queryConditions.get("status"))) {
			// query.addFilter(Restrictions.eq(News.STATUS, 1));
		}
		Page page = newsDao.find(query, pageContext.getPageNumber(),
				pageContext.getPageSize());
		pageContext.setPage(page);
		return pageContext;
	}

	public boolean addNews(News news) {
		return newsHibernateDao.addNews(news);
	}

	public boolean deleteNewsById(int id) {
		return newsHibernateDao.deleteNewsById(id);
	}

	@Override
	public String deleteNewses(String ids) {
		if (ids != null && !ids.equals("")) {
			String[] idArr = ids.split(",");
			if (idArr != null) {
				try {
					for (String id : idArr) {
						deleteNewsById(Integer.parseInt(id));
					}
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "fail";
	}

	public News findNewsById(int id) {
		return newsHibernateDao.getNewsById(id);
	}

	@Override
	public List<News> findNewest(int type) {
		return newsHibernateDao.findNewest(type);
	}

	public boolean support(String entityName) {
		if (entityName != null && entityName.trim().length() != 0) {
			if (entityName.equals(News.REF)) {
				return true;
			}
		}
		return false;
	}
}
