package com.leebx.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.leebx.entity.Role;
import com.leebx.entity.User;
import com.leebx.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/findAll.do")
//	@Secured("ROLE_ADMIN")
	public String findAll(ModelMap mode, Integer page, Integer size) {
		List<User> list = userService.findAll(page, size);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		mode.put("pageInfo", pageInfo);
		return "users-list";
	}

	@RequestMapping("/save.do")
	public String save(User user) {
		// ����uuid
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		// ��������м��ܲ���
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		return "redirect:findAll.do?page=1&size=3";
	}
	
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap model) {
		User user = userService.findById(id);
		model.put("user",user);
		return "user-show";
	}
	//��ӽ�ɫ��ʱ���Ȳ��û�еĽ�ɫ
	@RequestMapping("/findUserByIdAndAllRole.do")
	public String findUserByIdAndAllRole(String id,ModelMap model){
		User user=userService.findById(id);
		List<Role> roles=userService.findOtherRoles(id);
		model.put("user", user);
		model.put("roleList", roles);
		return "user-role-add";
	}
	//��ӽ�ɫ
	@RequestMapping("/addRoleToUser.do")
	public String addRoleToUser(String userId,String[]ids) {
		userService.addRoleToUser(userId,ids);
		return "redirect:findAll.do?page=1&size=3";
	}
}
