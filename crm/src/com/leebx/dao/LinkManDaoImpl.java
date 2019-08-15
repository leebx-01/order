package com.leebx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.leebx.entity.CstCustomer;
import com.leebx.entity.CstLinkman;

public class LinkManDaoImpl extends BaseDaoImpl<CstLinkman> implements LinkManDao {

	public LinkManDaoImpl() {
		super(CstLinkman.class);
		// TODO Auto-generated constructor stub
	}

}
