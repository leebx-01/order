package com.leebx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.leebx.entity.Role;
import com.leebx.mapper.IRoleDaoMapper;
import com.leebx.mapper.IUserDaoMapper;

@Service("userService")
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDaoMapper userMapper;
	@Autowired
	private IRoleDaoMapper roleMapper;

	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		com.leebx.entity.User db_user = userMapper.getUserByName(username);
		User user = new User(db_user.getUsername(), db_user.getPassword(),db_user.getStatus()==1?true:false,true,true,true, getAuthority(db_user.getRoles())) ;
		return user;
	}

	public List<GrantedAuthority> getAuthority(List<Role> list) {
		List<GrantedAuthority> list2 = new ArrayList<GrantedAuthority>();
		for (Role role : list) {
			list2.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return list2;
	}

	public List<com.leebx.entity.User> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return userMapper.findAll();
	}

	public void save(com.leebx.entity.User user) {
		// TODO Auto-generated method stub
		userMapper.save(user);
	}

	public com.leebx.entity.User findById(String id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	
	public List<Role> findOtherRoles(String id) {
		// TODO Auto-generated method stub
		return roleMapper.findOtherRoles(id);
	}
	public void addRoleToUser(String userId, String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			roleMapper.addRoleToUser(userId,ids[i]);
		}
	}

	
}
