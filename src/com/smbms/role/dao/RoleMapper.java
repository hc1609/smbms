package com.smbms.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smbms.role.pojo.Role;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/13 18:59:16
 */
public interface RoleMapper {
	public int addRole(Role role);

	public int updateRole(Role role);

	public int deleteRole(@Param("id") Integer id);

	public List<Role> selectByName(@Param("name") String RoleName, @Param("currentNo") Integer currentNo,
			@Param("page") Integer page);
}
