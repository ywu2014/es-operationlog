/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiangnan.es.common.entity.query.Page;
import com.jiangnan.es.common.entity.query.PageContext;
import com.jiangnan.es.common.web.PageView;
import com.jiangnan.es.common.web.controller.BaseController;
import com.jiangnan.es.operationlog.entity.OperationLog;
import com.jiangnan.es.operationlog.extension.ColumnDescription;
import com.jiangnan.es.operationlog.service.OperationLogService;

/**
 * @description 操作日志控制器
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午5:24:01
 */
@Controller
@RequestMapping("system/manage/operationlog/")
public class OperationLogController extends BaseController {
	
	@Resource
	OperationLogService operationLogService;
	
	@RequestMapping("add")
	public void add() {
		operationLogService.save(new OperationLog("common", "add"));
	}
	
	@RequestMapping("addColumns")
	public void addWithColumns() {
		ColumnDescription description = new SystemColumnDescription();
		description.addValue("127.0.0.1").addValue("firefox");
		operationLogService.save(new OperationLog("system", "add"), description);
	}
	
	@RequestMapping("/")
	public String main(Model model, OperationLog params) {
		PageContext.setCurrentPage(1);
		PageContext.setPageSize(10);
		Page<OperationLog> operationLogs = operationLogService.list(params);
		model.addAttribute("columns", new SystemColumnDescription().getColumnNames());
		model.addAttribute("operationLogs", new PageView<OperationLog>(operationLogs));
		return "system/manage/operationlog/list";
	}
}
