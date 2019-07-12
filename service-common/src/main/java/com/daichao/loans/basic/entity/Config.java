/**
 *Copyright 2014-2017 贷超 All rights reserved.
 */
package com.daichao.loans.basic.entity;

import java.io.Serializable;

/**
 * 公共配置表Entity
 * @author liuzhuang
 * @version 2018-07-16
 */
public class Config implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	  *参数名
	  */
	private String key;		
	/**
	  *参数值
	  */
	private String value;		
	
	public Config() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}