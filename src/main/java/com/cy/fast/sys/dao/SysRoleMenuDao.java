package com.cy.fast.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 此dao
 * @author Tarena
 *
 */
@Mapper
public interface SysRoleMenuDao {
	
	
	
	int insertObjects(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	
	int deleteObjectsByRoleId(Integer roleId);
	
	int deleteObjectsByMenuId(Integer menuId);
	
}
