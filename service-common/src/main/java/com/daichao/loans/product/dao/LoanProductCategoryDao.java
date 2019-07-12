package com.daichao.loans.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.product.entity.LoanProductCategory;
import com.daichao.loans.product.vo.ProductCategoryVO;

/**
 * 产品分类表
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface LoanProductCategoryDao extends BaseMapper<LoanProductCategory> {
	
	List<ProductCategoryVO> getCategoryListByAppId(@Param("appId") String appId);
}
