package com.leebx.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.leebx.entity.Permission;
import com.leebx.mapper.IPermissionDaoMapper;

@Service("permissionService")
public class PermissionService implements IPermissionService {
	@Autowired
	private IPermissionDaoMapper permissionMapper;

	public List<Permission> findAll(int page, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return permissionMapper.findAll();
	}

	public void save(Permission permission) {
		// TODO Auto-generated method stub
		permission.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		permissionMapper.save(permission);
	}

}
