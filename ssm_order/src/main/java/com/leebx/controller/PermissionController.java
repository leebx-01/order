package com.leebx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.Permission;
import com.leebx.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping("/findAll.do")
	public String findAll(ModelMap mode,int page,int size) {
		List<Permission> list = permissionService.findAll(page,size);
		PageInfo<Permission> pageInfo = new PageInfo<Permission>(list);
		mode.put("pageInfo", pageInfo);
		return "permission-list";
	}
	
	@RequestMapping("/save.do")
	public String save(Permission permission) {
		permissionService.save(permission);
		return "redirect:findAll.do?page=1&size=3";
	}
}
