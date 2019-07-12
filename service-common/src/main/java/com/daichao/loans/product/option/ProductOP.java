package com.daichao.loans.product.option;

import java.io.Serializable;

/**
 * @author zhangbo
 *
 */
public class ProductOP implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer categoryId; //产品分类(vip专区、新品专区...)
	private Integer label; //产品标签(额度高、利率低..)
	private Integer userId; //用户id
	private Integer source; //客户来源 1-ios，2-android，3-H5
	private Integer appId; // 应用ID
	
	private Integer pageNumber;

	private Integer pageSize;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getLabel() {
		return label;
	}

	public void setLabel(Integer label) {
		this.label = label;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
