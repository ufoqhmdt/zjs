package com.jung.product.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.hp.util.PageContext;
import com.jung.product.dao.ProductDao;
import com.jung.product.dao.ProductHibernateDao;
import com.jung.product.model.Product;
import com.jung.product.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductHibernateDao productHibernateDao;
	private ProductDao productDao;

	/**
	 * @param productHibernateDao the productHibernateDao to set
	 */
	@Resource
	public void setProductHibernateDao(ProductHibernateDao productHibernateDao) {
		this.productHibernateDao = productHibernateDao;
	}

	@Override
	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean support(String entityName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productHibernateDao.addProduct(product);
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productHibernateDao.deleteProduct(product);
	}

	@Override
	public boolean delteProductByID(int productID) {
		// TODO Auto-generated method stub
		return productHibernateDao.delteProductByID(productID);
	}

	@Override
	public Product getProductByID(int productID) {
		// TODO Auto-generated method stub
		return productHibernateDao.getProductByID(productID);
	}

	/**
	 * @param productDao the productDao to set
	 */
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
