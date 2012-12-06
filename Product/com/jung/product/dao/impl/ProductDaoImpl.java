package com.jung.product.dao.impl;

import java.util.List;

import com.hp.util.Page;
import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.hp.xquery.SimpleQuery;
import com.jung.product.dao.ProductDao;
import com.jung.product.model.Product;

public class ProductDaoImpl extends HibernateBaseDao implements ProductDao {

	@Override
	public Class getEntityType() {
		// TODO Auto-generated method stub
		return Product.class;
	}



}
