package com.jung.doctor.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jung.common.JqueryGridAction;
import com.jung.doctor.model.Doctor;
import com.jung.doctor.service.DoctorService;

public class DoctorAction extends JqueryGridAction {

	private static final long serialVersionUID = 1L;
	private static final Log logger = LogFactory.getLog(DoctorAction.class);
	private DoctorService doctorService;
	private Doctor doctor;
	/**
	 * 查询结果列表.
	 */
	private List<Map<String, Object>> dataRows = new ArrayList<Map<String, Object>>();
	private String result;

	
	public String addDoctor(){
		return null;
	}
	public String deleteDoctor(){
		return null;
		
	}
	/**
	 * @param doctorService the doctorService to set
	 */
	@Resource
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}
}
