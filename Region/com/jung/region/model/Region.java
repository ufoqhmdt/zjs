package com.jung.region.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Region")
public class Region implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "Region";
	private int regionID;	//自动编号,主键
	private Integer regionType;//	区域类型,0大区(省)/1地区(市)/2医院3科室 
	private String hospitalNumber;	//编号 ,只有医院才有编号
	private String inputUser;	//录入人员
	private Region parentRegion;//上级区域
	/**
	 * @return the regionID
	 */
	@Id
	@GeneratedValue
	@Column(name = "regionID", unique = true, nullable = false)
	public int getRegionID() {
		return regionID;
	}
	/**
	 * @param regionID the regionID to set
	 */
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}
	/**
	 * @return the hospitalNumber
	 */
	@Column(name = "hospitalNumber", length = 255)
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	/**
	 * @param hospitalNumber the hospitalNumber to set
	 */
	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}
	/**
	 * @param regionType the regionType to set
	 */
	public void setRegionType(Integer regionType) {
		this.regionType = regionType;
	}
	/**
	 * @return the regionType
	 */
	@Column(name = "regionType", length = 255)
	public Integer getRegionType() {
		return regionType;
	}
	/**
	 * @param inputUser the inputUser to set
	 */
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
	/**
	 * @return the inputUser
	 */
	@Column(name = "inputUser", length = 255)
	public String getInputUser() {
		return inputUser;
	}
	/**
	 * @param parentRegion the parentRegion to set
	 */
	public void setParentRegion(Region parentRegion) {
		this.parentRegion = parentRegion;
	}
	/**
	 * @return the parentRegion
	 */
	@ManyToOne(cascade={CascadeType.REFRESH},
			fetch=FetchType.EAGER)//多对一
	@JoinColumn(name="regionParentID")//外键名称
	public Region getParentRegion() {
		return parentRegion;
	}
}
