package com.jung.product.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jung.product.model.Product;
@ContextConfiguration(locations = { "/applicationContext.xml",
"/conf/spring/applicationContext-product.xml"})
@TransactionConfiguration(defaultRollback = false)
public class ProductServiceTestCase extends AbstractTransactionalJUnit38SpringContextTests{
	@Resource
	private ProductService productService;
	
	@Test
	public void testAddProduct(){
		Product product=new Product();
		product.setLastUpdate(new Date());
		product.setProductImgPath("D:/");
		product.setProductOrder(1);
		product.setProductPoints(150);
		product.setProductStatus(1);
		product.setProductName("u盘");
		product.setProductValidEndDate(new Date());
		product.setProductValidStartDate(new Date());
		boolean result= productService.addProduct(product);
		assertEquals(result, true);
	}
//	@Test
//	public void testFindProductById(){
//		Product product=productService.getProductByID(1);
//		assertEquals(product.getProductID(), 1);
//	}
//	@Test
//	public void testDeleteProductById(){
//		boolean result=productService.delteProductByID(1);
//		assertEquals(result, true);
//	}
}
