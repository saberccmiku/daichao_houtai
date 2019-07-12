package com.daichao.loans.channel.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.channel.entity.LoanChannelCompany;

/**
 * 渠道公司
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface LoanChannelCompanyDao extends BaseMapper<LoanChannelCompany> {
	
}
