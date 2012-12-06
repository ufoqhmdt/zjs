package com.jung.news.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.jung.common.Constants;
import com.jung.common.JqueryGridAction;
import com.jung.common.PathUtil;
import com.jung.news.model.News;
import com.jung.news.service.NewsService;

public class NewsAction extends JqueryGridAction {

	private static final long serialVersionUID = 1L;
	private static final Log logger = LogFactory.getLog(NewsAction.class);
	/**
	 * 查询结果列表.
	 */
	private List<Map<String, Object>> dataRows = new ArrayList<Map<String, Object>>();
	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private Integer id;
	private String title;
	private String sub_title;
	private String realeaser;
	private Integer status;
	private String content;
	private Date publishTime;
	private String imageUrl;
	private String url;
	private NewsService newsService;
	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	private News news;
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String subTitle) {
		sub_title = subTitle;
	}
	public String getRealeaser() {
		return realeaser;
	}
	public void setRealeaser(String realeaser) {
		this.realeaser = realeaser;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Map<String, Object>> getDataRows() {
		return dataRows;
	}
	public void setDataRows(List<Map<String, Object>> dataRows) {
		this.dataRows = dataRows;
	}

	/**
	 * 添加新闻
	 * 
	 * @return
	 */
	public String addNews() {
		News news;
		if (id != null) {
			news = newsService.findNewsById(id);
		} else {
			news = new News();
		}
		if (StringUtils.isBlank(title)) {
			this.result = FAIL;
	
		} else {
//			news.setTitle(title);
//			news.setSub_title(sub_title);
//			news.setStatus(status);
//			news.setContent(content);
			news.setPublishTime(new Date());
			newsService.addNews(news);

			this.result = SUCCESS;
		}

		return SUCCESS;
	}

	/**
	 * 删除新闻
	 * 
	 * @return
	 */
	public String deleteNews() {
		try {
			newsService.deleteNewsById(id);
			this.result = SUCCESS;
		} catch (Exception e) {
			logger.error("error in delete news.", e);
			this.result = FAIL;
		}

		return SUCCESS;
	}



}
