package com.jung.productexchangerecord.service;

import com.jung.common.JqueryGridService;
import com.jung.productexchangerecord.model.ProductExchangeRecord;

public interface ProductExchangeRecordService extends JqueryGridService {
	public boolean addProductExchangeRecord(ProductExchangeRecord productExchangeRecord);
	public boolean deleteProductExchangeRecord(ProductExchangeRecord productExchangeRecord);
	public boolean deleteProductExchangeRecordById(int productExchangeRecordID);
	public ProductExchangeRecord getProductExchangeRecordById(int productExchangeRecordID);
}
