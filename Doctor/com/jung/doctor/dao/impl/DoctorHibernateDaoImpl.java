package com.jung.doctor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.jung.common.HibernateEntityManagerImpl;
import com.jung.common.PasswordUtil;
import com.jung.doctor.dao.DoctorHibernateDao;
import com.jung.doctor.model.Doctor;
import com.jung.doctor.model.Rank;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;

public class DoctorHibernateDaoImpl extends HibernateEntityManagerImpl<Doctor>
		implements DoctorHibernateDao {
	@Override
	public Class<Doctor> getEntityType() {
		return Doctor.class;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		try {
			super.saveOrUpdate(doctor);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		try {
			super.remove(doctor);
			return true;
		} catch (SkeletonSystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDoctorByID(int doctorID) {
		String sql = "delete from doctor where doctorID=" + doctorID;
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
	public Doctor getDoctorById(int doctorId) {
		// TODO Auto-generated method stub
		String hql = "from Doctor where doctorID=" + doctorId;
		try {
			List doctorList = super.executeHql(hql);
			if (doctorList != null && doctorList.size() > 0) {
				return (Doctor) doctorList.get(0);
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		String hql = "from Doctor";
		try {
			List doctorList = super.executeHql(hql);
			if (doctorList != null && doctorList.size() > 0) {
				return doctorList;
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateDoctorPoints(int doctorID, int newPoints) {
		// TODO Auto-generated method stub
		String sql = "update doctor set doctorPoints=" + newPoints
				+ " where doctorID=" + doctorID;
		try {
			super.executeSQLUpdate(sql);
			return true;
		} catch (SkeletonException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getDoctorPointsByPhone(String phone) {
		String sql = "select doctorPoints from doctor where doctorMobile='"
				+ phone + "'";
		try {
			List<Object[]> list = super.executeSQL(sql);
			if (list != null && list.size() > 0) {
				return Integer.parseInt(String.valueOf(list.get(0)));
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public List<Rank> getDoctorRank() {
		String sql = "select doctorCity,doctorName,doctorPoints from doctor where  doctorStatus=1 order by doctorPoints desc  limit 0,50";
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

	@Override
	public String activeDoctor(int doctorID, String doctorActivateOption) {
		String password=PasswordUtil.generatePassword();
		String sql="update doctor set doctorActivateOption='"+doctorActivateOption+"'"+" and password='"+password+"'"+" where doctorID="+doctorID;
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public boolean lockDoctor(int docotrID) {
		// TODO Auto-generated method stub
		String sql="update doctor set doctorStatus=2 where doctorID="+docotrID;
		try {
			super.executeSQL(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean unLockDoctor(int doctorID) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updatePassword(int doctorID, int newPassword) {
		// TODO Auto-generated method stub
		String sql="update doctor set password="+newPassword+" where doctorID="+doctorID;
		try {
			super.executeSQL(sql);
			return true;
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
