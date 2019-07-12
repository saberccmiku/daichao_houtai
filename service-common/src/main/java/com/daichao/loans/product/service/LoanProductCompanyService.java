package com.daichao.loans.product.service;

import java.util.List;
import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.channel.entity.LoanChannel;
import com.daichao.loans.product.entity.LoanProductCompany;

/**
 * 放贷公司信息
 * @author zcl<yczclcn@163.com>
 */
public interface LoanProductCompanyService {

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<LoanProductCompany> listLoanProductCompany(Map<String, Object> params);

    /**
     * 新增
     * @param loanProductCompany
     * @return
     */
	int saveLoanProductCompany(LoanProductCompany loanProductCompany);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	LoanProductCompany getLoanProductCompanyById(Long id);

    /**
     * 修改
     * @param loanProductCompany
     * @return
     */
	int updateLoanProductCompany(LoanProductCompany loanProductCompany);

    /**
     * 列表
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
	List<LoanProductCompany> getProductCompanyList(Map<String, Object> params);
	
}
