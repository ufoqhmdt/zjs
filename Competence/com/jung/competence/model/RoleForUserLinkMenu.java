package com.jung.competence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 角色与菜单关联表
 */
@Entity
@Table(name = "RoleForUserLinkMenu")
public class RoleForUserLinkMenu implements Serializable {
	public static final String REF = "RoleForUserLinkMenu";	
	private int rfulmID;
	private Integer roleID;
	private Integer menuID;

	@Id
	@Column(name = "rfulmID", unique = true, nullable = false)
	public int getRfulmID() {
		return rfulmID;
	}

	public void setRfulmID(int rfulmID) {
		this.rfulmID = rfulmID;
	}
	@Column(name = "roleID", nullable = true, length = 11)
	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	@Column(name = "menuID", nullable = true, length = 11)
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

}
