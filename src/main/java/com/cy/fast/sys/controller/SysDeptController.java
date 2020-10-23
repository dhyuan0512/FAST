package com.cy.fast.sys.controller;

import com.cy.fast.common.vo.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.fast.common.vo.JsonResult;
import com.cy.fast.sys.entity.SysDept;
import com.cy.fast.sys.service.SysDeptService;

import java.util.List;

@RestController
@RequestMapping("/dept/")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        return new JsonResult(sysDeptService.findObjects());
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysDeptService.deleteObject(id);
        return new JsonResult("删除成功!");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysDept entity) {
        sysDeptService.saveObject(entity);
        return new JsonResult("保存成功!");
    }

    @RequestMapping("doDeptEditUI")
    public String doDeptEditUI() {
        return "sys/dept_edit";
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysDept entity) {
        sysDeptService.updateObject(entity);
        return new JsonResult("修改成功!");
    }

    @RequestMapping("doFindZtreeDeptNodes")
    public JsonResult doFindZtreeDeptNodes() {
        List<Node> ztreeDeptNodes = sysDeptService.findZtreeDeptNodes();
        return new JsonResult(ztreeDeptNodes);
    }
}
