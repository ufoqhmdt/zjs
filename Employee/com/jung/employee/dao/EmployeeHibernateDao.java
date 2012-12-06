package com.jung.employee.dao;

import java.util.List;

import com.jung.doctor.model.Rank;
import com.jung.employee.model.Employee;

public interface EmployeeHibernateDao{
	  public boolean addEmployee(Employee employee);
      public boolean deleteEmployee(Employee employee);
      public boolean deleteEmployeeById(int employeeId);
      public Employee getEmployeeById(int employeeId);
      public List<Employee> getEmployees();
      public int getEmployeePointsByPhone(String phone);
      public List<Rank> getEmployeeRank();
      public List<Rank> getDistrictRank();
      public boolean updatePassword(int employeeID,int newPassword);
      public List<Employee> getEmployeeByParentID(int parentID);
}
