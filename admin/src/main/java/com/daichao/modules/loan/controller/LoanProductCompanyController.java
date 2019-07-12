package com.daichao.modules.loan.controller;

import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.modules.sys.entity.SysUserEntity;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.product.entity.LoanProductCompany;
import com.daichao.loans.product.service.LoanProductCompanyService;

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

/**
 * 放贷公司信息
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/loan/productCompanys")
public class LoanProductCompanyController extends AbstractController {
	
	@Autowired
	private LoanProductCompanyService loanProductCompanyService;
	
	/**
	 * 列表
	 * @param loanProductCompany
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LoanProductCompany> list(@RequestBody Map<String, Object> params) {
//		if(null != params) {
//			String dateRange = params.get("dateRange").toString();
//	        if (StringUtils.isNotBlank(dateRange)) {
//				String[] dates = dateRange.split(" - ");
//				params.put("startDate", dates[0]);
//				params.put("endDate", dates[1]);
//			}
//		}
		return loanProductCompanyService.listLoanProductCompany(params);
	}

	/**
	 * @return
	 */
	@RequestMapping("/select")
	public List<LoanProductCompany> select() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Global.YES);
		params.put("del", Global.NO);
		return loanProductCompanyService.getProductCompanyList(params);
	}
	
	/**
	 * 新增
	 * @param loanProductCompany
	 * @return
	 */
	@SysLog("新增放贷公司信息")
	@RequestMapping("/save")
	public R save(@RequestBody LoanProductCompany loanProductCompany) {
		SysUserEntity user = getUser();
		loanProductCompany.setCreateBy(user.getName());
		loanProductCompany.setCreateTime(new Date());
		int count = loanProductCompanyService.saveLoanProductCompany(loanProductCompany);
		return CommonUtils.msg(count);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		LoanProductCompany loanProductCompany = loanProductCompanyService.getLoanProductCompanyById(id);
		return CommonUtils.msg(loanProductCompany);
	}
	
	/**
	 * 修改
	 * @param loanProductCompany
	 * @return
	 */
	@SysLog("修改放贷公司信息")
	@RequestMapping("/update")
	public R update(@RequestBody LoanProductCompany loanProductCompany) {
		SysUserEntity user = getUser();
		loanProductCompany.setUpdateBy(user.getName());
		loanProductCompany.setUpdateTime(new Date());
		int count = loanProductCompanyService.updateLoanProductCompany(loanProductCompany);
		return CommonUtils.msg(count);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除放贷公司信息")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		int count = loanProductCompanyService.batchRemove(id);
		return CommonUtils.msg(id,count);
	}
	
	/**
	 * 禁用产品公司
	 * @return
	 */
	@SysLog("下架产品")
	@RequestMapping("/disable")
	public R disable(@RequestBody Integer id) {
		LoanProductCompany productCompany = new LoanProductCompany();
		productCompany.setId(id);;
		productCompany.setStatus(0);
		return CommonUtils.msg(loanProductCompanyService.updateLoanProductCompany(productCompany));
	}

	/**
	 * 启用产品公司
	 * @return
	 */
	@SysLog("上架产品")
	@RequestMapping("/enable")
	public R enable(@RequestBody Integer id) {
		LoanProductCompany productCompany = new LoanProductCompany();
		productCompany.setId(id);;
		productCompany.setStatus(1);
		return CommonUtils.msg(loanProductCompanyService.updateLoanProductCompany(productCompany));
	}
	
}
