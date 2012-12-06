package com.jung.productexchangerecord.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jung.doctor.model.Doctor;
import com.jung.product.model.Product;
@Entity
@Table(name = "ProductExchangeRecord")
public class ProductExchangeRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REF="ProductExchangeRecord";
    private int productExchangeRecordID;//主键
    private Doctor doctor;//对应医师
	private Product product;//对应产品
    
    /**
	 * @return the productExchangeRecordID
	 */
    @Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "productExchangeRecordID", unique = true, nullable = false)
	public int getProductExchangeRecordID() {
		return productExchangeRecordID;
	}

	/**
	 * @param productExchangeRecordID the productExchangeRecordID to set
	 */
	public void setProductExchangeRecordID(int productExchangeRecordID) {
		this.productExchangeRecordID = productExchangeRecordID;
	}

	/**
	 * @return the doctor
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "doctorID")
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the product
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "productID")
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}


}
