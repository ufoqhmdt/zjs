package com.jung.doctor.dao;

import java.util.List;

import com.jung.doctor.model.Doctor;
import com.jung.doctor.model.Rank;

public interface DoctorHibernateDao {
       public boolean addDoctor(Doctor doctor);
       public boolean deleteDoctor(Doctor doctor);
       public boolean deleteDoctorByID(int doctorID);
       public Doctor getDoctorById(int doctorId);
       public List<Doctor> getDoctors();
       public boolean updateDoctorPoints(int doctorID,int newPoints);//根据医师ID更新医师积分
       public int getDoctorPointsByPhone(String phone);//根据医师电话号码查询医师积分
       public   List<Rank> getDoctorRank();//获得医师积分排名
       public String activeDoctor(int doctorID,String doctorActivateOption);//激活医师，返回医师密码
       public boolean lockDoctor(int docotrID);//设置医师活动
       public boolean unLockDoctor(int doctorID);//设置医师不活动
       public boolean updatePassword(int doctorID,int newPassword);//医师修改密码
       
}
