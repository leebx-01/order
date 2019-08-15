package com.leebx.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	//查询所有
	public List<T> findAll();
	//根据id查
	public T findById(Serializable id);
	//分页查询
	public List<T> findByPage(DetachedCriteria detachedCriteria,Integer first, Integer pageSize);
	//查询总记录数
	public Integer findCount(DetachedCriteria detachedCriteria);
}
