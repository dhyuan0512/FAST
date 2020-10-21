package com.cy.fast.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.fast.sys.entity.SysUser;

@Mapper
public interface FastUserDao {
	
	int insertObject(SysUser entity);
	
	@Select("select * from sys_users where username = #{username}")
	SysUser findUserByUserName(String username);
	
	@Select("select username from sys_users where username=#{name}")
	String findNameByName(String name);
}
