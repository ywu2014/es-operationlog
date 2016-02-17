/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jiangnan.es.common.entity.BaseEntity;
import com.jiangnan.es.util.CollectionUtils;

/**
 * @description 操作日志
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午3:12:40
 */
public class OperationLog extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1051342566754476417L;
	/**主键*/
	private Integer id;
	/**操作人*/
	private String userName;
	/**操作时间*/
	private Date operateTime = new Date();
	/**操作*/
	private String operation;
	/**模块*/
	private String module = "system";
	/**标识*/
	private String identifier;
	/**动态列*/
	private List<Column> columns;
	
	public OperationLog() {}
	
	public OperationLog(String module, String operation) {
		this(module, operation, null);
	}
	
	public OperationLog(String module, String operation, String identifier) {
		this.module = module;
		this.operation = operation;
		this.identifier = identifier;
	}

	public Integer getId() {
		return this.id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	public void addColumn(Column column) {
		if (CollectionUtils.isEmpty(this.columns)) {
			this.columns = new ArrayList<Column>();
		}
		this.columns.add(column);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
