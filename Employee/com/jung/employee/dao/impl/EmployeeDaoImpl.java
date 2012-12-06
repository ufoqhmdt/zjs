package com.jung.employee.dao.impl;


import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.jung.employee.dao.EmployeeDao;
import com.jung.employee.model.Employee;

public class EmployeeDaoImpl extends HibernateBaseDao implements EmployeeDao {
	@Override
	public Class getEntityType() {
		return Employee.class;
	}

}
