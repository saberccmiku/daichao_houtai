package com.daichao.modules.statistics.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.modules.statistics.entity.ChannelStatEntity;
import com.daichao.modules.statistics.entity.UserStatEntity;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

/**
 * @author zhangbo
 *
 */
@MapperScan
public interface ChannelStatDao extends BaseMapper<ChannelStatEntity> {
	
	List<ChannelStatEntity> getChannelStatList(Page<ChannelStatEntity> page, Query query);
	
	List<UserStatEntity> getUserStatList(Page<UserStatEntity> page, Query query);

}
