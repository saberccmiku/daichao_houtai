package com.daichao.loans.product.service;

import com.daichao.loans.product.entity.LoanProduct;

import java.util.Map;

import com.daichao.common.entity.Page;

/**
 * @author yuanxianchu
 * @date 2019-06-02 20:23:18
 */
public interface LoanProductService {

    LoanProduct getLoanProduct(Integer productId);

    Page<LoanProduct> listLoanProduct(Map<String, Object> params);
    
    void delRedis(String key);

    /**
     * 新增
     * @param loanProduct
     * @return
     */
	int saveLoanProduct(LoanProduct loanProduct);
	
    /**
     * 修改
     * @param loanProduct
     * @return
     */
	int updateLoanProduct(LoanProduct loanProduct);
	
	int batchRemove(Long[] id);
}
