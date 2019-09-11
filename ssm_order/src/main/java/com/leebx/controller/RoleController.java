package com.leebx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.Permission;
import com.leebx.entity.Role;
import com.leebx.entity.User;
import com.leebx.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/findAll.do")
	public String findAll(ModelMap mode, int page, int size) {
		List<Role> list = roleService.findAll(page, size);
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		mode.put("pageInfo", pageInfo);
		return "role-list";
	}

	@RequestMapping("/save.do")
	public String save(Role role) {
		roleService.save(role);
		return "redirect:findAll.do?page=1&size=3";
	}

	// 添加权限的时候先查出没有的权限
	@RequestMapping("/findRoleByIdAndAllPermission.do")
	public String findRoleByIdAndAllPermission(String id, ModelMap model) {
		Role role = roleService.findById(id);
		List<Permission> permission = roleService.findOtherPermission(id);
		model.put("role", role);
		model.put("permissionList", permission);
		return "role-premission-add";
	}

	// 添加权限
	@RequestMapping("/addPermissionToRole.do")
	public String addPermissionToRole(String roleId, String[] ids) {
		roleService.addPermissionToRole(roleId, ids);
		return "redirect:findAll.do?page=1&size=3";
	}
	
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap model) {
		Role role = roleService.findById(id);
		model.put("role",role);
		return "role-show";
	}
}
