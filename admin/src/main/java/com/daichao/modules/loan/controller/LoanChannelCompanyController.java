package com.daichao.modules.loan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.config.Global;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.modules.sys.entity.SysUserEntity;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.channel.entity.LoanChannelCompany;
import com.daichao.loans.channel.service.LoanChannelCompanyService;

/**
 * 渠道公司
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/loan/channelCompanys")
public class LoanChannelCompanyController extends AbstractController {
	
	@Autowired
	private LoanChannelCompanyService loanChannelCompanyService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LoanChannelCompany> list(@RequestBody  Map<String, Object> params) {
		if(null != params) {
			String dateRange = params.get("dateRange").toString();
	        if (StringUtils.isNotBlank(dateRange)) {
				String[] dates = dateRange.split(" - ");
				params.put("startDate", dates[0]);
				params.put("endDate", dates[1]);
			}
		}
		return loanChannelCompanyService.listLoanChannelCompany(params);
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/select")
	public List<LoanChannelCompany> select() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Global.YES);
		params.put("del", Global.NO);
		return loanChannelCompanyService.getChannelCompanyList(params);
	}
	
		
	/**
	 * 新增
	 * @param loanChannelCompany
	 * @return
	 */
	@SysLog("新增渠道公司")
	@RequestMapping("/save")
	public R save(@RequestBody LoanChannelCompany loanChannelCompany) {
		SysUserEntity user = getUser();
		loanChannelCompany.setCreateBy(user.getName());
		loanChannelCompany.setCreateTime(new Date());
		return CommonUtils.msg(loanChannelCompanyService.saveLoanChannelCompany(loanChannelCompany));
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return CommonUtils.msg(loanChannelCompanyService.getLoanChannelCompanyById(id));
	}
	
	/**
	 * 修改
	 * @param loanChannelCompany
	 * @return
	 */
	@SysLog("修改渠道公司")
	@RequestMapping("/update")
	public R update(@RequestBody LoanChannelCompany loanChannelCompany) {
		SysUserEntity user = getUser();
		loanChannelCompany.setUpdateBy(user.getName());
		loanChannelCompany.setUpdateTime(new Date());
		return CommonUtils.msg(loanChannelCompanyService.updateLoanChannelCompany(loanChannelCompany));
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道公司")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return CommonUtils.msg(loanChannelCompanyService.batchRemove(id));
	}
	
	
	/**
	 * 禁用渠道公司
	 * @return
	 */
	@SysLog("禁用渠道公司")
	@RequestMapping("/disable")
	public R disable(@RequestBody Integer id) {
		SysUserEntity user = getUser();
		LoanChannelCompany channelCompany = new LoanChannelCompany();
		channelCompany.setId(id);
		channelCompany.setStatus(0);
		channelCompany.setUpdateBy(user.getName());
		return CommonUtils.msg(loanChannelCompanyService.updateLoanChannelCompany(channelCompany));
	}

	/**
	 * 启用渠道公司
	 * @return
	 */
	@SysLog("启用渠道公司")
	@RequestMapping("/enable")
	public R enable(@RequestBody Integer id) {
		SysUserEntity user = getUser();
		LoanChannelCompany channelCompany = new LoanChannelCompany();
		channelCompany.setId(id);
		channelCompany.setStatus(1);
		channelCompany.setUpdateBy(user.getName());
		return CommonUtils.msg(loanChannelCompanyService.updateLoanChannelCompany(channelCompany));
	}
	
}
