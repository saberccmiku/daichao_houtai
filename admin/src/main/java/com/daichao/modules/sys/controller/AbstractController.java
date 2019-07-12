package com.daichao.modules.sys.controller;

import com.daichao.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daichao.common.util.ShiroUtils;

/**
 * Controller公共组件
 * @author zcl<yczclcn@163.com>
 */
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	
}
