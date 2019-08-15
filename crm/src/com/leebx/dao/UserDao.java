package com.leebx.dao;

import com.leebx.entity.SysUser;

public interface UserDao extends BaseDao<SysUser>{
	public SysUser login(SysUser s);
	public void regist(SysUser s);
}
