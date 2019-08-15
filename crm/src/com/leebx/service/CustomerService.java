package com.leebx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.entity.CstCustomer;
import com.leebx.entity.CstLinkman;
import com.leebx.entity.PageBean;

public interface CustomerService {

	int save(CstCustomer cstCustomer);

	PageBean<CstCustomer> find(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize);

	int delete(CstCustomer customer);

	CstCustomer findById(Long custId);

	int update(CstCustomer customer);
	
	List<CstCustomer> findAll();

}
