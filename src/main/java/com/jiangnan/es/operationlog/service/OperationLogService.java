/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.service;

import com.jiangnan.es.operationlog.entity.OperationLog;
import com.jiangnan.es.operationlog.extension.ColumnDescription;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseService;

/**
 * @description 业务层接口
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午3:35:09
 */
public interface OperationLogService extends MybatisBaseService<OperationLog> {
	/**
	 * 添加
	 * @param entity
	 * @param columnDescription
	 * @return
	 */
	public OperationLog save(OperationLog entity, ColumnDescription columnDescription);
}
