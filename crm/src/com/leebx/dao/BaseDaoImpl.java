package com.leebx.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	public BaseDaoImpl(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) super.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria,
			Integer first, Integer pageSize) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(null);//去掉缓存，默认查所有
		return super.getHibernateTemplate().findByCriteria(detachedCriteria, first, pageSize);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = super.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			String i = list.get(0)+"";
			Integer j = Integer.parseInt(i);
			return j;
		}else{
			return null;
		}
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) super.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

}
