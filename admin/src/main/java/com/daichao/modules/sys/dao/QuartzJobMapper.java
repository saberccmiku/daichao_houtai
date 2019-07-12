package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.QuartzJobEntity;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 定时任务
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
