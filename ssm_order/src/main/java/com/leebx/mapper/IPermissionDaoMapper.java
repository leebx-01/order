package com.leebx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.leebx.entity.Permission;

public interface IPermissionDaoMapper {
	@Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
	public List<Permission> findByRoleId(String roleId);

	@Select("select * from permission")
	public List<Permission> findAll();

	@Insert("insert into permission values(#{id},#{permissionName},#{url})")
	public void save(Permission permission);

	@Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
	public List<Permission> findOtherPermission(String id);

	@Insert("insert into role_permission values(#{permissionId},#{roleId})")
	public void addPermissionToRole(@Param("permissionId") String ids,@Param("roleId") String roleId);

	@Select("SELECT * FROM permission WHERE id IN(SELECT permissionId FROM role_permission WHERE roleId=#{roleId})")
	public List<Permission> findPermissionByRoleId(String roleId);
}
