package com.daichao.loans.app.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * APP访问日志
 * @author zcl<yczclcn@163.com>
 */
public class AppAccessLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private String id;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 请求方式
	 */
	private String method;
	
	/**
	 * 访问地址
	 */
	private String requestUrl;
	
	/**
	 * 模块名称
	 */
	private String moduleName;
	
	/**
	 * 耗时（ms）}
	 */
	private Long costTime;
	
	/**
	 * 来源
	 */
	private String source;
	
	/**
	 * IP地址
	 */
	private String ip;
	
	/**
	 * 访问日期（YYYYMMDD）
	 */
	private Integer accessDate;
	
	/**
	 * 访问时间
	 */
	private Date accessTime;
	
	/**
	 * 浏览器信息
	 */
	private String userAgent;
	
	/**
	 * 请求参数
	 */
	private String params;
	
	/**
	 * 状态
	 */
	private String status;
	
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
	

	public AppAccessLog() {
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
     * setter for method
	 * @param method
     */
	public void setMethod(String method) {
		this.method = method;
	}

    /**
     * getter for method
     */
	public String getMethod() {
		return method;
	}
	
    /**
     * setter for requestUrl
	 * @param requestUrl
     */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

    /**
     * getter for requestUrl
     */
	public String getRequestUrl() {
		return requestUrl;
	}
	
    /**
     * setter for moduleName
	 * @param moduleName
     */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

    /**
     * getter for moduleName
     */
	public String getModuleName() {
		return moduleName;
	}
	
    /**
     * setter for costTime
	 * @param costTime
     */
	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}

    /**
     * getter for costTime
     */
	public Long getCostTime() {
		return costTime;
	}
	
    /**
     * setter for source
	 * @param source
     */
	public void setSource(String source) {
		this.source = source;
	}

    /**
     * getter for source
     */
	public String getSource() {
		return source;
	}
	
    /**
     * setter for ip
	 * @param ip
     */
	public void setIp(String ip) {
		this.ip = ip;
	}

    /**
     * getter for ip
     */
	public String getIp() {
		return ip;
	}
	
    /**
     * setter for accessDate
	 * @param accessDate
     */
	public void setAccessDate(Integer accessDate) {
		this.accessDate = accessDate;
	}

    /**
     * getter for accessDate
     */
	public Integer getAccessDate() {
		return accessDate;
	}
	
    /**
     * setter for accessTime
	 * @param accessTime
     */
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

    /**
     * getter for accessTime
     */
	public Date getAccessTime() {
		return accessTime;
	}
	
    /**
     * setter for userAgent
	 * @param userAgent
     */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

    /**
     * getter for userAgent
     */
	public String getUserAgent() {
		return userAgent;
	}
	
    /**
     * setter for params
	 * @param params
     */
	public void setParams(String params) {
		this.params = params;
	}

    /**
     * getter for params
     */
	public String getParams() {
		return params;
	}
	
    /**
     * setter for status
	 * @param status
     */
	public void setStatus(String status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public String getStatus() {
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
