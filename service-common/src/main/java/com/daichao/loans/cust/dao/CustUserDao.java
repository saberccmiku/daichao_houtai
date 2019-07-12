package com.daichao.loans.cust.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.cust.entity.CustUser;
import com.daichao.loans.cust.option.UpdatePwdOP;

/**
 * 客户信息
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface CustUserDao extends BaseMapper<CustUser> {
	
	int updatePwd(UpdatePwdOP updatePwdOP);
}
