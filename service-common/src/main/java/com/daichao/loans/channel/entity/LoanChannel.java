package com.daichao.loans.channel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 渠道信息
 * @author zcl<yczclcn@163.com>
 */
public class LoanChannel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 渠道号
	 */
	private String id;
	
	/**
	 * 渠道编码
	 */
	private String channelCode;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 渠道链接
	 */
	private String channelUrl;
	
	/**
	 * 渠道公司id
	 */
	private String companyId;
	
	/**
	 * 渠道总点击数
	 */
	private Long pv;
	
	/**
	 * 折扣比例
	 */
	private Double discount;
	
	/**
	 * 应用编号
	 */
	private Integer appId;
	
	/**
	 * 状态(0-初始，1-正常 2-下架)
	 */
	private Integer status;
	
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
	

	public LoanChannel() {
		super();
	}

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
     * setter for channelCode
	 * @param channelCode
     */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

    /**
     * getter for channelCode
     */
	public String getChannelCode() {
		return channelCode;
	}
	
    /**
     * setter for channelName
	 * @param channelName
     */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

    /**
     * getter for channelName
     */
	public String getChannelName() {
		return channelName;
	}
	
    /**
     * setter for channelUrl
	 * @param channelUrl
     */
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

    /**
     * getter for channelUrl
     */
	public String getChannelUrl() {
		return channelUrl;
	}
	
    /**
     * setter for companyId
	 * @param companyId
     */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

    /**
     * getter for companyId
     */
	public String getCompanyId() {
		return companyId;
	}
	
    /**
     * setter for pv
	 * @param pv
     */
	public void setPv(Long pv) {
		this.pv = pv;
	}

    /**
     * getter for pv
     */
	public Long getPv() {
		return pv;
	}
	
    /**
     * setter for discount
	 * @param discount
     */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

    /**
     * getter for discount
     */
	public Double getDiscount() {
		return discount;
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
