package com.cy.fast.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.fast.sys.entity.SysUser;
import com.cy.fast.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	
	
	SysUser findUserByUserName(String username);
	/**
	 * 基于用户id修改用户的密码
	 * @param password 新的密码
	 * @param salt 密码加密时使用的盐值
	 * @param id 用户id
	 * @return
	 */
	int updatePassword(
			@Param("password")String password,
			@Param("salt")String salt,
			@Param("id")Integer id);

	
	int updateObject(SysUser entity);
	
	SysUserDeptVo findObjectById(Integer userId);
	
	/**
	 * 负责将用户信息写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);


	
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);

	
	List<SysUserDeptVo> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	int getRowCount(@Param("username") String username);

	int deleteObjectsByRoleId(Integer roleId);
	
	int getUserCountByDeptId (Integer DeptId);
}
