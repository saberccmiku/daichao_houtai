package com.daichao.modules.statistics.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.modules.statistics.entity.ChannelStatEntity;
import com.daichao.modules.statistics.entity.UserStatEntity;

/**
 * @author zhangbo
 *
 */
public interface ChannelStatService {

	/**
	 * 分页查询渠道统计列表
	 * @param params
	 * @return
	 */
	Page<ChannelStatEntity> getChannelStatList(Map<String, Object> params);
	
	Page<UserStatEntity> getUserStatList(Map<String, Object> params);
}
