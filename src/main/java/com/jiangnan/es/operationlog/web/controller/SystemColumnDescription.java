/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.jiangnan.es.operationlog.extension.ColumnDescription;
import com.jiangnan.es.util.CollectionUtils;

/**
 * @description 系统模块列说说明
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午5:32:35
 */
public class SystemColumnDescription implements ColumnDescription {
	
	private String[] codes = new String[]{"ip", "broser"};
	private String[] names = new String[]{"ip", "浏览器"};
	private List<Object> values = null;

	public String[] getColumnCodes() {
		return this.codes;
	}

	public String[] getColumnNames() {
		return this.names;
	}

	public List<Object> getValues() {
		return this.values;
	}

	public ColumnDescription addValue(Object value) {
		if (CollectionUtils.isEmpty(this.values)) {
			this.values = new ArrayList<Object>(codes.length);
		}
		this.values.add(value);
		return this;
	}

}
