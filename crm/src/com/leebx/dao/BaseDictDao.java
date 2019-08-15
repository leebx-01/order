package com.leebx.dao;

import java.util.List;

import com.leebx.entity.BaseDict;

public interface BaseDictDao {

	public List<BaseDict> findByInfo(String dictTypeCode);
}
