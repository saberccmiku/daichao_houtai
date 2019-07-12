package com.daichao.loans.cust.option;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterOP implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4277008632417170841L;

	@NotBlank(message = "用户名不能为空")
	private String account;

	private String password;

	private String msgVerCode;

	private String inviteCode;

	private String ip;
	/**
	 * 用户姓名
	 */
	private String realName;

	/**
	 * 进件来源（1-ios, 2-android, 3-h5, 4-api）
	 */
	private String source;

	/**
	 * 渠道代码
	 */
	private String channel;
	
	/**
	 * 终端类型1-app 2-微信 3-qq 4-浏览器
	 */
	private Integer terminal;
	
	/**
	 * 应用id
	 */
	private Integer appId;

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsgVerCode() {
		return msgVerCode;
	}

	public void setMsgVerCode(String msgVerCode) {
		this.msgVerCode = msgVerCode;
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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}
}
