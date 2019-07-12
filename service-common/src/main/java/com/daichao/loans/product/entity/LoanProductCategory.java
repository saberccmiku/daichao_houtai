package com.daichao.loans.product.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 产品分类表
 * @author zcl<yczclcn@163.com>
 */
public class LoanProductCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产品类别
	 */
	private Integer id;
	
	/**
	 * 分类名称
	 */
	private String name;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 应用ID
	 */
	private Integer appId;
	
	/**
	 * 状态（0-不可用,1-可用）
	 */
	private Integer status;
	
	/**
	 * 备注信息
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改时间
	 */
	private Date updateTime;
	
	/**
	 * 删除标记：0-正常，1-已经删除
	 */
	private Integer del;
	

	public LoanProductCategory() {
		super();
	}

    /**
     * setter for id
	 * @param id
     */
	public void setId(Integer id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Integer getId() {
		return id;
	}
	
    /**
     * setter for name
	 * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * getter for name
     */
	public String getName() {
		return name;
	}
	
    /**
     * setter for icon
	 * @param icon
     */
	public void setIcon(String icon) {
		this.icon = icon;
	}

    /**
     * getter for icon
     */
	public String getIcon() {
		return icon;
	}
	
    /**
     * setter for sort
	 * @param sort
     */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

    /**
     * getter for sort
     */
	public Integer getSort() {
		return sort;
	}
	
    /**
     * setter for appId
	 * @param appId
     */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}

    /**
     * getter for appId
     */
	public Integer getAppId() {
		return appId;
	}
	
    /**
     * setter for status
	 * @param status
     */
	public void setStatus(Integer status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public Integer getStatus() {
		return status;
	}
	
    /**
     * setter for remark
	 * @param remark
     */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    /**
     * getter for remark
     */
	public String getRemark() {
		return remark;
	}
	
    /**
     * setter for createTime
	 * @param createTime
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    /**
     * getter for createTime
     */
	public Date getCreateTime() {
		return createTime;
	}
	
    /**
     * setter for updateTime
	 * @param updateTime
     */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    /**
     * getter for updateTime
     */
	public Date getUpdateTime() {
		return updateTime;
	}
	
    /**
     * setter for del
	 * @param del
     */
	public void setDel(Integer del) {
		this.del = del;
	}

    /**
     * getter for del
     */
	public Integer getDel() {
		return del;
	}
	
}
