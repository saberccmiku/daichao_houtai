package com.daichao.loans.basic.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.basic.entity.BasicBlacklist;

/**
 * 基础黑名单（手机号、ip等）
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface BasicBlacklistDao extends BaseMapper<BasicBlacklist> {
	
	/**
	 * 根据基础黑名单值（手机号或ip）统计数据条数
	 * @param blValue
	 * @return
	 */
	int countByBlValue(@Param("blValue")String blValue);
}
