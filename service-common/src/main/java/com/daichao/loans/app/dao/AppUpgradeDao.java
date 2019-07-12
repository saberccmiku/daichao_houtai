package com.daichao.loans.app.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.app.entity.AppUpgrade;
import com.daichao.loans.app.option.UpgradeOP;

/**
 * APP版本升级
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface AppUpgradeDao extends BaseMapper<AppUpgrade> {
	
	/**
	 * 获取最新版本信息
	 * @param 手机系统类型: [1]-ios; [2]-android
	 * @return AppVersion
	 */
	AppUpgrade getNewVersion(@Param("type") String type, @Param("fileId") String fileId);
	
	/**
	 * 是否是最新版本
	 * @return true/false
	 */
	int isNewVersion(UpgradeOP vo);
}
