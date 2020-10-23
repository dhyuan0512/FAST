package com.cy.fast.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserRoleDao {

    int deleteObjectsByUserId(Integer userId);

    List<Integer> findRoleIdsByUserId(Integer id);

    /**
     * 负责将用户与角色的关系数据写入到数据库
     *
     * @param userId  用户id
     * @param roleIds 多个角色id
     * @return
     */
    int insertObjects(
            @Param("userId") Integer userId,
            @Param("roleIds") Integer[] roleIds);
}
