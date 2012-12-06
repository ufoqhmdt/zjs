package com.jung.productexchangerecord.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;

import com.jung.doctor.model.Doctor;
import com.jung.doctor.service.DoctorService;
import com.jung.product.model.Product;
import com.jung.product.service.ProductService;
import com.jung.productexchangerecord.model.ProductExchangeRecord;

@ContextConfiguration(locations = { "/applicationContext.xml",
		"/conf/spring/applicationContext-product.xml",
		"/conf/spring/applicationContext-doctor.xml",
		"/conf/spring/applicationContext-productexchangerecord.xml" })
public class ProductExchangeRecordServiceTest extends
		AbstractTransactionalJUnit38SpringContextTests {
	@Resource
	private ProductExchangeRecordService productExchangeRecordService;
	@Resource
	private DoctorService doctorService;
	@Resource
	private ProductService productService;

//	@Test
//	public void testAddRecord() {
//		ProductExchangeRecord exchangeRecord = new ProductExchangeRecord();
//		Doctor doctor = doctorService.getDoctorById(2);
//		Doctor dd=new Doctor();
//		dd.setDoctorPoints(12);
//		dd.setDoctorStatus(1);
//		Product pp=new Product();
//		pp.setProductPoints(12);
//		pp.setProductOrder(1);
//		Product product = productService.getProductByID(2);
//		exchangeRecord.setDoctor(doctor);
//		exchangeRecord.setProduct(product);
//		boolean result=productExchangeRecordService.addProductExchangeRecord(exchangeRecord);
//		assertEquals(result, true);
//
//	}
	@Test
	public void testDeleteRecord(){
		boolean result=productExchangeRecordService.deleteProductExchangeRecordById(1);
		assertEquals(result,true);
	}
}
