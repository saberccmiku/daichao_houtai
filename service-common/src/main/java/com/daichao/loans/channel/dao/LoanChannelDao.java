package com.daichao.loans.channel.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.channel.entity.LoanChannel;

/**
 * 渠道信息
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface LoanChannelDao extends BaseMapper<LoanChannel> {
	
}
