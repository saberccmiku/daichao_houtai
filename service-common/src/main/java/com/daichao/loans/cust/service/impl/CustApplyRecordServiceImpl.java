package com.daichao.loans.cust.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.loans.cust.entity.CustApplyRecord;
import com.daichao.loans.cust.service.CustApplyRecordService;
import com.daichao.loans.cust.dao.CustApplyRecordDao;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;

/**
 * @author yuanxianchu
 * @date 2019-06-02 20:22:15
 */
@Service("custApplyRecordService")
public class CustApplyRecordServiceImpl implements CustApplyRecordService{
	
	@Autowired
	private CustApplyRecordDao custApplyRecordDao;

	@Override
	public Page<CustApplyRecord> listCustApplyRecord(Map<String, Object> params) {
		Query form = new Query(params);
		Page<CustApplyRecord> page = new Page<>(form);
		custApplyRecordDao.listForPage(page, form);
		return page;
	}

	@Override
	public int saveCustApplyRecord(CustApplyRecord custApplyRecord) {
		return custApplyRecordDao.save(custApplyRecord);
	}

	@Override
	public CustApplyRecord getCustApplyRecordById(String id) {
		return custApplyRecordDao.getObjectById(id);
	}

	@Override
	public int updateCustApplyRecord(CustApplyRecord custApplyRecord) {
		return custApplyRecordDao.update(custApplyRecord);
	}

}
