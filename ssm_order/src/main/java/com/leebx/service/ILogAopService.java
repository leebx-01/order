package com.leebx.service;

import java.util.List;

import com.leebx.entity.SysLog;

public interface ILogAopService {
	public void addLog(SysLog syLog) ;
	//��ѯ
	public List<SysLog> findAll();
}
