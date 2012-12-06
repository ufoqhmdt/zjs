package com.jung.doctor.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jung.doctor.model.Doctor;
import com.jung.doctor.model.Rank;
import com.jung.employee.model.Employee;
import com.jung.employee.service.EmployeeService;

@ContextConfiguration(locations = { "/applicationContext.xml",
		"/conf/spring/applicationContext-doctor.xml",
		"/conf/spring/applicationContext-employee.xml" })
@TransactionConfiguration(defaultRollback = false)
public class DoctorAndEmployeeServiceTestCase extends
		AbstractTransactionalJUnit38SpringContextTests {

	@Resource
	private DoctorService doctorService;
	@Resource
	private EmployeeService employeeService;

	@Test
	public void testAddDoctor() {
		Doctor doctor = new Doctor();
		Employee employeeMR = employeeService.getEmployeeById(2);
		assertEquals(employeeMR.getEmployeeID(), 2);

		doctor.setDoctorMobile("11111111");
		doctor.setDoctorRegisterDate(new Date());
		doctor.setDoctorActivateDate(new Date());
		doctor.setLastDate(new Date());
		doctor.setDoctorName("yinyu");
		doctor.setDoctorPoints(100);
		doctor.setDoctorJobTitle("主治医师");
		doctor.setDoctorStatus(1);

		// doctor.setEmployeeDSM(employeeDSM);
		doctor.setEmployeeMR(employeeMR);
		// doctor.setEmployeeRSM(employeeRSM);

		boolean result = doctorService.addDoctor(doctor);
		assertEquals(result, true);
	}

//	@Test
//	public void testAddEmployee() {
//		for(int i=0;i<5;i++){
//			Employee employeeMR = new Employee();
//			employeeMR.setEmployeeName("yinyu");
//			employeeMR.setEmployeePoints(11);
//			employeeMR.setParentID(12);
//			employeeMR.setEmployeeType(1);
//			employeeService.addEmployee(employeeMR);
//		}
//	}
//
//	@Test
//	public void testFindDoctorById() {
//		Doctor doctor = doctorService.getDoctorById(1);
//		assertEquals(doctor.getDoctorID(), 1);
//	}
//
//	@Test
//	public void testFindEmployeeById() {
//		Employee employeeMR = employeeService.getEmployeeById(2);
//		assertEquals(employeeMR.getEmployeeID(), 2);
//	}
//
//	@Test
//	public void testDeleteDoctor() {
//		Doctor doctor = doctorService.getDoctorById(2);
//		assertEquals(doctor.getDoctorID(), 2);
//		boolean result = doctorService.deleteDoctor(doctor);
//		assertEquals(result, true);
//	}
//	@Test
//	public void testDeleteDoctorById(){
//		boolean result=doctorService.deleteDoctorByID(1);
//		assertEquals(result, true);
//	}
//
//	@Test
//	public void testDeleteEmployee() {
//		Employee employeeMR = employeeService.getEmployeeById(4);
//		assertEquals(employeeMR.getEmployeeID(), 4);
//		boolean result = employeeService.deleteEmployee(employeeMR);
//		assertEquals(result, true);
//	}
//	@Test
//	public void testDeleteEmployeeById(){
//		boolean result =employeeService.deleteEmployeeById(5);
//		assertEquals(result, true);
//	}
//	@Test
//	public void testGetAllEmployee(){
//		List<Employee> employees=employeeService.getEmployees();
//		for(Employee employee:employees){
//			System.out.println(employee.getEmployeeID());
//		}
//	}
//	@Test
//	public void testGetAllDoctor(){
//		List<Doctor> doctors=doctorService.getDoctors();
//		for(Doctor doctor:doctors){
//			System.out.println(doctor.getDoctorID());
//		}
//	}
//	@Test
//	public void testUpdateDoctorPoints(){
//		 boolean result=doctorService.updateDoctorPoints(1, 100);
//			assertEquals(result, true);
//	}
//	@Test
//	public void testGetDoctorPointsByPhone(){
//		int points=doctorService.getDoctorPointsByPhone("123");
//		assertEquals(points, 100);
//	}
//	@Test
//	public void testGetDoctorRank(){
//		List<Rank> list=doctorService.getDoctorRank();
//		for(Rank rank:list){
//			System.out.println(rank.getRankID());
//			System.out.println(rank.getName());
//			System.out.println(rank.getCity());
//			System.out.println(rank.getPoints());
//		}
//	}
//	@Test
//	public void testGetEmployeePointsByPhone(){
//		int points=employeeService.getEmployeePointsByPhone("123");
//		assertEquals(points, 100);
//	}
//	@Test
//	public void testGetEmployeeRank(){
//		List<Rank> list=employeeService.getEmployeeRank();
//		for(Rank rank:list){
//			System.out.println(rank.getRankID());
//			System.out.println(rank.getName());
//			System.out.println(rank.getCity());
//			System.out.println(rank.getPoints());
//		}
//	}
}
