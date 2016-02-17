/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.entity;

/**
 * @description TODO
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午4:06:58
 */
public class Column {
	private String code;
	private String name;
	private Object value;
	
	public Column(){}
	
	public Column(String code, String name, Object value) {
		this.code = code;
		this.name = name;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
