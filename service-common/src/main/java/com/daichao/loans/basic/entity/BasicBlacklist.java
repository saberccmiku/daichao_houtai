package com.daichao.loans.basic.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 基础黑名单（手机号、ip等）
 * @author zcl<yczclcn@163.com>
 */
public class BasicBlacklist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private String id;
	
	/**
	 * 黑名单类型（1：手机号； 2：ip）
	 */
	private Integer blType;
	
	/**
	 * 黑名单内容（手机号或ip）
	 */
	private String blValue;
	
	/**
	 * 添加日期(YYYY-MM-DD)
	 */
	private String blDate;
	
	/**
	 * 渠道
	 */
	private String channel;
	
	/**
	 * 备注信息
	 */
	private String remark;
	
	/**
	 * 创建者
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改者
	 */
	private String updateBy;
	
	/**
	 * 最后修改时间
	 */
	private Date updateTime;
	
	/**
	 * 删除标记：0-正常，1-已经删除
	 */
	private Integer del;
	
    /**
     * setter for id
	 * @param id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public String getId() {
		return id;
	}
	
    /**
     * setter for blType
	 * @param blType
     */
	public void setBlType(Integer blType) {
		this.blType = blType;
	}

    /**
     * getter for blType
     */
	public Integer getBlType() {
		return blType;
	}
	
    /**
     * setter for blValue
	 * @param blValue
     */
	public void setBlValue(String blValue) {
		this.blValue = blValue;
	}

    /**
     * getter for blValue
     */
	public String getBlValue() {
		return blValue;
	}
	
    /**
     * setter for blDate
	 * @param blDate
     */
	public void setBlDate(String blDate) {
		this.blDate = blDate;
	}

    /**
     * getter for blDate
     */
	public String getBlDate() {
		return blDate;
	}
	
    /**
     * setter for channel
	 * @param channel
     */
	public void setChannel(String channel) {
		this.channel = channel;
	}

    /**
     * getter for channel
     */
	public String getChannel() {
		return channel;
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
     * setter for createBy
	 * @param createBy
     */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

    /**
     * getter for createBy
     */
	public String getCreateBy() {
		return createBy;
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
     * setter for updateBy
	 * @param updateBy
     */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

    /**
     * getter for updateBy
     */
	public String getUpdateBy() {
		return updateBy;
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
