package com.daichao.modules.sys.controller;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.modules.sys.entity.SysLogEntity;
import com.daichao.modules.sys.service.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.entity.R;

/**
 * 系统日志
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 日志列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<SysLogEntity> listLog(@RequestBody Map<String, Object> params) {
        String dateRange = params.get("dateRange").toString();
        if (StringUtils.isNotBlank(dateRange)) {
            String[] dates = dateRange.split(" - ");
            params.put("startDate", dates[0]);
            params.put("endDate", dates[1]);
        }
        return sysLogService.listLog(params);
    }

    /**
     * 删除日志
     * @param id
     * @return
     */
    @SysLog("删除日志")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return sysLogService.batchRemove(id);
    }

    /**
     * 清空日志
     * @return
     */
    @SysLog("清空日志")
    @RequestMapping("/clear")
    public R batchRemoveAll() {
        return sysLogService.batchRemoveAll();
    }

}
