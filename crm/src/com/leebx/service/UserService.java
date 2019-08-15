package com.leebx.service;

import java.util.List;

import com.leebx.entity.SysUser;

public interface UserService {
	public SysUser login(SysUser s);
	public Integer regist(SysUser s);
	public List<SysUser> findAll();
}
