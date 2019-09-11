package com.leebx.service;

import java.util.List;

import com.leebx.entity.Permission;
import com.leebx.entity.Role;

public interface IRoleService {
	public List<Role> findAll(int page,int size);

	public void save(Role role);

	public Role findById(String id);

	public List<Permission> findOtherPermission(String id);

	public void addPermissionToRole(String roleId, String[] ids);
}
