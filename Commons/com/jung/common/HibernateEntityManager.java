package com.jung.common;

import java.util.List;

import com.jung.exception.SkeletonSystemException;
import com.jung.exception.SkeletonException;

public interface HibernateEntityManager<T> {

	public T findById(Class<T> c, long idValue);

	public List<T> findAll(Class<T> c) throws SkeletonException;

	public List<T> findByAttributes(Class<T> c, String[] attrNames, Object[] values) throws SkeletonException;

	public void save(T o) throws SkeletonSystemException;

	public void update(T o) throws SkeletonSystemException;

	public void saveOrUpdate(T o) throws SkeletonSystemException;

	public void remove(T o) throws SkeletonSystemException;

	public void deleteObjectById(String id) throws SkeletonSystemException;

	public List<Object[]> executeHql(String queryString) throws SkeletonException;

	public List<Object[]> executeSQL(String sqlString) throws SkeletonException;
	
	public void executeSQLUpdate(String sqlString) throws SkeletonException;
}
