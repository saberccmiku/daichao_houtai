package com.daichao.loans.basic.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 短信发送记录
 * @author zcl<yczclcn@163.com>
 */
public class BasicSmsLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 短信发送记录ID
	 */
	private String id;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 短信动态码
	 */
	private String smsCode;
	
	/**
	 * 短信类型:如：1为注册,2为找回密码....,默认为1
	 */
	private String type;
	
	/**
	 * 来源于哪个终端（1-ios，2-android，3-H5，4-api，5-网站，6-system）
	 */
	private String source;
	
	/**
	 * 短信内容
	 */
	private String content;
	
	/**
	 * 请求IP
	 */
	private String ip;
	
	/**
	 * 添加时间
	 */
	private Date sendTime;
	
	/**
	 * 用户ID,注册为0
	 */
	private String userId;
	
	/**
	 * 短信通道代码
	 */
	private String channelCode;
	
	/**
	 * 短信通道名称
	 */
	private String channelName;
	
	/**
	 * 状态（0-待发送，1-已经发送，2-发送成功，3-发送失败）
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
     * setter for smsCode
	 * @param smsCode
     */
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

    /**
     * getter for smsCode
     */
	public String getSmsCode() {
		return smsCode;
	}
	
    /**
     * setter for type
	 * @param type
     */
	public void setType(String type) {
		this.type = type;
	}

    /**
     * getter for type
     */
	public String getType() {
		return type;
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
     * setter for content
	 * @param content
     */
	public void setContent(String content) {
		this.content = content;
	}

    /**
     * getter for content
     */
	public String getContent() {
		return content;
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
     * setter for sendTime
	 * @param sendTime
     */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

    /**
     * getter for sendTime
     */
	public Date getSendTime() {
		return sendTime;
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
