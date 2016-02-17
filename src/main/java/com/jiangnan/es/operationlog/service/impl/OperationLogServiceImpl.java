/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiangnan.es.common.repository.BaseRepository;
import com.jiangnan.es.operationlog.dao.OperationLogDao;
import com.jiangnan.es.operationlog.entity.Column;
import com.jiangnan.es.operationlog.entity.OperationLog;
import com.jiangnan.es.operationlog.extension.ColumnDescription;
import com.jiangnan.es.operationlog.service.OperationLogService;
import com.jiangnan.es.orm.mybatis.service.MybatisBaseServiceSupport;
import com.jiangnan.es.util.CollectionUtils;

/**
 * @description 业务层实现类
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午3:40:18
 */
@Service
public class OperationLogServiceImpl extends MybatisBaseServiceSupport<OperationLog>
		implements OperationLogService {
	
	@Resource
	OperationLogDao operationLogDao;

	@Override
	protected BaseRepository<OperationLog> getRepository() {
		return operationLogDao;
	}
	
	public OperationLog save(OperationLog entity, ColumnDescription columnDescription) {
		//处理动态列
		processAdditionalColumns(entity, columnDescription);
		//TODO 从线程上下文中获取登录用户信息,设置操作人
		return super.save(entity);
	}
	
	/**
	 * 处理动态列
	 * @param entity
	 * @param columnDescription
	 */
	private void processAdditionalColumns(OperationLog entity, ColumnDescription columnDescription) {
		if (null != columnDescription) {
			String[] codes = columnDescription.getColumnCodes();
			String[] names = columnDescription.getColumnNames();
			List<Object> values = columnDescription.getValues();
			if (!CollectionUtils.isEmpty(codes) && !CollectionUtils.isEmpty(names)
					&& !CollectionUtils.isEmpty(values)) {
				if (codes.length == names.length && codes.length == values.size()) {
					for (int i = 0; i < codes.length; i++) {
						entity.addColumn(new Column(codes[i], names[i], values.get(i)));
					}
				}
			}
		}
	}
	
}
