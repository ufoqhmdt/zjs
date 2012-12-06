package com.jung.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *  @Description: 用户实体
 *  @version Revision: V1.0 2012-11-5 下午3:08:11
 *  @author GuoJun mailto: jackson@highcolu.com
 */
@Entity
@Table(name = "user")
public class User {
	public static final String REF="User";
	private Integer userID;
	private String userName;
	private String password;
	private String fullName;//全称
	private Boolean available;//是否活动状态
	private Integer userType;// 共五种角色 0 市场部(Marketing) 1 大区经理(RSM\PS) 2 地区经理(DSS\DSM) 3 代表(MR) 4 医师
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "userID", unique = true, nullable = false)
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	@Column(length = 255)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length = 255)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 255)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Column
	public Boolean isAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Column(length = 11)
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
}
