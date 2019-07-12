package com.daichao.common.config;

/**
 * 短信模板
 * @author likang
 * @version 2017-07-15
 */
public class ShortMsgTemplate {

	/**
	 * app名称
	 */
	public static final String APP_NAME = "贷超";
	
	/**
	 * 验证码替换关键字
	 */
	public static final String REPLACE_CODE = "code";
	
	/**
	 * 注册短信验证码-短信模板
	 */
	public static final String MSG_TEMP_REG = "您的验证码为code。请于5分钟内完成验证。";
	
	/**
	 * 短信类型码-注册
	 */
	public static final String MSG_TYPE_REG = "1";
	
	/**
	 * 修改登录密码短信验证码-短信模板
	 */
	public static final String MSG_TEMP_UPDATE_PWD = "您的验证码为code。请于5分钟内完成验证。";
	
	/**
	 * 找回密码短信验证码-短信模板
	 */
	public static final String MSG_TEMP_FIND_PWD = "您的验证码为code。请于5分钟内完成验证。";
	
	/**
	 * 登录短信验证码-短信模板
	 */
	public static final String MSG_TEMP_LOGIN = "您的验证码为code。请于5分钟内完成验证。";
	
	/**
	 * 找回密码短信验证码-短信模板
	 */
	public static final String MSG_TEMP_SEND_PWD = "您好，您已成功注册贷超，登录密码%s ,请勿泄露。";
	
	/**
	 * 短信类型码-找回密码
	 */
	public static final String MSG_TYPE_FIND_PWD = "2";
	
	/**
	 * 短信数量预警提醒
	 */
	public static final String MSG_COUNT_WARN = "尊敬的同事，今天短信发送量已达%s，请关注。";
	
	/**
	 * 注册成功短信
	 */
	public static final String REG_SUCCESS = "尊敬的用户，您已成功注册贷超，请下载APP，即可在线申请。";
	
}
