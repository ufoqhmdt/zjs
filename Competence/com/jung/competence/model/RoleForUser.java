package com.jung.competence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 用户与角色关联表
 */
@Entity
@Table(name = "RoleForUser")
public class RoleForUser implements Serializable {
	/**
	 * 
	 */
	public static final String REF = "RoleForUser";	
	private static final long serialVersionUID = 1L;
	private int roleID;
	private String roleSimp;
	private Integer status;

	@Id
	@Column(name = "roleID", unique = true, nullable = false)
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	@Column(name = "roleSimp", nullable = true, length = 255)
	public String getRoleSimp() {
		return roleSimp;
	}

	public void setRoleSimp(String roleSimp) {
		this.roleSimp = roleSimp;
	}

	@Column(name = "status", nullable = true, length = 11)
	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
