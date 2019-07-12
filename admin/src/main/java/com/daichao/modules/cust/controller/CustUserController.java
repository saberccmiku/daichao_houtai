package com.daichao.modules.cust.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.cust.entity.CustUser;
import com.daichao.loans.cust.service.CustUserService;

/**
 * 客户信息
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/cust/users")
public class CustUserController extends AbstractController {
	
	@Autowired
	private CustUserService custUserService;

	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<CustUser> list(@RequestBody Map<String, Object> params) {
//		Page<CustUser> page = new Page<>();
//		PageInfo<CustUser> pageInfo =
//				new PageInfo<>(custUserService.selectList(params));
//		
//		List<LoanChannel> list = loanChannelService.selectAll();
//		if(null != pageInfo && null != pageInfo.getList() && 
//				null != list && list.size() > 0) {
//			for(CustUser user : pageInfo.getList()) {
//				for(LoanChannel channel : list) {
//					if(channel.getId().equals(user.getChannel())) {
//						user.setChannel(channel.getChannelName());
//					}
//				}
//			}
//		}
//		page.setRows(pageInfo.getList());
//		page.setTotal((int) pageInfo.getTotal());
//		return page;
		
		
		if(null != params) {
			String dateRange = params.get("dateRange").toString();
	        if (StringUtils.isNotBlank(dateRange)) {
				String[] dates = dateRange.split(" - ");
				params.put("startDate", dates[0]);
				params.put("endDate", dates[1]);
			}
		}
		return custUserService.selectList(params);
	}
		
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody String id) {
		return CommonUtils.msg(custUserService.getCustById(id));
	}
	
	/**
	 * 修改
	 * @param custUser
	 * @return
	 */
	@SysLog("修改客户信息")
	@RequestMapping("/update")
	public R update(@RequestBody CustUser custUser) {
		return CommonUtils.msg(custUserService.updateCustUser(custUser));
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除客户信息")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return CommonUtils.msg(custUserService.batchRemove(id));
	}
	
}
