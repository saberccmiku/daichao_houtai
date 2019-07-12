package com.daichao.loans.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.daichao.common.config.Global;
import com.daichao.common.utils.JedisUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.product.dao.LoanProductCategoryDao;
import com.daichao.loans.product.service.ProductCategoryService;
import com.daichao.loans.product.vo.ProductCategoryVO;
/**
 * 产品分类表-业务逻辑实现类
 * @author zcb
 * @version 2019-05-31
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements  ProductCategoryService{
	
	/**
 	* 产品分类表-实体管理接口
 	*/
	@Autowired
	private LoanProductCategoryDao loanProductCategoryDao;

	@Override
	public List<ProductCategoryVO> getCategoryByAppId(String appId) {
		if(StringUtils.isBlank(appId)) {
			return null;
		}
		String cacheKey = Global.PRODUCT_CATEGORY_LIST_PREFIX + appId;
		List<ProductCategoryVO> categoryList = (List<ProductCategoryVO>) JedisUtils.getObject(cacheKey);
		if (categoryList == null) {
			categoryList = loanProductCategoryDao.getCategoryListByAppId(appId);
			JedisUtils.setObject(cacheKey, categoryList, Global.SEVEN_DAY_CACHESECONDS);
		}
		return categoryList;
	}
}