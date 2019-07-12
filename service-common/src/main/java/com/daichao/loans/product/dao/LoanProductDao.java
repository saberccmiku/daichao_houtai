package com.daichao.loans.product.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.product.entity.LoanProduct;

/**
 * 产品信息
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface LoanProductDao extends BaseMapper<LoanProduct> {
	
}
