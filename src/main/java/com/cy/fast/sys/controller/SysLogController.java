package com.cy.fast.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.fast.common.vo.JsonResult;
import com.cy.fast.common.vo.PageObject;
import com.cy.fast.sys.entity.SysLog;
import com.cy.fast.sys.service.SysLogService;


@RequestMapping("/log/")
@RestController
public class SysLogController {
    @Autowired // 依赖于service
    private SysLogService sysLogService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        PageObject<SysLog> pageObject = sysLogService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteObjects(Integer... ids) {
        sysLogService.deleteObjects(ids);
        return new JsonResult("删除成功!");
    }
}
