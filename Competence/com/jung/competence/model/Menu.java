package com.jung.competence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Menu")
public class Menu implements Serializable {
	public static final String REF = "Menu";
	private int menuID;// 主键
	private String menunameSimp;// 菜单名称中文
	private String menuurl;// 菜单连接
	private String menupath;// 菜单路径
	private Integer menulevel;// 菜单层级
	private Integer menutype;// 菜单类型(0菜单，1操作)
	private String menucode;// 菜单/功能代码
	private Integer Status;// 状态(0正常，1失效)
	private List<Menu> children = new ArrayList<Menu>();

	@Id
	@Column(name = "menuID", unique = true, nullable = false)
	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	@Column(name = "menunameSimp", nullable = true, length = 255)
	public String getMenunameSimp() {
		return menunameSimp;
	}

	public void setMenunameSimp(String menunameSimp) {
		this.menunameSimp = menunameSimp;
	}

	@Column(name = "menuurl", nullable = true, length = 255)
	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	@Column(name = "menupath", nullable = true, length = 255)
	public String getMenupath() {
		return menupath;
	}

	public void setMenupath(String menupath) {
		this.menupath = menupath;
	}

	@Column(name = "menulevel", nullable = true, length = 11)
	public Integer getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(Integer menulevel) {
		this.menulevel = menulevel;
	}

	@Column(name = "menutype", nullable = true, length = 11)
	public Integer getMenutype() {
		return menutype;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	@Column(name = "menucode", nullable = true, length = 255)
	public String getMenucode() {
		return menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	@Column(name = "Status", nullable = true, length = 11)
	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	/**
	 * @return the children
	 */
	@Transient
	public List<Menu> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}