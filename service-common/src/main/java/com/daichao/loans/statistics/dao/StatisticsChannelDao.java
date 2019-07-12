package com.daichao.loans.statistics.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.statistics.entity.StatisticsChannel;

/**
 * 渠道统计表
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface StatisticsChannelDao extends BaseMapper<StatisticsChannel> {
	
}
