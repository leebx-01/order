package com.leebx.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.leebx.entity.Role;
import com.leebx.entity.User;

public interface IUserService extends UserDetailsService {
	public List<User> findAll(Integer page,Integer size);
	
	public void save(User user);

	public User findById(String id);

	public void addRoleToUser(String userId, String[] ids);

	public List<Role> findOtherRoles(String id);
}
