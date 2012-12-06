package com.jung.doctor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hp.util.PageContext;
import com.jung.doctor.dao.DoctorDao;
import com.jung.doctor.dao.DoctorHibernateDao;
import com.jung.doctor.model.Doctor;
import com.jung.doctor.model.Rank;
import com.jung.doctor.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao;
	private DoctorHibernateDao doctorHibernateDao;

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.addDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.deleteDoctor(doctor);
	}

	public boolean deleteDoctorByID(int doctorID) {
		return doctorHibernateDao.deleteDoctorByID(doctorID);
	}

	@Override
	public Doctor getDoctorById(int doctorId) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.getDoctorById(doctorId);
	}

	@Override
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return doctorHibernateDao.getDoctors();
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
			if (entityName.equals(Doctor.REF)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param doctorDao
	 *            the doctorDao to set
	 */
	@Resource
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	/**
	 * @param doctorHibernateDao
	 *            the doctorHibernateDao to set
	 */
	@Resource
	public void setDoctorHibernateDao(DoctorHibernateDao doctorHibernateDao) {
		this.doctorHibernateDao = doctorHibernateDao;
	}

	@Override
	public boolean updateDoctorPoints(int doctorID, int newPoints) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.updateDoctorPoints(doctorID, newPoints);
	}

	public int getDoctorPointsByPhone(String phone) {
		return doctorHibernateDao.getDoctorPointsByPhone(phone);
	}
	 public List<Rank> getDoctorRank(){
		 return doctorHibernateDao.getDoctorRank();
	 }

	@Override
	public String activeDoctor(int doctorID, String doctorActivateOption) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.activeDoctor(doctorID, doctorActivateOption);
	}

	@Override
	public boolean lockDoctor(int docotrID) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.lockDoctor(docotrID);
	}

	@Override
	public boolean unLockDoctor(int doctorID) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.unLockDoctor(doctorID);
	}

	@Override
	public boolean updatePassword(int doctorID, int newPassword) {
		// TODO Auto-generated method stub
		return doctorHibernateDao.updatePassword(doctorID, newPassword);
	}
	 

}
