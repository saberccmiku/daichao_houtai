/**
 *Copyright 2014-2017   All rights reserved.
 */
package com.daichao.loans.app.service;

import org.springframework.stereotype.Service;

import com.daichao.loans.app.option.UpgradeOP;
import com.daichao.loans.app.vo.AppUpgradeVO;

/**
 * App版本升级Service
 * @author likang
 * @version 2017-06-18
 */
@Service
//@Transactional(readOnly = true)
public interface AppUpgradeService {

	/**
	 * 获取最新版本信息
	 * @return AppVersion
	 */
	AppUpgradeVO getNewVersion(UpgradeOP vo);
	
	/**
	 * 是否是最新版本
	 * @return true/false
	 */
	boolean isNewVersion(UpgradeOP vo);
	
}