package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.leebx.entity.SysLog;

public interface LogAopMapper {
	@Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
	void addLog(SysLog syLog);
	//��ѯ
	@Select("select * from syslog")
	List<SysLog> findAll();
}
