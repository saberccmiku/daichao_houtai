package com.daichao.loans.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.loans.app.dao.AppAccessLogDao;
import com.daichao.loans.app.entity.AppAccessLog;
import com.daichao.loans.app.service.AppAccessLogService;

/**
 * APP访问日志-业务逻辑实现类
 * @author likang
 * @version 2017-08-11
 */
@Service("accessLogService")
public class AppAccessLogServiceImpl implements AppAccessLogService{

	@Autowired
	private AppAccessLogDao appAccessLogDao;
	
	@Override
	public Page<AppAccessLog> listAppAccessLog(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveAppAccessLog(AppAccessLog appAccessLog) {
		return appAccessLogDao.save(appAccessLog);
	}

}
