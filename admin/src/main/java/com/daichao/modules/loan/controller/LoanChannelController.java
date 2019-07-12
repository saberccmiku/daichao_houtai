package com.daichao.modules.loan.controller;

import java.util.ArrayList;
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
import com.daichao.modules.sys.service.SysUserService;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.IdGen;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.channel.entity.LoanChannel;
import com.daichao.loans.channel.service.LoanChannelService;

/**
 * 渠道信息
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/loan/channels")
public class LoanChannelController extends AbstractController {
	
	@Autowired
	private LoanChannelService loanChannelService;
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LoanChannel> list(@RequestBody Map<String, Object> params) {
//		Page<LoanChannel> page = new Page<>();
//		PageInfo<LoanChannel> pageInfo =
//				new PageInfo<>(loanChannelService.selectList(params));
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
		return loanChannelService.listLoanChannel(params);
	}
	

	@RequestMapping("/selectAll")
	public List<LoanChannel> selectAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Global.YES);
		params.put("del", Global.NO);
		return loanChannelService.getChannelList(params);
	}
		
	/**
	 * 新增
	 * @param loanChannel
	 * @return
	 */
	@SysLog("新增渠道信息")
	@RequestMapping("/save")
	public R save(@RequestBody LoanChannel loanChannel) {
		SysUserEntity sysUser = getUser();
		loanChannel.setCreateBy(sysUser.getName());
		loanChannel.setId(IdGen.randomBase62(10));;
		
		// 为渠道链接开账号
		SysUserEntity user = new SysUserEntity();
		user.setUsername(loanChannel.getId());
		user.setPassword("a123123");
		user.setName(loanChannel.getChannelName());
		List<Long> roleIdList = new ArrayList<Long>();
		roleIdList.add(5L); //渠道方角色
		user.setRoleIdList(roleIdList);
		user.setUserIdCreate(getUserId());
		user.setChannelId(loanChannel.getId());
		user.setOrgId(5L);
		user.setStatus(1);
		sysUserService.saveUser(user);
		
		return CommonUtils.msg(loanChannelService.saveLoanChannel(loanChannel));
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return CommonUtils.msg(loanChannelService.getLoanChannelById(id));
	}
	
	/**
	 * 修改
	 * @param loanChannel
	 * @return
	 */
	@SysLog("修改渠道信息")
	@RequestMapping("/update")
	public R update(@RequestBody LoanChannel loanChannel) {
		SysUserEntity user = getUser();
		loanChannel.setUpdateBy(user.getName());
		return CommonUtils.msg(loanChannelService.updateLoanChannel(loanChannel));
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道信息")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return CommonUtils.msg(loanChannelService.batchRemove(id));
	}
	
	/**
	 * 禁用渠道
	 * @return
	 */
	@SysLog("禁用渠道")
	@RequestMapping("/disable")
	public R disable(@RequestBody String id) {
		SysUserEntity user = getUser();
		LoanChannel loanChannel = new LoanChannel();
		loanChannel.setId(id);
		loanChannel.setStatus(0);
		loanChannel.setUpdateBy(user.getName());
		return CommonUtils.msg(loanChannelService.updateLoanChannel(loanChannel));
	}

	/**
	 * 启用渠道
	 * @return
	 */
	@SysLog("启用渠道")
	@RequestMapping("/enable")
	public R enable(@RequestBody String id) {
		SysUserEntity user = getUser();
		LoanChannel loanChannel = new LoanChannel();
		loanChannel.setId(id);
		loanChannel.setStatus(1);
		loanChannel.setUpdateBy(user.getName());
		return CommonUtils.msg(loanChannelService.updateLoanChannel(loanChannel));
	}
	
}
