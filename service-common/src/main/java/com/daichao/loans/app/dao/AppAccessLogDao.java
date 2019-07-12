package com.daichao.loans.app.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.app.entity.AppAccessLog;

/**
 * APP访问日志
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface AppAccessLogDao extends BaseMapper<AppAccessLog> {
	
}
