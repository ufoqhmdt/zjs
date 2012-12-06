package com.jung.product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jung.common.ConvertUtil;
import com.jung.productexchangerecord.model.ProductExchangeRecord;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "Product";

	private int productID; // 自动编号
	private String productName; // 产品名称
	private String productImgPath; // 产品图片路径
	private Integer productPoints; // 兑换所需积分
	private Integer productOrder; // 排序序号
	private Integer productStatus; // 审核状态
	private Date productValidStartDate; // 有效开始日期
	private Date productValidEndDate;// 失效日期
	private Date lastUpdate; // 录入日期
    private Set<ProductExchangeRecord> recordSet=new HashSet<ProductExchangeRecord>();//兑换记录
	/**
	 * @return the productID
	 */
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "productID", unique = true, nullable = false)
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the productName
	 */
	@Column(name = "productName", length = 255)
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productImgPath
	 */
	@Column(name = "productImgPath", length = 255)
	public String getProductImgPath() {
		return productImgPath;
	}

	/**
	 * @param productImgPath
	 *            the productImgPath to set
	 */
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

	/**
	 * @return the productPoints
	 */
	@Column(name = "productPoints", length = 11)
	public Integer getProductPoints() {
		return productPoints;
	}

	/**
	 * @param productPoints
	 *            the productPoints to set
	 */
	public void setProductPoints(Integer productPoints) {
		this.productPoints = productPoints;
	}

	/**
	 * @return the productOrder
	 */
	@Column(name = "productOrder", length = 11)
	public Integer getProductOrder() {
		return productOrder;
	}

	/**
	 * @param productOrder
	 *            the productOrder to set
	 */
	public void setProductOrder(Integer productOrder) {
		this.productOrder = productOrder;
	}

	/**
	 * @return the productStatus
	 */
	@Column(name = "productStatus", length = 11)
	public Integer getProductStatus() {
		return productStatus;
	}

	/**
	 * @param productStatus
	 *            the productStatus to set
	 */
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * @return the productValidStartDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getProductValidStartDate() {
		if (productValidStartDate != null) {
			productValidStartDate = ConvertUtil
					.timestampToDate(productValidStartDate);
		}
		return productValidStartDate;
	}

	/**
	 * @param productValidStartDate
	 *            the productValidStartDate to set
	 */
	public void setProductValidStartDate(Date productValidStartDate) {
		this.productValidStartDate = productValidStartDate;
	}

	/**
	 * @return the productValidEndDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getProductValidEndDate() {
		if (productValidEndDate != null) {
			productValidEndDate = ConvertUtil
					.timestampToDate(productValidEndDate);
		}
		return productValidEndDate;
	}

	/**
	 * @param productValidEndDate
	 *            the productValidEndDate to set
	 */
	public void setProductValidEndDate(Date productValidEndDate) {
		this.productValidEndDate = productValidEndDate;
	}

	/**
	 * @return the lastUpdate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastUpdate() {
		if (lastUpdate != null) {
			lastUpdate = ConvertUtil
					.timestampToDate(lastUpdate);
		}
		return lastUpdate;
	}

	/**
	 * @param lastUpdate
	 *            the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @param recordSet the recordSet to set
	 */
	public void setRecordSet(Set<ProductExchangeRecord> recordSet) {
		this.recordSet = recordSet;
	}

	/**
	 * @return the recordSet
	 */
	@OneToMany(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY,mappedBy="product")
	public Set<ProductExchangeRecord> getRecordSet() {
		return recordSet;
	}
}
