package com.daichao.modules.sys.controller;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.entity.QuartzJobLogEntity;
import com.daichao.modules.sys.service.QuartzJobLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 定时任务日志
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/quartz/job/log")
public class QuartzJobLogController {

	@Autowired
	private QuartzJobLogService quartzJobLogService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<QuartzJobLogEntity> list(@RequestBody Map<String, Object> params) {
		String dateRange = params.get("dateRange").toString();
		if (StringUtils.isNotBlank(dateRange)) {
			String[] dates = dateRange.split(" - ");
			params.put("startDate", dates[0]);
			params.put("endDate", dates[1]);
		}
		return quartzJobLogService.listForPage(params);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务日志")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return quartzJobLogService.batchRemove(id);
	}
	
	/**
	 * 清空
	 * @return
	 */
	@SysLog("清空定时任务日志")
	@RequestMapping("/clear")
	public R batchRemoveAll() {
		return quartzJobLogService.batchRemoveAll();
	}
	
}
