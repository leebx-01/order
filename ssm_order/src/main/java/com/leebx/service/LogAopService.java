package com.leebx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leebx.entity.SysLog;
import com.leebx.mapper.LogAopMapper;
@Service("logAopService")
public class LogAopService implements ILogAopService {

	@Autowired
	private LogAopMapper logAopMapper;
	//ÃÌº”
	public void addLog(SysLog syLog) {
		// TODO Auto-generated method stub
		logAopMapper.addLog(syLog);
	}
	//≤È—Ø
	public List<SysLog> findAll() {
		// TODO Auto-generated method stub
		return logAopMapper.findAll();
	}

}
