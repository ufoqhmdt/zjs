package com.jung.common;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jung.exception.SkeletonSystemException;
import com.jung.exception.SkeletonException;

public abstract class HibernateEntityManagerImpl<T> implements HibernateEntityManager<T> {
	static Log logger = LogFactory.getLog(HibernateEntityManagerImpl.class);
	private HibernateTemplate template;
	private SessionFactory sessionFactory;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public HibernateEntityManagerImpl() {
	}

	public HibernateEntityManagerImpl(HibernateTemplate template) {
		this.template = template;
	}

	public T findById(Class<T> c, long id) {
		return (T) template.get(c, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> c) throws SkeletonException {
		return (List<T>) executeSql(c.getSimpleName(), null, null);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByAttributes(Class<T> c, String[] attrNames, Object[] values) throws SkeletonException {
		return (List<T>) executeSql(c.getSimpleName(), attrNames, values);
	}

	private List<?> executeSql(String tableName, String[] attrNames, Object[] values) throws SkeletonException {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("SELECT t FROM ").append(tableName).append(" as t WHERE ");

		return template.findByNamedParam(strBuffer.toString(), attrNames, values);
	}

	public void save(Object o) throws SkeletonSystemException {
		try {
			template.save(o);
		} catch (Throwable e) {
			throw new SkeletonSystemException(e);
		}
	}

	public void update(Object o) throws SkeletonSystemException {
		try {
			template.update(o);
		} catch (Throwable e) {
			throw new SkeletonSystemException(e);
		}
	}

	public void saveOrUpdate(Object o) throws SkeletonSystemException {
		try {
			template.saveOrUpdate(o);
		} catch (Throwable e) {
			throw new SkeletonSystemException(e);
		}
	}

	public void remove(Object o) throws SkeletonSystemException {
		try {
			template.delete(o);
		} catch (Throwable e) {
			throw new SkeletonSystemException(e);
		}
	}

	public void deleteObjectById(String id) throws SkeletonSystemException {
		try {
			sessionFactory.getCurrentSession().delete(loadObject(id));
		} catch (Throwable e) {
			throw new SkeletonSystemException(e);
		}
	}

	public abstract Class<T> getEntityType();

	protected Object loadObject(Serializable id) {
		logger.debug("load " + getEntityType() + " instance with id: " + id);
		Object instance = sessionFactory.getCurrentSession().load(getEntityType(), id);
		logger.debug("load successful");
		return instance;
	}

	public List<Object[]> executeHql(String queryString) throws SkeletonException {
		return template.find(queryString);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findByNamedQuery(String queryString) throws SkeletonException {
		return template.findByNamedQuery(queryString);
	}

	public Long getSize(String ObjectName) {
		String hql = "select count(*) from " + ObjectName ;
		return (Long) template.find(hql).get(0);
	}
   
	public Long getSizeBySignature(String ObjectName,String userSignature) {
		String hql = "select count(*) from " + ObjectName +" where userSignature like '%"+userSignature+"%'" ;
		return (Long) template.find(hql).get(0);
	}
	
	public List<Object[]> executeSQL(String sqlString) throws SkeletonException {
		return (List<Object[]>) template.getSessionFactory().getCurrentSession().createSQLQuery(sqlString).list();
	}
	public void executeSQLUpdate(String sql)throws SkeletonException {
		template.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
	public Long getSpecNews(String ObjectName,int type,String language){
		String hql = "select count(*) from " + ObjectName +" where type ="+type +" and language = '"+language+"'" ;
		return (Long) template.find(hql).get(0);
	}
}
