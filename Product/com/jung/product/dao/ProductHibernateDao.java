package com.jung.product.dao;

import com.jung.product.model.Product;

public interface ProductHibernateDao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean delteProductByID(int productID);
	public Product getProductByID(int productID);
}
