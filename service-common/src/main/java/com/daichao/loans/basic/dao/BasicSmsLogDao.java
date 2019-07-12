package com.daichao.loans.basic.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.basic.entity.BasicSmsLog;

/**
 * 短信发送记录
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface BasicSmsLogDao extends BaseMapper<BasicSmsLog> {
	
	int countRegBlackList(@Param("ip")String ip);
}
