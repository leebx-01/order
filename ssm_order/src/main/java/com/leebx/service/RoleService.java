package com.leebx.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.leebx.entity.Permission;
import com.leebx.entity.Role;
import com.leebx.mapper.IPermissionDaoMapper;
import com.leebx.mapper.IRoleDaoMapper;
@Service("roleService")
public class RoleService implements IRoleService {
	@Autowired
	private IRoleDaoMapper roleMapper;
	@Autowired
	private IPermissionDaoMapper permissionMapper;
	public List<Role> findAll(int page, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return roleMapper.findAll();
	}
	public void save(Role role) {
		// TODO Auto-generated method stub
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		roleMapper.save(role);
	}
	public Role findById(String id) {
		// TODO Auto-generated method stub
		return roleMapper.findById(id);
	}
	public List<Permission> findOtherPermission(String id) {
		// TODO Auto-generated method stub
		return permissionMapper.findOtherPermission(id);
	}
	public void addPermissionToRole(String roleId, String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			permissionMapper.addPermissionToRole(ids[i],roleId);
		}
	}

}
