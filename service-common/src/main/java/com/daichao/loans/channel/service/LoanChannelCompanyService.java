package com.daichao.loans.channel.service;

import java.util.List;
import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.channel.entity.LoanChannelCompany;

/**
 * 渠道公司
 * @author zcl<yczclcn@163.com>
 */
public interface LoanChannelCompanyService {

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<LoanChannelCompany> listLoanChannelCompany(Map<String, Object> params);

    /**
     * 新增
     * @param loanChannelCompany
     * @return
     */
	int saveLoanChannelCompany(LoanChannelCompany loanChannelCompany);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	LoanChannelCompany getLoanChannelCompanyById(Long id);

    /**
     * 修改
     * @param loanChannelCompany
     * @return
     */
	int updateLoanChannelCompany(LoanChannelCompany loanChannelCompany);

    /**
     * 列表
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
	List<LoanChannelCompany> getChannelCompanyList(Map<String, Object> params);

}
