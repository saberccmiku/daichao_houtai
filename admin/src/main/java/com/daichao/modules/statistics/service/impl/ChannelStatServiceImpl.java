package com.daichao.modules.statistics.service.impl;

import java.util.*;

import com.daichao.modules.statistics.dao.ChannelStatDao;
import com.daichao.modules.statistics.entity.ChannelStatEntity;
import com.daichao.modules.statistics.entity.UserStatEntity;
import com.daichao.modules.statistics.service.ChannelStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;

/**
 * 系统用户
 * @author zcl<yczclcn@163.com>
 */
@Service("channelStatService")
public class ChannelStatServiceImpl implements ChannelStatService {

	@Autowired
	private ChannelStatDao channelStatDao;

	@Override
	public Page<ChannelStatEntity> getChannelStatList(Map<String, Object> params) {
		Query form = new Query(params);
		Page<ChannelStatEntity> page = new Page<>(form);
		channelStatDao.getChannelStatList(page, form);
//		if(page != null) {
//			List<ChannelStatEntity> list = page.getRows();
//			for (ChannelStatEntity cse : list) {
//				
//			}
//		}
		
		return page;
	}

	@Override
	public Page<UserStatEntity> getUserStatList(Map<String, Object> params) {
		Query form = new Query(params);
		Page<UserStatEntity> page = new Page<>(form);
		channelStatDao.getUserStatList(page, form);
		return page;
	}


}
