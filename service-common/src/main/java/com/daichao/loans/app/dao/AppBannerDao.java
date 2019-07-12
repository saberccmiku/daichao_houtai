package com.daichao.loans.app.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.app.entity.AppBanner;

/**
 * AppBanner
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface AppBannerDao extends BaseMapper<AppBanner> {
	
	/**
	 * 根据分类编号查询
	 * @param categoryId
	 * @return
	 */
	List<AppBanner> getAppBannerByType(String categoryId);
}
