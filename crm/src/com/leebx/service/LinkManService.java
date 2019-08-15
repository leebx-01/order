package com.leebx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.entity.CstCustomer;
import com.leebx.entity.CstLinkman;
import com.leebx.entity.PageBean;

public interface LinkManService {

	PageBean<CstLinkman> find(DetachedCriteria detachedCriteria,Integer currPage, Integer pageSize);

	Integer save(CstLinkman cstLinkMan);

	CstLinkman findById(Long lkmId);

	Integer delete(CstLinkman cstLinkMan);

	int update(CstLinkman cstLinkMan);
	

}
