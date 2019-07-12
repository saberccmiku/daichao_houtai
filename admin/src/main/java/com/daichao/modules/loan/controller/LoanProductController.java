package com.daichao.modules.loan.controller;

import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.modules.sys.entity.SysUserEntity;
import com.daichao.common.config.Global;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.DateUtils;
import com.daichao.common.utils.IdGen;
import com.daichao.common.utils.OSSUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.product.entity.LoanProduct;
import com.daichao.loans.product.service.LoanProductService;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.constant.MsgConstant;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;

/**
 * 产品信息
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/loan/products")
public class LoanProductController extends AbstractController {
	
	@Autowired
	private LoanProductService loanProductService;
	
	/**
	 * 列表
	 * @param loanProduct
	 * @return
	 */
	@RequestMapping("/list")
	public Page<LoanProduct> list(@RequestBody Map<String, Object> params) {
//		String appId = params.get("appId").toString();
//		String categoryId = params.get("categoryId").toString();
//		String label = params.get("label").toString();
//		String source = params.get("source").toString();
//		String productName = params.get("productName").toString();
//		String status = params.get("status").toString();
//        if(StringUtils.isNotBlank(appId)) {
//        	params.put("appId", appId);
//        }
//        if(StringUtils.isNotBlank(categoryId)) {
//        	params.put("categoryId", categoryId);
//        }
//        if(StringUtils.isNotBlank(label)) {
//        	params.put("label", label);
//        }
//        if(StringUtils.isNotBlank(source)) {
//        	params.put("source", source);
//        }
//        if(StringUtils.isNotBlank(productName)) {
//        	params.put("productName", productName);
//        }
//        if(StringUtils.isNotBlank(status)) {
//        	params.put("status", status);
//        }
        if(null != params) {
        	String dateRange = params.get("dateRange").toString();
            if (StringUtils.isNotBlank(dateRange)) {
        		String[] dates = dateRange.split(" - ");
        		params.put("startDate", dates[0]);
        		params.put("endDate", dates[1]);
        	}
        }
		return loanProductService.listLoanProduct(params);
	}
		
	/**
	 * 新增
	 * @param loanProduct
	 * @return
	 */
	@SysLog("新增产品信息")
	@RequestMapping("/save")
	public R save(@RequestBody LoanProduct loanProduct) {
		SysUserEntity user = getUser();
		loanProduct.setCreateBy(user.getName());
		loanProduct.setCreateTime(new Date());
		loanProductService.delRedis(Global.PRODUCT_LIST_SUFFIX);
		return CommonUtils.msg(loanProductService.saveLoanProduct(loanProduct));
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Integer id) {
		return CommonUtils.msg(loanProductService.getLoanProduct(id));
	}
	
	/**
	 * 修改
	 * @param loanProduct
	 * @return
	 */
	@SysLog("修改产品信息")
	@RequestMapping("/update")
	public R update(@RequestBody LoanProduct loanProduct) {
		SysUserEntity user = getUser();
		loanProduct.setUpdateBy(user.getName());
		loanProduct.setUpdateTime(new Date());
		// 清缓存
		 String cacheKey = loanProduct.getId()+ Global.LOAN_PRO_SUFFIX;
		 loanProductService.delRedis(cacheKey);
		 loanProductService.delRedis(Global.PRODUCT_LIST_SUFFIX);
		return CommonUtils.msg(loanProductService.updateLoanProduct(loanProduct));
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除产品信息")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		loanProductService.delRedis(Global.PRODUCT_LIST_SUFFIX);
		return CommonUtils.msg(loanProductService.batchRemove(id));
	}
	
	
	/**
	 * 下架产品
	 * @return
	 */
	@SysLog("下架产品")
	@RequestMapping("/disable")
	public R disable(@RequestBody Integer productId) {
		SysUserEntity user = getUser();
		loanProductService.delRedis(Global.PRODUCT_LIST_SUFFIX);
		LoanProduct loanProduct = new LoanProduct();
		loanProduct.setId(productId);
		loanProduct.setStatus(2);
		loanProduct.setUpdateBy(user.getName());
		return CommonUtils.msg(loanProductService.updateLoanProduct(loanProduct));
	}

	/**
	 * 上架产品
	 * @return
	 */
	@SysLog("上架产品")
	@RequestMapping("/enable")
	public R enable(@RequestBody Integer productId) {
		SysUserEntity user = getUser();
		loanProductService.delRedis(Global.PRODUCT_LIST_SUFFIX);
		LoanProduct loanProduct = new LoanProduct();
		loanProduct.setId(productId);
		loanProduct.setStatus(1);
		loanProduct.setUpdateBy(user.getName());
		return CommonUtils.msg(loanProductService.updateLoanProduct(loanProduct));
	}
	

	/**
	 * 上传图片
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public R logo(@RequestParam("file") CommonsMultipartFile file) {
		String fileExt = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
		fileExt = StringUtils.lowerCase(fileExt);
		String id = IdGen.uuid();
		String fileName = id + "." + fileExt;

		String relativePath = "img/product_logo/" + DateUtils.getDate("yyyy/MM") + "/" + fileName;

		String url = null;
		try {
			url = OSSUtils.uploadFile(file.getInputStream(), relativePath);
			
			return CommonUtils.msg(url);
//			if (StringUtils.isNotBlank(url)) {
//				return R.ok("上传成功！").put("logo", url);
//			}
//			return R.error("上传失败！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return R.error(MsgConstant.MSG_OPERATION_FAILED);
	}

}
