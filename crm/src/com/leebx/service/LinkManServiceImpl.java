package com.leebx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.dao.LinkManDao;
import com.leebx.entity.CstCustomer;
import com.leebx.entity.CstLinkman;
import com.leebx.entity.PageBean;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageBean<CstLinkman> find(DetachedCriteria detachedCriteria,
			Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean<CstLinkman> pageBean = new PageBean<CstLinkman>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		Integer first = (currPage-1)*pageSize;
		List<CstLinkman> list = linkManDao.findByPage(detachedCriteria,first,pageSize);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public Integer save(CstLinkman cstLinkMan) {
		// TODO Auto-generated method stub
		linkManDao.save(cstLinkMan);
		return 1;
	}

	@Override
	public CstLinkman findById(Long lkmId) {
		// TODO Auto-generated method stub
		return linkManDao.findById(lkmId);
	}

	@Override
	public Integer delete(CstLinkman cstLinkMan) {
		// TODO Auto-generated method stub
		linkManDao.delete(cstLinkMan);
		return 1;
	}

	@Override
	public int update(CstLinkman cstLinkMan) {
		// TODO Auto-generated method stub
		linkManDao.update(cstLinkMan);
		return 1;
	}
	
}
