package com.jung.employee.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hp.util.PageContext;
import com.jung.doctor.model.Rank;
import com.jung.employee.dao.EmployeeDao;
import com.jung.employee.dao.EmployeeHibernateDao;
import com.jung.employee.model.Employee;
import com.jung.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	private EmployeeHibernateDao employeeHibernateDao;
	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeHibernateDao.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeHibernateDao.deleteEmployee(employee);
	}
	public boolean deleteEmployeeById(int employeeId){
		return employeeHibernateDao.deleteEmployeeById(employeeId);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeHibernateDao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeHibernateDao.getEmployees();
	}
	 public int getEmployeePointsByPhone(String phone){
		 return employeeHibernateDao.getEmployeePointsByPhone(phone);
	 }
	 public List<Rank> getEmployeeRank(){
		 return employeeHibernateDao.getEmployeeRank(); 
	 }
	/**
	 * @param employeeDao the employeeDao to set
	 */
	@Resource
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * @param employeeHibernateDao the employeeHibernateDao to set
	 */
	@Resource
	public void setEmployeeHibernateDao(EmployeeHibernateDao employeeHibernateDao) {
		this.employeeHibernateDao = employeeHibernateDao;
	}

	@Override
	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean support(String entityName) {
		if (entityName != null && entityName.trim().length() != 0) {
			if (entityName.equals(Employee.REF)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePassword(int employeeID, int newPassword) {
		// TODO Auto-generated method stub
		return employeeHibernateDao.updatePassword(employeeID, newPassword);
	}

	@Override
	public List<Employee> getEmployeeByParentID(int parentID) {
		// TODO Auto-generated method stub
		return employeeHibernateDao.getEmployeeByParentID(parentID);
	}

	@Override
	public List<Rank> getDistrictRank() {
		// TODO Auto-generated method stub
		return null;
	}

}
