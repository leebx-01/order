package com.leebx.service;

import java.util.List;

import com.leebx.dao.BaseDictDao;
import com.leebx.entity.BaseDict;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao baseDictDao;
	
	
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}


	@Override
	public List<BaseDict> findByInfo(String dictTypeCode) {
		// TODO Auto-generated method stub
		
		return this.baseDictDao.findByInfo(dictTypeCode);
	}

}
