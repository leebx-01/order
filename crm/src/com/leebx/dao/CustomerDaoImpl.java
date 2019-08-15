package com.leebx.dao;


import com.leebx.entity.CstCustomer;

public class CustomerDaoImpl extends BaseDaoImpl<CstCustomer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(CstCustomer.class);
	}

}
