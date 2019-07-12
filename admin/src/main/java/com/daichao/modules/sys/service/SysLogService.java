package com.daichao.modules.sys.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * @author zcl<yczclcn@163.com>
 */
public interface SysLogService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<SysLogEntity> listLog(Map<String, Object> params);

    /**
     * 批量删除
     * @param id
     * @return
     */
    R batchRemove(Long[] id);

    /**
     * 清空
     * @return
     */
    R batchRemoveAll();

}
