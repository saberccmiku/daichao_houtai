package com.daichao.loans.cust.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author zcl<yczclcn@163.com>
 */
public class CustLoginLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private String userId;
	
	/**
	 * 
	 */
	private String mobile;
	
	/**
	 * 
	 */
	private String loginIp;
	
	/**
	 * 
	 */
	private Integer appId;
	
	/**
	 * 
	 */
	private Integer source;
	
	/**
	 * 
	 */
	private String remark;
	
	/**
	 * 
	 */
	private Date loginTime;
	
	/**
	 * 删除标记：0-正常，1-已经删除
	 */
	private Integer del;
	

	public CustLoginLog() {
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
	public void setUserId(String userId) {
		this.userId = userId;
	}

    /**
     * getter for userId
     */
	public String getUserId() {
		return userId;
	}
	
    /**
     * setter for mobile
	 * @param mobile
     */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    /**
     * getter for mobile
     */
	public String getMobile() {
		return mobile;
	}
	
    /**
     * setter for loginIp
	 * @param loginIp
     */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

    /**
     * getter for loginIp
     */
	public String getLoginIp() {
		return loginIp;
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
     * setter for source
	 * @param source
     */
	public void setSource(Integer source) {
		this.source = source;
	}

    /**
     * getter for source
     */
	public Integer getSource() {
		return source;
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
     * setter for loginTime
	 * @param loginTime
     */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

    /**
     * getter for loginTime
     */
	public Date getLoginTime() {
		return loginTime;
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
