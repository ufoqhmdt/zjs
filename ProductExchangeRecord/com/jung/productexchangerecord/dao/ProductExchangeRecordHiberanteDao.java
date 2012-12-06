package com.jung.productexchangerecord.dao;

import com.jung.productexchangerecord.model.ProductExchangeRecord;

public interface ProductExchangeRecordHiberanteDao {

	public boolean addProductExchangeRecord(ProductExchangeRecord productExchangeRecord);
	public boolean deleteProductExchangeRecord(ProductExchangeRecord productExchangeRecord);
	public boolean deleteProductExchangeRecordById(int productExchangeRecordID);
	public ProductExchangeRecord getProductExchangeRecordById(int productExchangeRecordID);
	
}
