package com.daichao.loans.app.service.impl;

import com.daichao.common.config.Global;
import com.daichao.common.mapper.BeanMapper;
import com.daichao.common.utils.JedisUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.app.dao.AppBannerDao;
import com.daichao.loans.app.entity.AppBanner;
import com.daichao.loans.app.service.AppBannerService;
import com.daichao.loans.app.vo.AppBannerVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 移动端Banner服务类
 * @author likang
 *
 */
@Service("appBannerService")
public class AppBannerServiceImpl implements AppBannerService {
	
	/**
	 * 日志对象
	 */
	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AppBannerDao appBannerDao;


	public List<AppBannerVO> getAppBannerByType(String categoryId) {
		// 初始化返回值
		if(StringUtils.isBlank(categoryId)) {
			logger.info("AppBannerService.getAppBannerByType： 参数不合法");
			return Collections.emptyList();
		}

//		List<AppBanner> list = appBannerManager.getAppBannerByType(categoryId);
	    String APP_BANNER_LIST_CACHE_PREFIX = "APP_BANNER_LIST_";

		String cacheKey = APP_BANNER_LIST_CACHE_PREFIX + categoryId;
		List<AppBanner> list = (List<AppBanner>) JedisUtils.getObject(cacheKey);
		if (list == null) {
			list = appBannerDao.getAppBannerByType(categoryId);
			JedisUtils.setObject(cacheKey, list, Global.ONE_DAY_CACHESECONDS);
		}
		
		
		if (CollectionUtils.isEmpty(list)){
			return Collections.emptyList();
		}
		return BeanMapper.mapList(list, AppBannerVO.class);
	}


}
