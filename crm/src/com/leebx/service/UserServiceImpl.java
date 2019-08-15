package com.leebx.service;

import java.util.List;

import com.leebx.dao.UserDao;
import com.leebx.entity.SysUser;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public SysUser login(SysUser s) {
		// TODO Auto-generated method stub
		return userDao.login(s);
	}

	@Override
	public Integer regist(SysUser s) {
		// TODO Auto-generated method stub
		userDao.regist(s);
		return 1;
	}

	@Override
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
