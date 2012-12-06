package com.jung.productexchangerecord.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.hp.util.PageContext;
import com.jung.news.model.News;
import com.jung.product.dao.ProductHibernateDao;
import com.jung.productexchangerecord.dao.ProductExchangeDao;
import com.jung.productexchangerecord.dao.ProductExchangeRecordHiberanteDao;
import com.jung.productexchangerecord.model.ProductExchangeRecord;
import com.jung.productexchangerecord.service.ProductExchangeRecordService;

public class ProductExchangeRecordServiceImpl implements
		ProductExchangeRecordService {

	private ProductExchangeRecordHiberanteDao productExchangeRecordHiberanteDao;
	private ProductExchangeDao productExchangeDao;

	/**
	 * @param productExchangeRecordHiberanteDao the productExchangeRecordHiberanteDao to set
	 */
	@Resource
	public void setProductExchangeRecordHiberanteDao(
			ProductExchangeRecordHiberanteDao productExchangeRecordHiberanteDao) {
		this.productExchangeRecordHiberanteDao = productExchangeRecordHiberanteDao;
	}

	@Override
	public boolean addProductExchangeRecord(
			ProductExchangeRecord productExchangeRecord) {
		// TODO Auto-generated method stub
		return productExchangeRecordHiberanteDao.addProductExchangeRecord(productExchangeRecord);
	}

	@Override
	public boolean deleteProductExchangeRecord(
			ProductExchangeRecord productExchangeRecord) {
		// TODO Auto-generated method stub
		return productExchangeRecordHiberanteDao.deleteProductExchangeRecord(productExchangeRecord);
	}

	@Override
	public boolean deleteProductExchangeRecordById(int productExchangeRecordID) {
		// TODO Auto-generated method stub
		return productExchangeRecordHiberanteDao.deleteProductExchangeRecordById(productExchangeRecordID);
	}

	@Override
	public ProductExchangeRecord getProductExchangeRecordById(
			int productExchangeRecordID) {
		// TODO Auto-generated method stub
		return productExchangeRecordHiberanteDao.getProductExchangeRecordById(productExchangeRecordID);
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
		if (entityName != null && entityName.trim().length() != 0) {
			if (entityName.equals(ProductExchangeRecord.REF)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param productExchangeDao the productExchangeDao to set
	 */
	@Resource
	public void setProductExchangeDao(ProductExchangeDao productExchangeDao) {
		this.productExchangeDao = productExchangeDao;
	}

}
