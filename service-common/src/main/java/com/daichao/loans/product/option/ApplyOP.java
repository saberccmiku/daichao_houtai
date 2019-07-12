package com.daichao.loans.product.option;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangbo
 *
 */
@Data
public class ApplyOP implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer productId; //产品ID
	private Integer userId; //用户id
	private String source; //客户来源 1-ios，2-android，3-H5
	private Integer appId; // 应用ID(1:乐享用)
	
}
