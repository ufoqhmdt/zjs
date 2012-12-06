package com.jung.doctor.dao.impl;

import java.util.List;

import com.hp.util.Page;
import com.hp.util.dao.hibernate.HibernateBaseDao;
import com.hp.xquery.SimpleQuery;
import com.jung.doctor.dao.DoctorDao;
import com.jung.doctor.model.Doctor;
import com.jung.news.model.News;

public class DoctorDaoImpl extends HibernateBaseDao implements DoctorDao {

	@Override
	public Class getEntityType() {
		return Doctor.class;
	}
}
