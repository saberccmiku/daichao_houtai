package com.daichao.modules.statistics.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.modules.sys.entity.SysUserEntity;
import com.daichao.common.config.Global;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.product.service.LoanProductService;
import com.daichao.loans.statistics.entity.StatisticsChannel;
import com.daichao.loans.statistics.service.StatisticsChannelService;

/**
 * 渠道统计表
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/statistics/channels")
public class StatisticsChannelController extends AbstractController {
	
	@Autowired
	private StatisticsChannelService statisticsChannelService;
	
	@Autowired
	private LoanProductService loanProductService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<StatisticsChannel> list(@RequestBody Map<String, Object> params) {
		String dateRange = params.get("dateRange").toString();
        if (StringUtils.isNotBlank(dateRange)) {
            String[] dates = dateRange.split(" - ");
            params.put("startDate", dates[0]);
            params.put("endDate", dates[1]);
        }
		return statisticsChannelService.listStatisticsChannel(params);
	}
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@SysLog("查看渠道统计列表")
	@RequestMapping("/readList")
	public Page<StatisticsChannel> readList(@RequestBody Map<String, Object> params) {
		SysUserEntity user = getUser();
		if(null != params) {
			String dateRange = params.get("dateRange").toString();
			if (StringUtils.isNotBlank(dateRange)) {
				String[] dates = dateRange.split(" - ");
				params.put("startDate", dates[0]);
				params.put("endDate", dates[1]);
			}
			if (StringUtils.isNotBlank(user.getChannelId())) {
				params.put("channelId", user.getChannelId());
			}
		}
		return statisticsChannelService.listStatisticsChannel(params);
	}
		
	/**
	 * 新增
	 * @param statisticsChannel
	 * @return
	 */
	@RequestMapping("/save")
	public R save(@RequestBody StatisticsChannel statisticsChannel) {
		int count = statisticsChannelService.saveStatisticsChannel(statisticsChannel);
		return CommonUtils.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		StatisticsChannel StatisticsChannel = statisticsChannelService.getStatisticsChannelById(id);
		return CommonUtils.msg(StatisticsChannel);
	}
	
	/**
	 * 修改
	 * @param statisticsChannel
	 * @return
	 */
	@SysLog("修改渠道统计表")
	@RequestMapping("/update")
	public R update(@RequestBody StatisticsChannel statisticsChannel) {
//		StatisticsChannel temp = statisticsChannelService.selectByPrimaryKey(statisticsChannel.getId());
//		int currentRegSum = temp.getRealRegNumber(); //实际注册数
//		int currentShowReg = temp.getRegBase(); //当前显示数
//		int baseSum = 5;
//		int showReg = currentRegSum;
//		
//		// 前10不discount
//		if(statisticsChannel.getDiscount() > 0 && currentRegSum > baseSum) {
//			int discSum = Double.valueOf(Math.ceil(currentRegSum * statisticsChannel.getDiscount())).intValue(); //向上取整
//			if(discSum <= baseSum) {
//				showReg = baseSum;
//			} 
////			else if(discSum < currentShowReg) {
////				showReg = currentShowReg;
////			} 
//			else {
//				showReg = discSum;
//			}
//		}
//		statisticsChannel.setRegBase(showReg);
		int baseSum = Global.baseRegSum;
		int currentRegSum = statisticsChannel.getRealRegNumber();
		int showReg = statisticsChannel.getRegBase();
		// 前5不discount
		if(statisticsChannel.getDiscount() > 0 && currentRegSum > baseSum) {
			int discSum = Double.valueOf(Math.ceil(currentRegSum * statisticsChannel.getDiscount())).intValue(); //向上取整
			if(discSum <= baseSum) {
				showReg = baseSum;
			} else {
				showReg = discSum;
			}
		}
		statisticsChannel.setRegBase(showReg);
		int count = statisticsChannelService.updateStatisticsChannel(statisticsChannel);
		loanProductService.delRedis(statisticsChannel.getChannelId());
		return CommonUtils.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道统计表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		int count = statisticsChannelService.batchRemove(id);
		return CommonUtils.msg(id,count);
	}
	
}
