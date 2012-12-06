package com.jung.competence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
/*
 * 角色与用户关联表
 */
@Entity
@Table(name="RoleLinkUser")
public class RoleLinkUser implements Serializable{

	public static final String REF = "RoleLinkUser";
	private int rluID;
	private Integer roleID;
	private Integer userID;
	
	@Id
	@Column(name = "rluID", unique = true, nullable = false)
	public int getRluID() {
		return rluID;
	}
	public void setRluID(int rluID) {
		this.rluID = rluID;
	}
	@Column(name = "roleID", nullable = true, length = 11)
	@Index(name = "roleID")
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	@Column(name = "userID", nullable = true, length = 11)
	public Integer getUserID() {
		return userID;
	}
	
	
}
