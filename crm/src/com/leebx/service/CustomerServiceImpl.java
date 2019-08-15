package com.leebx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leebx.dao.CustomerDao;
import com.leebx.entity.CstCustomer;
import com.leebx.entity.CstLinkman;
import com.leebx.entity.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public int save(CstCustomer cstCustomer) {
		// TODO Auto-generated method stub
		customerDao.save(cstCustomer);
		return 1;
	}

	@Override
	public PageBean<CstCustomer> find(DetachedCriteria detachedCriteria,
			Integer currPage,Integer pageSize) {
		PageBean<CstCustomer> pageBean = new PageBean<CstCustomer>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		// 总记录数
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 总页数
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		// 封装数据集合
		Integer first = (currPage-1)*pageSize;
		List<CstCustomer> list = customerDao.findByPage(detachedCriteria,first,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int delete(CstCustomer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
		return 1;
	}

	@Override
	public CstCustomer findById(Long custId) {
		// TODO Auto-generated method stub
		return customerDao.findById(custId);
	}

	@Override
	public int update(CstCustomer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
		return 1;
	}

	@Override
	public List<CstCustomer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}
	
}
