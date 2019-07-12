package com.daichao.loans.product.service;

import java.util.List;

import com.daichao.loans.product.vo.ProductCategoryVO;


/**
 * 产品分类表-业务逻辑接口
 * @author zcb
 * @version 2019-05-31
 */
public interface ProductCategoryService {
	
	List<ProductCategoryVO> getCategoryByAppId(String appId);

}