package com.leebx.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.leebx.entity.BaseDict;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Override
	public List<BaseDict> findByInfo(String dictTypeCode) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().find("from BaseDict b where b.dictTypeCode=?",dictTypeCode);
	}

}
