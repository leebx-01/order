package com.leebx.service;

import java.util.List;

import com.leebx.entity.Permission;

public interface IPermissionService {
	public List<Permission> findAll(int page,int size);

	public void save(Permission permission);
}
