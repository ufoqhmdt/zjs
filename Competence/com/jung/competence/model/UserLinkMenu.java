package com.jung.competence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 用户菜单关联表
 */
@Entity
@Table(name="UserLinkMenu")
public class UserLinkMenu implements Serializable {

	public static final String REF = "UserLinkMenu";
	private int ulmID;
	private Integer userID;
	private Integer companyID;
	private Integer menuID;
	@Id
	@Column
	public int getUlmID() {
		return ulmID;
	}
	public void setUlmID(int ulmID) {
		this.ulmID = ulmID;
	}
	@Column(name = "userID", nullable = true, length = 11)
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	@Column(name = "companyID", nullable = true, length = 11)
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	@Column(name = "menuID", nullable = true, length = 11)
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
}
