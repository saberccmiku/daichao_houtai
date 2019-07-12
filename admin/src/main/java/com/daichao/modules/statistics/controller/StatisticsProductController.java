package com.daichao.modules.statistics.controller;

import com.daichao.common.entity.Page;
import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.statistics.entity.StatisticsProduct;
import com.daichao.loans.statistics.service.StatisticsProductService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.entity.R;

/**
 * 产品统计
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/statistics/products")
public class StatisticsProductController extends AbstractController {
	
	@Autowired
	private StatisticsProductService statisticsProductService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<StatisticsProduct> list(@RequestBody Map<String, Object> params) {
		String dateRange = params.get("dateRange").toString();
        if (StringUtils.isNotBlank(dateRange)) {
            String[] dates = dateRange.split(" - ");
            params.put("startDate", dates[0]);
            params.put("endDate", dates[1]);
        }
		return statisticsProductService.listStatisticsProduct(params);
	}
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/readList")
	public Page<StatisticsProduct> readList(@RequestBody Map<String, Object> params) {
		String dateRange = params.get("dateRange").toString();
        if (StringUtils.isNotBlank(dateRange)) {
            String[] dates = dateRange.split(" - ");
            params.put("startDate", dates[0]);
            params.put("endDate", dates[1]);
        }
		return statisticsProductService.listStatisticsProduct(params);
	}
		
	/**
	 * 新增
	 * @param statisticsProduct
	 * @return
	 */
	@RequestMapping("/save")
	public R save(@RequestBody StatisticsProduct statisticsProduct) {
		int count = statisticsProductService.updatePvByProduct(statisticsProduct);
		return CommonUtils.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		StatisticsProduct statisticsProduct = statisticsProductService.getStatisticsProductById(id);
		return CommonUtils.msg(statisticsProduct);
	}
	
	/**
	 * 修改
	 * @param statisticsProduct
	 * @return
	 */
	@SysLog("修改产品统计")
	@RequestMapping("/update")
	public R update(@RequestBody StatisticsProduct statisticsProduct) {
		int count = statisticsProductService.updatePvByProduct(statisticsProduct);
		return CommonUtils.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除产品统计")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		int count = statisticsProductService.batchRemove(id);
		return CommonUtils.msg(id,count);
	}
}
