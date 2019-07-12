package com.daichao.loans.statistics.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 渠道统计表
 * @author zcl<yczclcn@163.com>
 */
public class StatisticsChannel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 渠道id
	 */
	private String channelId;
	
	/**
	 * 渠道编码
	 */
	private String channelCode;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 渠道公司id
	 */
	private String companyId;
	
	/**
	 * 统计日期YYYYMMDD
	 */
	private Integer statDate;
	
	/**
	 * 点击次数
	 */
	private Integer channelPv;
	
	/**
	 * 真实注册数
	 */
	private Integer realRegNumber;
	
	/**
	 * 登陆数
	 */
	private Integer loginNum;
	
	/**
	 * 折扣比例
	 */
	private Double discount;
	
	/**
	 * 注册基数/显示数
	 */
	private Integer regBase;
	
	/**
	 * 状态(0-初始，1-正常)
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
	

	public StatisticsChannel() {
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
     * setter for channelId
	 * @param channelId
     */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

    /**
     * getter for channelId
     */
	public String getChannelId() {
		return channelId;
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
     * setter for statDate
	 * @param statDate
     */
	public void setStatDate(Integer statDate) {
		this.statDate = statDate;
	}

    /**
     * getter for statDate
     */
	public Integer getStatDate() {
		return statDate;
	}
	
    /**
     * setter for channelPv
	 * @param channelPv
     */
	public void setChannelPv(Integer channelPv) {
		this.channelPv = channelPv;
	}

    /**
     * getter for channelPv
     */
	public Integer getChannelPv() {
		return channelPv;
	}
	
    /**
     * setter for realRegNumber
	 * @param realRegNumber
     */
	public void setRealRegNumber(Integer realRegNumber) {
		this.realRegNumber = realRegNumber;
	}

    /**
     * getter for realRegNumber
     */
	public Integer getRealRegNumber() {
		return realRegNumber;
	}
	
    /**
     * setter for loginNum
	 * @param loginNum
     */
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

    /**
     * getter for loginNum
     */
	public Integer getLoginNum() {
		return loginNum;
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
     * setter for regBase
	 * @param regBase
     */
	public void setRegBase(Integer regBase) {
		this.regBase = regBase;
	}

    /**
     * getter for regBase
     */
	public Integer getRegBase() {
		return regBase;
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
