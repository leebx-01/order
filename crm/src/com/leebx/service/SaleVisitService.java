package com.leebx.service;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.entity.PageBean;
import com.leebx.entity.SaleVisit;

public interface SaleVisitService {

	PageBean<SaleVisit> find(DetachedCriteria detachedCriteria,
			Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

}
