package com.daichao.loans.basic.option;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class SendShortMsgOP implements Serializable{

    /**
     * 序列号
     */
    private static final long serialVersionUID = -7113946971315875419L;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * 信息
     */
    private String message;
    
    /**
     * 信息类型（请在此扩展）
	 * 1-注册
	 * 2-...
	 * 99-报警短信
     */
    private Integer msgType;
    
    /**
     * 用户id
     */
    private String userId;
    
    /**
     * ip
     */
    private String ip;
    
    /**
	 * 来源于哪个终端（1-ios,2-android,3-h5,4-api,5-后台网址,6-系统）
	 */
	private String source;
	
	/**
	 * 渠道id
	 */
	private String channelId;
	
	private String remark;
	
	/**
	 * 产品
	 */
	private String productId;
	
	private String channelName;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
