package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.leebx.entity.Role;

public interface IRoleDaoMapper {
	
	@Select("SELECT * FROM role WHERE id IN(SELECT roleId FROM users_role WHERE userId=#{userid})")
	@Results({
		@Result(id=true,column="id",property="id"), 
		@Result(column="roleName",property="roleName"), 
		@Result(column="roleDesc",property="roleDesc"), 
		@Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.leebx.mapper.IPermissionDaoMapper.findByRoleId")) 
	})
	public List<Role> findRoleByUserId(String userid);
	
	@Select("select * from role")
	public List<Role> findAll();
	
	@Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
	public void save(Role role);

	@Select("SELECT * FROM role WHERE id not IN(SELECT roleId FROM users_role WHERE userId=#{id})")
	public List<Role> findOtherRoles(String id);
	
	@Insert("insert into users_role values(#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId") String userId,@Param("roleId")String ids);

	@Select("select * from role where id=#{id}")
	@Results({ 
		@Result(id=true,column="id",property="id"), 
		@Result(column="roleName",property="roleName"), 
		@Result(column="roleDesc",property="roleDesc"), 
		@Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.leebx.mapper.IPermissionDaoMapper.findPermissionByRoleId") ) })
	public Role findById(String id);

	
}
