package com.daichao.modules.statistics.entity;

import java.io.Serializable;

/**
 * @author zhangbo
 * 渠道质量统计
 */
public class ChannelStatEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String registerTime;  // 统计日期
	
	private	String channelId; //渠道id
	
	private String channelName; //渠道名称
	
	private Integer linkPv; //推广链接pv
	
	private Integer regSum; //注册数
	
	private double regSumInLinkPv; // 注册率(注册/pv)
	
	private Integer loginSum; // 登陆数
	
	private double loginSumInRegSum; //登陆率(登陆/注册)
	
	private double activeTime; //激活时间
	
	private double avgActiveTime; //激活时间
	
	private double linkPvSumInLoginSum;  //平均pv(pv总数/登陆数)
	
	private Integer uvCount;  //点击产品人数
	
	private Integer uvSum; //点击产品uv总数
	
	private double uvCountInLoginSum; // uv率
	
	private double uvSumInLoginSum; //平均uv
	
	private Integer preLoginSum; //昨日登陆人数
	
	private Integer nowLoginSum; //昨日登陆今日也登陆数
	
	private double nowLoginSumInPreLoginSum; //留存率

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public double getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(double activeTime) {
		this.activeTime = activeTime;
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

	public Integer getLinkPv() {
		return linkPv;
	}

	public void setLinkPv(Integer linkPv) {
		this.linkPv = linkPv;
	}

	public Integer getRegSum() {
		return regSum;
	}

	public void setRegSum(Integer regSum) {
		this.regSum = regSum;
	}

	public double getRegSumInLinkPv() {
		return regSumInLinkPv;
	}

	public void setRegSumInLinkPv(double regSumInLinkPv) {
		this.regSumInLinkPv = regSumInLinkPv;
	}

	public Integer getLoginSum() {
		return loginSum;
	}

	public void setLoginSum(Integer loginSum) {
		this.loginSum = loginSum;
	}

	public double getLoginSumInRegSum() {
		return loginSumInRegSum;
	}

	public void setLoginSumInRegSum(double loginSumInRegSum) {
		this.loginSumInRegSum = loginSumInRegSum;
	}

	public double getAvgActiveTime() {
		return avgActiveTime;
	}

	public void setAvgActiveTime(double avgActiveTime) {
		this.avgActiveTime = avgActiveTime;
	}

	public double getLinkPvSumInLoginSum() {
		return linkPvSumInLoginSum;
	}

	public void setLinkPvSumInLoginSum(double linkPvSumInLoginSum) {
		this.linkPvSumInLoginSum = linkPvSumInLoginSum;
	}

	public Integer getUvCount() {
		return uvCount;
	}

	public void setUvCount(Integer uvCount) {
		this.uvCount = uvCount;
	}

	public Integer getUvSum() {
		return uvSum;
	}

	public void setUvSum(Integer uvSum) {
		this.uvSum = uvSum;
	}

	public double getUvCountInLoginSum() {
		return uvCountInLoginSum;
	}

	public void setUvCountInLoginSum(double uvCountInLoginSum) {
		this.uvCountInLoginSum = uvCountInLoginSum;
	}

	public double getUvSumInLoginSum() {
		return uvSumInLoginSum;
	}

	public void setUvSumInLoginSum(double uvSumInLoginSum) {
		this.uvSumInLoginSum = uvSumInLoginSum;
	}

	public Integer getPreLoginSum() {
		return preLoginSum;
	}

	public void setPreLoginSum(Integer preLoginSum) {
		this.preLoginSum = preLoginSum;
	}

	public Integer getNowLoginSum() {
		return nowLoginSum;
	}

	public void setNowLoginSum(Integer nowLoginSum) {
		this.nowLoginSum = nowLoginSum;
	}

	public double getNowLoginSumInPreLoginSum() {
		return nowLoginSumInPreLoginSum;
	}

	public void setNowLoginSumInPreLoginSum(double nowLoginSumInPreLoginSum) {
		this.nowLoginSumInPreLoginSum = nowLoginSumInPreLoginSum;
	}
}
