package com.jung.productexchangerecord.dao.impl;


import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.jung.productexchangerecord.dao.ProductExchangeDao;
import com.jung.productexchangerecord.model.ProductExchangeRecord;

public class ProductExchangeRecordDaoImpl  extends HibernateBaseDao implements ProductExchangeDao {

	@Override
	public Class getEntityType() {
		// TODO Auto-generated method stub
		return ProductExchangeRecord.class;
	}


}
