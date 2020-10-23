package com.cy.fast.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.fast.common.vo.Node;
import com.cy.fast.sys.entity.SysDept;

public interface SysDeptService {

    int updateObject(SysDept entity);

    int saveObject(SysDept entity);

    int deleteObject(Integer id);

    List<Node> findZtreeDeptNodes();

    List<Map<String, Object>> findObjects();
}

