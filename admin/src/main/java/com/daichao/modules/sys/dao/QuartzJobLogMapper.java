package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.QuartzJobLogEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 定时任务日志
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	/**
	 * 清空日志
	 * @return
	 */
	int batchRemoveAll();
	
}
