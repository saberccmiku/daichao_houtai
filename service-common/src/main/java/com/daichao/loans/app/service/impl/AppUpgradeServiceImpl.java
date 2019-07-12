package com.daichao.loans.app.service.impl;

import com.daichao.common.config.Global;
import com.daichao.common.mapper.BeanMapper;
import com.daichao.common.utils.JedisUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.app.dao.AppUpgradeDao;
import com.daichao.loans.app.entity.AppUpgrade;
import com.daichao.loans.app.option.UpgradeOP;
import com.daichao.loans.app.service.AppUpgradeService;
import com.daichao.loans.app.vo.AppUpgradeVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * App版本升级Service实现
 * @author likang
 * @version 2017-06-20
 */
@Service("appUpgradeService")
public class AppUpgradeServiceImpl implements AppUpgradeService {
	
	/**
	 * 日志对象
	 */
	public Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppUpgradeDao appUpgradeDao;
	
	public AppUpgradeVO getNewVersion(UpgradeOP vo) {
		// 参数判断
		if(null == vo || StringUtils.isBlank(vo.getAppVerson()) 
				|| null == vo.getType()) {
			logger.info("AppUpgradeService.getNewVersion： 参数不合法");
			return null;
		}
		// 获取最新版本
//		AppUpgrade newVersion = appUpgradeDao.getNewVersion(vo.getType(), vo.getAppId());
		
		
		String cacheKey = "APP_UPGRADE_NEW_VERSION_" + vo.getType();
		AppUpgrade appUpgrade = (AppUpgrade) JedisUtils.getObject(cacheKey);
		if (appUpgrade == null) {
			appUpgrade = appUpgradeDao.getNewVersion(vo.getType(), vo.getAppId());
			JedisUtils.setObject(cacheKey, appUpgrade, Global.ONE_DAY_CACHESECONDS);
		}
		
		if (appUpgrade == null){
			logger.info("AppUpgradeService.getNewVersion： 数据异常");
			return null;
		}
		// 判断是否为最新版本   
		AppUpgradeVO result = BeanMapper.map(appUpgrade, AppUpgradeVO.class);
		result.setNewVersionToReq(StringUtils.equals(appUpgrade.getVersion(), vo.getAppVerson()));
		return result;

	}

	public boolean isNewVersion(UpgradeOP vo) {
		// 参数判断
		if(null == vo || StringUtils.isBlank(vo.getAppVerson()) 
				|| null == vo.getType()) {
			logger.info("AppUpgradeService.isNewVersion： 参数不合法");
			return false;
		} else {
			// 统计当前版本是最新版本的记录条数
			int rz = appUpgradeDao.isNewVersion(vo);
			return rz == 1;
		}
	}
	
}