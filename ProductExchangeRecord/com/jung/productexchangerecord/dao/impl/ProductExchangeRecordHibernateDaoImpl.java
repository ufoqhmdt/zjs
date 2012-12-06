package com.jung.productexchangerecord.dao.impl;

import java.util.List;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;
import com.jung.productexchangerecord.dao.ProductExchangeRecordHiberanteDao;
import com.jung.productexchangerecord.model.ProductExchangeRecord;

public class ProductExchangeRecordHibernateDaoImpl extends HibernateEntityManagerImpl<ProductExchangeRecord> implements
		ProductExchangeRecordHiberanteDao {

	@Override
	public boolean addProductExchangeRecord(
			ProductExchangeRecord productExchangeRecord) {
		try {
			super.saveOrUpdate(productExchangeRecord);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProductExchangeRecord(
			ProductExchangeRecord productExchangeRecord) {
		try {
			super.remove(productExchangeRecord);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProductExchangeRecordById(int productExchangeRecordID) {
		String sql = "delete from productexchangerecord where productExchangeRecordID=" + productExchangeRecordID;
		try {
			super.executeSQLUpdate(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ProductExchangeRecord getProductExchangeRecordById(
			int productExchangeRecordID) {
		// TODO Auto-generated method stub
		String hql = "from ProductExchangeRecord where productExchangeRecordID=" + productExchangeRecordID;
		try {
			List productExchangeRecordList = super.executeHql(hql);
			if (productExchangeRecordList != null && productExchangeRecordList.size() > 0) {
				return (ProductExchangeRecord) productExchangeRecordList.get(0);
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Class<ProductExchangeRecord> getEntityType() {
		// TODO Auto-generated method stub
		return ProductExchangeRecord.class;
	}

}
