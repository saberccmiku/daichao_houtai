package com.daichao.loans.statistics.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.statistics.entity.StatisticsProduct;

/**
 * 产品统计
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface StatisticsProductDao extends BaseMapper<StatisticsProduct> {
	
}
