package com.jung.employee.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jung.common.JqueryGridAction;
import com.jung.employee.model.Employee;
import com.jung.employee.service.EmployeeService;

public class EmployeeAction extends JqueryGridAction {
	private static final long serialVersionUID = 1L;
	private static final Log logger = LogFactory.getLog(EmployeeAction.class);
	private EmployeeService employeeService;
	private Employee employee;
	/**
	 * 查询结果列表.
	 */
	private List<Map<String, Object>> dataRows = new ArrayList<Map<String, Object>>();
	private String result;
	
	public String addEmployee(){
		return null;
	}
	public String deleteEmployee(){
		return null;
	}
	
	
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employeeService the employeeService to set
	 */
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
