package com.jung.employee.service;

import java.util.List;

import com.jung.common.JqueryGridService;
import com.jung.doctor.model.Rank;
import com.jung.employee.model.Employee;

public interface EmployeeService extends JqueryGridService {
	  public boolean addEmployee(Employee employee);
      public boolean deleteEmployee(Employee employee);
      public boolean deleteEmployeeById(int employeeId);
      public Employee getEmployeeById(int employeeId);
      public List<Employee> getEmployees();
      
      public int getEmployeePointsByPhone(String phone);//根据代表手机号查询积分
      public List<Rank> getEmployeeRank();//获取代表(MR)的累积积分排名,前50名
      public List<Rank> getDistrictRank();//获取地区排名
      public boolean updatePassword(int employeeID,int newPassword);//代表修改密码
      public List<Employee> getEmployeeByParentID(int parentID);//根据上级经理ID查看其下面所有的MR
}
