package com.leebx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.dao.SaleVisitDao;
import com.leebx.entity.PageBean;
import com.leebx.entity.SaleVisit;


public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao saleVisitDao;

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	@Override
	public PageBean<SaleVisit> find(DetachedCriteria detachedCriteria,
			Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		Integer totalCount = saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		Integer first = (currPage-1)*pageSize;
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria,first,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		// TODO Auto-generated method stub
		saleVisitDao.save(saleVisit);
	}
	
	
}
