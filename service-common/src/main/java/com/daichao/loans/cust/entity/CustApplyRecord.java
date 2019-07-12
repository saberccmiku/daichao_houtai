package com.daichao.loans.cust.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 申请记录
 * @author zcl<yczclcn@163.com>
 */
public class CustApplyRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 用户来源渠道
	 */
	private String channel;
	
	/**
	 * 产品ID
	 */
	private Integer productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * logo
	 */
	private String productLogo;
	
	/**
	 * 申请金额
	 */
	private BigDecimal money;
	
	/**
	 * 申请期限
	 */
	private Integer term;
	
	/**
	 * 借款单位（M-月、Q-季、Y-年、D-天）
	 */
	private String loanUnit;
	
	/**
	 * 利率
	 */
	private Float rate;
	
	/**
	 * 点击该产品次数
	 */
	private Integer pv;
	
	/**
	 * 应用编号
	 */
	private Integer appId;
	
	/**
	 * 申请日期
	 */
	private Date applyDate;
	
	/**
	 * 申请时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 删除标记：0-正常，1-删除
	 */
	private Integer del;
	

	public CustApplyRecord() {
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
     * setter for userId
	 * @param userId
     */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    /**
     * getter for userId
     */
	public Integer getUserId() {
		return userId;
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
     * setter for productId
	 * @param productId
     */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

    /**
     * getter for productId
     */
	public Integer getProductId() {
		return productId;
	}
	
    /**
     * setter for productName
	 * @param productName
     */
	public void setProductName(String productName) {
		this.productName = productName;
	}

    /**
     * getter for productName
     */
	public String getProductName() {
		return productName;
	}
	
    /**
     * setter for productLogo
	 * @param productLogo
     */
	public void setProductLogo(String productLogo) {
		this.productLogo = productLogo;
	}

    /**
     * getter for productLogo
     */
	public String getProductLogo() {
		return productLogo;
	}
	
    /**
     * setter for money
	 * @param money
     */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

    /**
     * getter for money
     */
	public BigDecimal getMoney() {
		return money;
	}
	
    /**
     * setter for term
	 * @param term
     */
	public void setTerm(Integer term) {
		this.term = term;
	}

    /**
     * getter for term
     */
	public Integer getTerm() {
		return term;
	}
	
    /**
     * setter for loanUnit
	 * @param loanUnit
     */
	public void setLoanUnit(String loanUnit) {
		this.loanUnit = loanUnit;
	}

    /**
     * getter for loanUnit
     */
	public String getLoanUnit() {
		return loanUnit;
	}
	
    /**
     * setter for rate
	 * @param rate
     */
	public void setRate(Float rate) {
		this.rate = rate;
	}

    /**
     * getter for rate
     */
	public Float getRate() {
		return rate;
	}
	
    /**
     * setter for pv
	 * @param pv
     */
	public void setPv(Integer pv) {
		this.pv = pv;
	}

    /**
     * getter for pv
     */
	public Integer getPv() {
		return pv;
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
     * setter for applyDate
	 * @param applyDate
     */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

    /**
     * getter for applyDate
     */
	public Date getApplyDate() {
		return applyDate;
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
