package com.daichao.loans.cust.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.cust.entity.CustApplyRecord;

/**
 * 申请记录
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface CustApplyRecordDao extends BaseMapper<CustApplyRecord> {
	
}
