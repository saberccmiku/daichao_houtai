package com.daichao.modules.statistics.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangbo
 * 渠道质量统计
 */
public class UserStatEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date statDate;  // 统计日期
	
	private Integer userId;
	
	private String mobile;
	
	private String name;
	
	private Date registerTime;
	
	private Date loginTime;
	
	private Date lastLoginTime;
	
	private String regIp;
	
	private String loginIp;
	
	private Integer loginNum;
	
	private long activeTime;
	
	private Integer pv;
	
	private Integer uv;
	
	private	String channelId; //渠道id
	
	private String channelName; //渠道名称
	
	private Integer source;
	
	private Integer loginSource;
	
	private Integer terminal;

	public Date getStatDate() {
		return statDate;
	}

	public void setStatDate(Date statDate) {
		this.statDate = statDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date regiserTime) {
		this.registerTime = regiserTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	public long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(long activeTime) {
		this.activeTime = activeTime;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getUv() {
		return uv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getLoginSource() {
		return loginSource;
	}

	public void setLoginSource(Integer loginSource) {
		this.loginSource = loginSource;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

}
