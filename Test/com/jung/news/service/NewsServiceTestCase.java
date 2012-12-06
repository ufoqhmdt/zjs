package com.jung.news.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jung.news.model.News;
@ContextConfiguration(locations = { "/applicationContext.xml",
		"/conf/spring/applicationContext-news.xml"})
@TransactionConfiguration(defaultRollback = false)
public class NewsServiceTestCase extends AbstractTransactionalJUnit38SpringContextTests {

	@Resource
	private NewsService newsService;
	
	@Test
	public void testAddNews(){
		News news=new News();
		news.setNewsType(1);
		news.setNewsContent("123");
		news.setNewsTitle("test");
		news.setDocumentPhaseID(11);
		news.setPublishTime(new Date());
		boolean result= newsService.addNews(news);
		assertEquals(result, true);
	}
//	@Test
//	public void testFindNewsById(){
//		News news=newsService.findNewsById(1);
//		assertEquals(news.getNewsID(), 1);
//	}
//	@Test
//	public void testDeleteNewsById(){
//		boolean result=newsService.deleteNewsById(1);
//		assertEquals(result, true);
//	}
//	@Test
//	public void getNewsListByType(){
//		List<News> newsList=newsService.findNewest(1);
//		for(News news:newsList){
//			System.out.println(news.getNewsContent());
//		}
//	}
}
