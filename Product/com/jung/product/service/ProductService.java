package com.jung.product.service;

import com.jung.common.JqueryGridService;
import com.jung.product.model.Product;

public interface ProductService extends JqueryGridService {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean delteProductByID(int productID);
	public Product getProductByID(int productID);
}
