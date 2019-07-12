package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.SysLogEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 系统日志
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	/**
	 * 清空日志
	 * @return
	 */
	int batchRemoveAll();
	
}
