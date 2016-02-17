/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.extension;

import java.util.List;

/**
 * @description 列说明
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午3:30:23
 */
public interface ColumnDescription {
	/**
	 * 列code说明
	 * @return
	 */
	String[] getColumnCodes();
	/**
	 * 列名称
	 * @return
	 */
	String[] getColumnNames();
	/**
	 * 列值
	 * @return
	 */
	List<Object> getValues();
	/**
	 * 添加列值
	 * @param value
	 */
	ColumnDescription addValue(Object value);
}
