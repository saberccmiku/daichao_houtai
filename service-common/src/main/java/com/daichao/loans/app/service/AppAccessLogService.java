package com.daichao.loans.app.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.app.entity.AppAccessLog;

/**
 * APP访问日志
 * @author zcl<yczclcn@163.com>
 */
public interface AppAccessLogService {

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<AppAccessLog> listAppAccessLog(Map<String, Object> params);

    /**
     * 新增
     * @param appAccessLog
     * @return
     */
	int saveAppAccessLog(AppAccessLog appAccessLog);
	
}
