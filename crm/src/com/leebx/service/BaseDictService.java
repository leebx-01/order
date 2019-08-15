package com.leebx.service;

import java.util.List;

import com.leebx.entity.BaseDict;

public interface BaseDictService {

	public List<BaseDict> findByInfo(String dictTypeCode); 
}
