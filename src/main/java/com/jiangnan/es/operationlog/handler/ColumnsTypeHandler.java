/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jiangnan.es.operationlog.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.jiangnan.es.operationlog.entity.Column;
import com.jiangnan.es.util.CollectionUtils;
import com.jiangnan.es.util.JsonUtils;
import com.jiangnan.es.util.StringUtils;

/**
 * @description 操作日志动态列转换器
 * @author ywu@wuxicloud.com
 * 2016年2月16日 下午5:11:58
 */
public class ColumnsTypeHandler implements TypeHandler<List<Column>> {

	public void setParameter(PreparedStatement ps, int i,
			List<Column> parameter, JdbcType jdbcType) throws SQLException {
		if (!CollectionUtils.isEmpty(parameter)) {
			ps.setString(i, JsonUtils.object2JsonString(parameter));
		} else {
			ps.setNull(i, Types.VARCHAR);
		}
	}

	public List<Column> getResult(ResultSet rs, String columnName)
			throws SQLException {
		String value = rs.getString(columnName);
		if (StringUtils.hasText(value)) {
			return JsonUtils.jsonString2List(value, Column.class);
		}
		return null;
	}

	public List<Column> getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String value = rs.getString(columnIndex);
		if (StringUtils.hasText(value)) {
			return JsonUtils.jsonString2List(value, Column.class);
		}
		return null;
	}

	public List<Column> getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String value = cs.getString(columnIndex);
		if (StringUtils.hasText(value)) {
			return JsonUtils.jsonString2List(value, Column.class);
		}
		return null;
	}

}
