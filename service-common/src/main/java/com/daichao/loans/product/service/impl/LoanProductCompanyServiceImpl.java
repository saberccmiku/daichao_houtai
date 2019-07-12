package com.daichao.loans.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.loans.product.dao.LoanProductCompanyDao;
import com.daichao.loans.product.entity.LoanProductCompany;
import com.daichao.loans.product.service.LoanProductCompanyService;

/**
 * 放贷公司信息
 * @author zcl<yczclcn@163.com>
 */
@Service("loanProductCompanyService")
public class LoanProductCompanyServiceImpl implements LoanProductCompanyService {

	@Autowired
	private LoanProductCompanyDao loanProductCompanyDao;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<LoanProductCompany> listLoanProductCompany(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LoanProductCompany> page = new Page<>(query);
		loanProductCompanyDao.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param loanProductCompany
     * @return
     */
	@Override
	public int saveLoanProductCompany(LoanProductCompany loanProductCompany) {
		return loanProductCompanyDao.save(loanProductCompany);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public LoanProductCompany getLoanProductCompanyById(Long id) {
		return loanProductCompanyDao.getObjectById(id);
	}

    /**
     * 修改
     * @param loanProductCompany
     * @return
     */
	@Override
	public int updateLoanProductCompany(LoanProductCompany loanProductCompany) {
		return loanProductCompanyDao.update(loanProductCompany);
	}

    /**
     * 列表
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		return loanProductCompanyDao.batchRemove(id);
	}

	@Override
	public List<LoanProductCompany> getProductCompanyList(Map<String, Object> params) {
		Query query = new Query(params);
		return loanProductCompanyDao.list(query);
	}

}
