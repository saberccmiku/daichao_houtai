package com.daichao.loans.cust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.loans.cust.dao.CustLoginLogDao;
import com.daichao.loans.cust.entity.CustLoginLog;
import com.daichao.loans.cust.service.CustLoginLogService;

@Service("custLoginLogService")
public class CustLoginLogServiceImpl implements CustLoginLogService{
	
	@Autowired
	private CustLoginLogDao custLoginLogDao;

	@Override
	public int saveLoginLog(CustLoginLog entity) {
		return custLoginLogDao.save(entity);
	}

}
