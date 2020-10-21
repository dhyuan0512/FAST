package com.cy.fast.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cy.fast.common.vo.Node;
import com.cy.fast.sys.entity.SysDept;

@Mapper
public interface SysDeptDao {	
	//定义修改方法,数据从SysDept下的 定义的
	int updateObject(SysDept entity);
	
	int insertObject(SysDept entity);
	
	List<Node> findZtreeDeptNodes();
	
	 /**
	  * 根据部门id统计子部门的个数
	  * @param id
	  * @return
	  */
	
	 int getChildCount(Integer id);
	 
	 /**
	  * 根据id 删除部门
	  * @param id
	  * @return
	  */
	 
	 int deleteObject(Integer id);
	 
	List<Map<String, Object>>findObjects();
}


