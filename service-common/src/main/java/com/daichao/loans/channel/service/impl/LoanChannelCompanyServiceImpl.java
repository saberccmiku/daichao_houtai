package com.daichao.loans.channel.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.loans.channel.dao.LoanChannelCompanyDao;
import com.daichao.loans.channel.entity.LoanChannelCompany;
import com.daichao.loans.channel.service.LoanChannelCompanyService;

/**
 * 渠道公司
 * @author zcl<yczclcn@163.com>
 */
@Service("loanChannelCompanyService")
public class LoanChannelCompanyServiceImpl implements LoanChannelCompanyService {

	@Autowired
	private LoanChannelCompanyDao loanChannelCompanyDao;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<LoanChannelCompany> listLoanChannelCompany(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LoanChannelCompany> page = new Page<>(query);
		loanChannelCompanyDao.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param loanChannelCompany
     * @return
     */
	@Override
	public int saveLoanChannelCompany(LoanChannelCompany loanChannelCompany) {
		return loanChannelCompanyDao.save(loanChannelCompany);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public LoanChannelCompany getLoanChannelCompanyById(Long id) {
		return loanChannelCompanyDao.getObjectById(id);
	}

    /**
     * 修改
     * @param loanChannelCompany
     * @return
     */
	@Override
	public int updateLoanChannelCompany(LoanChannelCompany loanChannelCompany) {
		return loanChannelCompanyDao.update(loanChannelCompany);
	}

    /**
     * 列表
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		return loanChannelCompanyDao.batchRemove(id);
	}

	@Override
	public List<LoanChannelCompany> getChannelCompanyList(Map<String, Object> params) {
		Query query = new Query(params);
		return loanChannelCompanyDao.list(query);
	}

}
