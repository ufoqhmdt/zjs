package com.jung.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.doctor.model.Rank;
import com.jung.employee.dao.EmployeeHibernateDao;
import com.jung.employee.model.Employee;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;

public class EmployeeHibernateDaoImpl  extends HibernateEntityManagerImpl<Employee> implements EmployeeHibernateDao{

	@Override
	public Class<Employee> getEntityType() {
		// TODO Auto-generated method stub
		return Employee.class;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try{
			super.saveOrUpdate(employee);
			return true;
		}catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try{
			super.remove(employee);
			return true;
		}catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteEmployeeById(int employeeId){
		String sql="delete  from employee where employeeID="+employeeId;
		try {
			super.executeSQLUpdate(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String hql="from Employee where employeeID="+employeeId;
		try {
			List employeeList =super.executeHql(hql); 
			if(employeeList!=null&&employeeList.size()>0){
				return (Employee)employeeList.get(0);
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		String hql="from Employee";
		try {
			List employeeList =super.executeHql(hql);
			if(employeeList!=null&&employeeList.size()>0){
				return employeeList;
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	 public int getEmployeePointsByPhone(String phone){
		 String sql="select employeePoints from employee where employeeMobile='"+phone+"'";
		 try {
		         List<Object[]> list=super.executeSQL(sql);
		         if(list!=null&&list.size()>0){
		        		return Integer.parseInt(String.valueOf(list.get(0)));
		         }
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	 }
	 public List<Rank> getEmployeeRank(){
			String sql = "select employeeCity,employeeName,employeePoints from employee where employeeType=1 order by employeePoints desc limit 0,50";
		    List<Rank> rankList=new ArrayList<Rank>();
			try {
				List<Object[]> list = super.executeSQL(sql);
				if (list != null && list.size() > 0) {
					for(int i=0;i<list.size();i++){
						Object object[]=list.get(i);
						Rank rank=new Rank();
						rank.setRankID(i+1);
						rank.setCity(String.valueOf(object[0]));
	 					rank.setName(String.valueOf(object[1]));
						rank.setPoints(Integer.parseInt(String.valueOf(object[2])));
						rankList.add(rank);
					}
					return rankList;
				}
			} catch (SkeletonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	 }
     public List<Rank> getDistrictRank(){
    	 String sql = "select employeeCity,sum(employeePoints) as employeePoints from employee where employeeType=1  group by employeeCity order by employeePoints desc";
		    List<Rank> rankList=new ArrayList<Rank>();
			try {
				List<Object[]> list = super.executeSQL(sql);
				if (list != null && list.size() > 0) {
					for(int i=0;i<list.size();i++){
						Object object[]=list.get(i);
						Rank rank=new Rank();
						rank.setRankID(i+1);
						rank.setCity(String.valueOf(object[0]));
						rank.setPoints(Integer.parseInt(String.valueOf(object[1])));
						rankList.add(rank);
					}
					return rankList;
				}
			} catch (SkeletonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
     }

	@Override
	public boolean updatePassword(int employeeID, int newPassword) {
		// TODO Auto-generated method stub
		String sql="update employee set password="+newPassword+" where employeeID="+employeeID;
		try {
			super.executeSQL(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	  public List<Employee> getEmployeeByParentID(int parentID){
		  String hql="from Employee where as employee where employee.parentID="+parentID;
		  try {
				List employeeList =super.executeHql(hql);
				if(employeeList!=null&&employeeList.size()>0){
					return employeeList;
				}
			} catch (SkeletonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
	  }

}