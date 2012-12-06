package com.jung.product.dao.impl;

import java.util.List;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.doctor.model.Doctor;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;
import com.jung.product.dao.ProductHibernateDao;
import com.jung.product.model.Product;

public class ProductHibernateDaoImpl  extends HibernateEntityManagerImpl<Product> implements ProductHibernateDao {

	@Override
	public Class<Product> getEntityType() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	public boolean addProduct(Product product){
		try {
			super.saveOrUpdate(product);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteProduct(Product product){
		try {
			super.remove(product);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delteProductByID(int productID){
		String sql = "delete from product where productID=" + productID;
		try {
			super.executeSQLUpdate(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public Product getProductByID(int productID){
		String hql = "from Product where productID=" + productID;
		try {
			List productList = super.executeHql(hql);
			if (productList != null && productList.size() > 0) {
				return (Product) productList.get(0);
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}
}
