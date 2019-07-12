package com.daichao.loans.product.service.impl;

import com.daichao.common.config.Global;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.common.utils.JedisUtils;
import com.daichao.loans.product.dao.LoanProductDao;
import com.daichao.loans.product.entity.LoanProduct;
import com.daichao.loans.product.service.LoanProductService;

import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanxianchu
 * @date 2019-06-02 20:28:41
 */
@Service("loanProductService")
public class LoanProductServiceImpl implements LoanProductService {
	
	@Autowired
	private LoanProductDao loanProductDao;

    @Override
    public LoanProduct getLoanProduct(Integer productId) {
        String cacheKey = productId + Global.LOAN_PRO_SUFFIX;
        LoanProduct loanProduct = (LoanProduct)JedisUtils.getObject(cacheKey);
        if (loanProduct == null){
            loanProduct = loanProductDao.getObjectById(productId);
            loanProduct.setApplyNum(RandomUtils.nextInt(1000, 9999));
            // 结果保存到缓存
            JedisUtils.setObject(cacheKey, loanProduct, Global.THREE_DAY_CACHESECONDS);
        }
        return loanProduct;
    }
    
//    @Override
//  	public List<LoanProduct> selectList(LoanProduct entity) {
//  		MyExample example = new MyExample(LoanProduct.class);
//  		Criteria criteria =  example.createCriteria();
//  		
//  		if(null != entity.getAppId()){
//  			criteria.andEqualTo("appId",entity.getAppId());
//  		}
//  		if(null != entity.getCategoryId()){
//  			criteria.andEqualTo("categoryId",entity.getCategoryId());
//  		}
//  		if(null != entity.getLabel()){
//  			criteria.andEqualTo("label",entity.getLabel());
//  		}
//  		if(null != entity.getSource()){
//  			criteria.andEqualTo("source",entity.getSource());
//  		}
//  		if(StringUtils.isNotBlank(entity.getProductName())){
//			criteria.andEqualTo("productName",entity.getProductName());
//		}
//  		if(null != entity.getStatus()){
//			criteria.andEqualTo("status", entity.getStatus());
//		}
//  		criteria.andEqualTo("del", 0);
//  		
//  		String dateRange = entity.getDateRange();
//        if (StringUtils.isNotBlank(dateRange)) {
//           String[] dates = dateRange.split(" - ");
//           criteria.andGreaterThanOrEqualTo("createTime",dates[0]);
//           criteria.andLessThanOrEqualTo("createTime",dates[1]+" 23:59:59");
//        }
//        example.setPageNumber(entity.getPageNumber());
//        example.setPageSize(entity.getPageSize()); 
//        example.setOrderByClause("status, scort asc");
//  		return selectByExample(example);
//  	}

    
    @Override
	public Page<LoanProduct> listLoanProduct(Map<String, Object> params) {
		Query form = new Query(params);
		Page<LoanProduct> page = new Page<>(form);
		loanProductDao.listForPage(page, form);
		return page;
	}
    
	@Override
	public void delRedis(String key) {
		JedisUtils.del(key);
		JedisUtils.batchDel(key, 3);
	}

	@Override
	public int saveLoanProduct(LoanProduct loanProduct) {
		return loanProductDao.save(loanProduct);
	}
	
    /**
     * 修改
     * @param loanProduct
     * @return
     */
	@Override
	public int updateLoanProduct(LoanProduct loanProduct) {
		return loanProductDao.update(loanProduct);
	}

	@Override
	public int batchRemove(Long[] id) {
		return loanProductDao.batchRemove(id);
	}

	
}
