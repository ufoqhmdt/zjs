package com.jung.employee.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.jung.doctor.model.Doctor;
import com.jung.region.model.Region;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String REF = "Employee";
	
    private int employeeID;//主键
	private String employeeName;// 代表姓名
	private String employeeMobile;// 代表手机(同时也是登录名)
	private String password;//登录密码
	private String employeeNumber;// 代表编号
	private Integer employeeType;// 代表类型,1->MR,2->DSM,3->PS,4->MARKET
	private String inputUser;//录入人员
	private Integer employeePoints;//代表积分

	
	private Employee parentEmployee;//上级经理
	private Region region;//所属直系区域,地区/大区经理的直系区域就是他所在的地区
	private Set<Doctor> doctorSet=new HashSet<Doctor>();//对应的医师
	private Set<Employee> employeeSet = new HashSet<Employee>();
	/**
	 * @return the employeeID
	 */
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "employeeID", unique = true, nullable = false)
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the employeeName
	 */
	@Column(name = "employeeName", length = 255)
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeMobile
	 */
	@Column(name = "employeeMobile", length = 255)
	public String getEmployeeMobile() {
		return employeeMobile;
	}

	/**
	 * @param employeeMobile
	 *            the employeeMobile to set
	 */
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	/**
	 * @return the employeeNumber
	 */
	@Column(name = "employeeNumber", length = 255)
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber
	 *            the employeeNumber to set
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return the employeeType
	 */
	@Column(name = "employeeType", length = 11)
	public int getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType
	 *            the employeeType to set
	 */
	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @param doctorSet the doctorSet to set
	 */
	public void setDoctorSet(Set<Doctor> doctorSet) {
		this.doctorSet = doctorSet;
	}

	/**
	 * @return the doctorSet
	 */
	@OneToMany(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY,targetEntity=Doctor.class,mappedBy="employeeMR")
	public Set<Doctor> getDoctorSet() {
		return doctorSet;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	@Column(name="password",length=255)
	public String getPassword() {
		return password;
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
	@Column(name="inputUser",length=255)
	public String getInputUser() {
		return inputUser;
	}
	/**
	 * @param employeePoints the employeePoints to set
	 */
	public void setEmployeePoints(Integer employeePoints) {
		this.employeePoints = employeePoints;
	}
	/**
	 * @return the employeePoints
	 */
	@Column(name = "employeePoints", length = 11)
	public Integer getEmployeePoints() {
		return employeePoints;
	}
	/**
	 * @param employeeSet the employeeSet to set
	 */
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	/**
	 * @return the employeeSet
	 */
	@OneToMany(cascade={CascadeType.REFRESH},
				fetch=FetchType.LAZY,
				targetEntity=Employee.class,
				mappedBy="parentEmployee")//****使用了mappedBy属性的一端就是关系被维护端
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	/**
	 * @param parentEmployee the parentEmployee to set
	 */
	public void setParentEmployee(Employee parentEmployee) {
		this.parentEmployee = parentEmployee;
	}
	/**
	 * @return the parentEmployee
	 */
	@ManyToOne(targetEntity=Employee.class,
			cascade={CascadeType.REFRESH},
			fetch=FetchType.EAGER)//多对一
	@JoinColumn(name="parentID")//外键名称
	public Employee getParentEmployee() {
		return parentEmployee;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	/**
	 * @return the region
	 */
	@ManyToOne(targetEntity=Region.class,
			cascade={CascadeType.REFRESH},
			fetch=FetchType.EAGER)//多对一
	@JoinColumn(name="regionID")//外键名称
	public Region getRegion() {
		return region;
	}

}
