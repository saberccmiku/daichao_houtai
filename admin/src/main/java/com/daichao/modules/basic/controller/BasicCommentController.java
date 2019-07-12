package com.daichao.modules.basic.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daichao.common.annotation.SysLog;
import com.daichao.common.constant.SystemConstant;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.R;
import com.daichao.modules.sys.controller.AbstractController;
import com.daichao.common.utils.CommonUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.basic.entity.BasicComment;
import com.daichao.loans.basic.service.BasicCommentService;
import com.daichao.loans.cust.entity.CustApplyRecord;

/**
 * 留言反馈
 * @author zcl<yczclcn@163.com>
 */
@RestController
@RequestMapping("/basic/comments")
public class BasicCommentController extends AbstractController {
	
	@Autowired
	private BasicCommentService basicCommentService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BasicComment> list(@RequestBody Map<String, Object> params) {
//		if(null != params) {
//			String dateRange = params.get("dateRange").toString();
//	        if (StringUtils.isNotBlank(dateRange)) {
//				String[] dates = dateRange.split(" - ");
//				params.put("startDate", dates[0]);
//				params.put("endDate", dates[1]);
//			}
//		}
        return basicCommentService.listBasicComment(params);
	}
		
	/**
	 * 新增
	 * @param basicComment
	 * @return
	 */
	@SysLog("新增留言反馈")
	@RequestMapping("/save")
	public R save(@RequestBody BasicComment basicComment) {
		basicComment.setUpdateTime(new Date());
		basicComment.setCreateTime(basicComment.getUpdateTime());
		return CommonUtils.msg(basicCommentService.saveBasicComment(basicComment));
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return CommonUtils.msg(basicCommentService.getBasicCommentById(id));
	}
	
	/**
	 * 修改
	 * @param basicComment
	 * @return
	 */
	@SysLog("修改留言反馈")
	@RequestMapping("/update")
	public R update(@RequestBody BasicComment basicComment) {
		basicComment.setUpdateTime(new Date());
		return CommonUtils.msg(basicCommentService.updateBasicComment(basicComment));
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除留言反馈")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return CommonUtils.msg(basicCommentService.batchRemove(id));
	}
	
}
