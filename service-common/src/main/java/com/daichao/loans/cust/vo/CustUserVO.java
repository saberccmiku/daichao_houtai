package com.daichao.loans.cust.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息表映射数据
 * 
 * @author likang
 * 
 */
public class CustUserVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID，实体唯一标识
	 */
	private String id;
	
	/**
	 * 用户昵称
	 */
	private String name;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 用户证件号码
	 */
	private String idNo;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 银行预留手机号
	 */
	private String bankMobile;
	
	/**
	 * 银行代码
	 */
	private String bankCode;
	
	/**
	 * 银行卡号
	 */
	private String cardNo;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户头像
	 */
	private String avatar;
	
	/**
	 * 用户性别
	 */
	private Integer sex;
	
	/**
	 * 生日
	 */
	private String birthday;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 支付宝账号
	 */
	private String alipayId;
	
	/**
	 * 微信互联openid
	 */
	private String weixinOpenid;
	
	/**
	 * 登录次数
	 */
	private Integer loginNum;
	
	/**
	 * 用户注册时间
	 */
	private Date registerTime;
	
	/**
	 * 当前登录时间
	 */
	private Date loginTime;
	
	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;
	
	/**
	 * 当前登录ip
	 */
	private String loginIp;
	
	/**
	 * 上次登录ip
	 */
	private String lastLoginIp;
	
	/**
	 * 用户类型
	 */
	private String type;
	
	/**
	 * 用户等级
	 */
	private String level;
	
	/**
	 * 用户积分
	 */
	private Integer points;
	
	/**
	 * 第三方支付绑定id
	 */
	private String bindId;
	
	/**
	 * 认证状态（0-未完成; 1-已完成）
	 */
	private Long identityStatus;
	
	/**
	 * 授信额度
	 */
	private BigDecimal creditLine;
	
	/**
	 * 可用授信额度
	 */
	private BigDecimal availCreditLine;
	
	/**
	 * 已用授信额度
	 */
	private BigDecimal usedCreditLine;
	
	/**
	 * 用户经验值
	 */
	private Integer exppoints;
	
	/**
	 * 来源（1-ios,2-android,3-H5）
	 */
	private Integer source;
	
	/**
	 * 终端类型1-微信 2-qq 3-浏览器 4-app
	 */
	private Integer terminal;
	
	/**
	 * 渠道
	 */
	private String channel;
	
	/**
	 * 来自哪个app
	 */
	private Integer appId;
	
	/**
	 * 邀请码
	 */
	private String inviteCode;
	
	/**
	 * 用户状态：1-正常，0-锁定账户
	 */
	private Integer status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
     * setter for realName
	 * @param realName
     */
	public void setRealName(String realName) {
		this.realName = realName;
	}

    /**
     * getter for realName
     */
	public String getRealName() {
		return realName;
	}
	
    /**
     * setter for idNo
	 * @param idNo
     */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

    /**
     * getter for idNo
     */
	public String getIdNo() {
		return idNo;
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
     * setter for bankMobile
	 * @param bankMobile
     */
	public void setBankMobile(String bankMobile) {
		this.bankMobile = bankMobile;
	}

    /**
     * getter for bankMobile
     */
	public String getBankMobile() {
		return bankMobile;
	}
	
    /**
     * setter for bankCode
	 * @param bankCode
     */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

    /**
     * getter for bankCode
     */
	public String getBankCode() {
		return bankCode;
	}
	
    /**
     * setter for cardNo
	 * @param cardNo
     */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

    /**
     * getter for cardNo
     */
	public String getCardNo() {
		return cardNo;
	}
	
    /**
     * setter for email
	 * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * getter for email
     */
	public String getEmail() {
		return email;
	}
	
    /**
     * setter for avatar
	 * @param avatar
     */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

    /**
     * getter for avatar
     */
	public String getAvatar() {
		return avatar;
	}
	
    /**
     * setter for sex
	 * @param sex
     */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

    /**
     * getter for sex
     */
	public Integer getSex() {
		return sex;
	}
	
    /**
     * setter for birthday
	 * @param birthday
     */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

    /**
     * getter for birthday
     */
	public String getBirthday() {
		return birthday;
	}
	
    /**
     * setter for password
	 * @param password
     */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * getter for password
     */
	public String getPassword() {
		return password;
	}
	
    /**
     * setter for alipayId
	 * @param alipayId
     */
	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}

    /**
     * getter for alipayId
     */
	public String getAlipayId() {
		return alipayId;
	}
	
    /**
     * setter for weixinOpenid
	 * @param weixinOpenid
     */
	public void setWeixinOpenid(String weixinOpenid) {
		this.weixinOpenid = weixinOpenid;
	}

    /**
     * getter for weixinOpenid
     */
	public String getWeixinOpenid() {
		return weixinOpenid;
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
     * setter for registerTime
	 * @param registerTime
     */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

    /**
     * getter for registerTime
     */
	public Date getRegisterTime() {
		return registerTime;
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
     * setter for lastLoginTime
	 * @param lastLoginTime
     */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

    /**
     * getter for lastLoginTime
     */
	public Date getLastLoginTime() {
		return lastLoginTime;
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
     * setter for lastLoginIp
	 * @param lastLoginIp
     */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

    /**
     * getter for lastLoginIp
     */
	public String getLastLoginIp() {
		return lastLoginIp;
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
     * setter for level
	 * @param level
     */
	public void setLevel(String level) {
		this.level = level;
	}

    /**
     * getter for level
     */
	public String getLevel() {
		return level;
	}
	
    /**
     * setter for points
	 * @param points
     */
	public void setPoints(Integer points) {
		this.points = points;
	}

    /**
     * getter for points
     */
	public Integer getPoints() {
		return points;
	}
	
    /**
     * setter for bindId
	 * @param bindId
     */
	public void setBindId(String bindId) {
		this.bindId = bindId;
	}

    /**
     * getter for bindId
     */
	public String getBindId() {
		return bindId;
	}
	
    /**
     * setter for identityStatus
	 * @param identityStatus
     */
	public void setIdentityStatus(Long identityStatus) {
		this.identityStatus = identityStatus;
	}

    /**
     * getter for identityStatus
     */
	public Long getIdentityStatus() {
		return identityStatus;
	}
	
    /**
     * setter for creditLine
	 * @param creditLine
     */
	public void setCreditLine(BigDecimal creditLine) {
		this.creditLine = creditLine;
	}

    /**
     * getter for creditLine
     */
	public BigDecimal getCreditLine() {
		return creditLine;
	}
	
    /**
     * setter for availCreditLine
	 * @param availCreditLine
     */
	public void setAvailCreditLine(BigDecimal availCreditLine) {
		this.availCreditLine = availCreditLine;
	}

    /**
     * getter for availCreditLine
     */
	public BigDecimal getAvailCreditLine() {
		return availCreditLine;
	}
	
    /**
     * setter for usedCreditLine
	 * @param usedCreditLine
     */
	public void setUsedCreditLine(BigDecimal usedCreditLine) {
		this.usedCreditLine = usedCreditLine;
	}

    /**
     * getter for usedCreditLine
     */
	public BigDecimal getUsedCreditLine() {
		return usedCreditLine;
	}
	
    /**
     * setter for exppoints
	 * @param exppoints
     */
	public void setExppoints(Integer exppoints) {
		this.exppoints = exppoints;
	}

    /**
     * getter for exppoints
     */
	public Integer getExppoints() {
		return exppoints;
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
     * setter for terminal
	 * @param terminal
     */
	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

    /**
     * getter for terminal
     */
	public Integer getTerminal() {
		return terminal;
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
     * setter for inviteCode
	 * @param inviteCode
     */
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

    /**
     * getter for inviteCode
     */
	public String getInviteCode() {
		return inviteCode;
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
}
