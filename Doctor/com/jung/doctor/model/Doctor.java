package com.jung.doctor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jung.common.ConvertUtil;
import com.jung.employee.model.Employee;
import com.jung.productexchangerecord.model.ProductExchangeRecord;
import com.jung.region.model.Region;

@Entity
@Table(name = "Doctor")
public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String REF = "Doctor";
	
	private int doctorID;// 主键
	private String doctorTargetDept;// 目标科室
	private String doctorName;// 医师姓名
	private String doctorJobTitle;// 医师职称
	private Integer doctorPoints;// 医师积分
	private String doctorMobile;// 医师手机
	private Date doctorRegisterDate;// 注册日期
	private Date lastDate;// 修改日期
	private Date doctorActivateDate;// 激活日期
	private Integer doctorStatus;// 医师状态,0-未激活,1-激活,2-不活动
	private String doctorActivateOption;// 激活选项,A、C、F
	private String inputUser;//录入人员

	private Employee employeeMR;// 关联MR代表ID
	private Region region;//所在地区,地区里面包含医院编号
	 private Set<ProductExchangeRecord> recordSet=new HashSet<ProductExchangeRecord>();//兑换记录
	
	/**
	 * @return the doctorID
	 */
	@Id
	@GeneratedValue
	@Column(name = "doctorID", unique = true, nullable = false)
	public int getDoctorID() {
		return doctorID;
	}
	/**
	 * @param doctorID
	 *            the doctorID to set
	 */
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	/**
	 * @return the doctorTargetDept
	 */
	@Column(name = "doctorTargetDept", length = 255)
	public String getDoctorTargetDept() {
		return doctorTargetDept;
	}

	/**
	 * @param doctorTargetDept
	 *            the doctorTargetDept to set
	 */
	public void setDoctorTargetDept(String doctorTargetDept) {
		this.doctorTargetDept = doctorTargetDept;
	}

	/**
	 * @return the doctorName
	 */
	@Column(name = "doctorName", length = 255)
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName
	 *            the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the doctorJobTitle
	 */
	@Column(name = "doctorJobTitle", length = 255)
	public String getDoctorJobTitle() {
		return doctorJobTitle;
	}

	/**
	 * @param doctorJobTitle
	 *            the doctorJobTitle to set
	 */
	public void setDoctorJobTitle(String doctorJobTitle) {
		this.doctorJobTitle = doctorJobTitle;
	}

	/**
	 * @return the doctorPoints
	 */
	@Column(name = "doctorPoints", length = 255)
	public int getDoctorPoints() {
		return doctorPoints;
	}

	/**
	 * @param doctorPoints
	 *            the doctorPoints to set
	 */
	public void setDoctorPoints(int doctorPoints) {
		this.doctorPoints = doctorPoints;
	}

	/**
	 * @return the doctorMobile
	 */
	@Column(name = "doctorMobile", length = 255)
	public String getDoctorMobile() {
		return doctorMobile;
	}

	/**
	 * @param doctorMobile
	 *            the doctorMobile to set
	 */
	public void setDoctorMobile(String doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	/**
	 * @return the doctorRegisterDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDoctorRegisterDate() {
		if (doctorRegisterDate != null) {
			doctorRegisterDate = ConvertUtil
					.timestampToDate(doctorRegisterDate);
		}
		return doctorRegisterDate;
	}

	/**
	 * @param doctorRegisterDate
	 *            the doctorRegisterDate to set
	 */
	public void setDoctorRegisterDate(Date doctorRegisterDate) {
		this.doctorRegisterDate = doctorRegisterDate;
	}

	/**
	 * @return the lastDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastDate() {
		if (lastDate != null) {
			lastDate = ConvertUtil.timestampToDate(lastDate);
		}
		return lastDate;
	}

	/**
	 * @param lastDate
	 *            the lastDate to set
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	/**
	 * @return the doctorActivateDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDoctorActivateDate() {
		if (doctorActivateDate != null) {
			doctorActivateDate = ConvertUtil
					.timestampToDate(doctorActivateDate);
		}
		return doctorActivateDate;
	}

	/**
	 * @param doctorActivateDate
	 *            the doctorActivateDate to set
	 */
	public void setDoctorActivateDate(Date doctorActivateDate) {
		this.doctorActivateDate = doctorActivateDate;
	}

	/**
	 * @return the doctorStatus
	 */
	@Column(name = "doctorStatus", length = 11)
	public int getDoctorStatus() {
		return doctorStatus;
	}

	/**
	 * @param doctorStatus
	 *            the doctorStatus to set
	 */
	public void setDoctorStatus(int doctorStatus) {
		this.doctorStatus = doctorStatus;
	}

	/**
	 * @return the doctorActivateOption
	 */
	@Column(name = "doctorActivateOption", length = 255)
	public String getDoctorActivateOption() {
		return doctorActivateOption;
	}

	/**
	 * @param doctorActivateOption
	 *            the doctorActivateOption to set
	 */
	public void setDoctorActivateOption(String doctorActivateOption) {
		this.doctorActivateOption = doctorActivateOption;
	}

	/**
	 * @param employeeMR
	 *            the employeeMR to set
	 */
	public void setEmployeeMR(Employee employeeMR) {
		this.employeeMR = employeeMR;
	}

	/**
	 * @return the employeeMR
	 */
	@ManyToOne(targetEntity = Employee.class, cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "mrID")
	public Employee getEmployeeMR() {
		return employeeMR;
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
	 * @param recordSet the recordSet to set
	 */
	public void setRecordSet(Set<ProductExchangeRecord> recordSet) {
		this.recordSet = recordSet;
	}
	/**
	 * @return the recordSet
	 */
	@OneToMany(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY,mappedBy="doctor")
	public Set<ProductExchangeRecord> getRecordSet() {
		return recordSet;
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
	@JoinColumn(name="hospitalID")//外键名称
	public Region getRegion() {
		return region;
	}
}
