/**
 * Copyright 2014-2017   All rights reserved.
 */
package com.daichao.common.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;

import com.google.common.collect.Maps;
import com.daichao.common.utils.PropertiesLoader;

/**
 * 全局配置类
 * 
 * @author sunda
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("config.properties");

	public static String PROFILE = Global.getConfig("profile");

	/**
	 * 短信配置
	 */
	public static String YIMEI_APP_ID = Global.getConfig("yimei_user_id");
	public static String YIMEI_KEY = Global.getConfig("yimei_pwd");
	// 短信息发送接口（相同内容群发，可自定义流水号）
	public static String YIMEI_URL = Global.getConfig("yimei_url");

	/**
	 * 默认操作id
	 */
	public static final String DEFAULT_OPERATOR_ID = "0";
	/**
	 * APP消息通知类型， 0 系统
	 */
	public static final int CUST_MESSAGE_TYPE_SYS = 0;
	/**
	 * APP消息通知方式，0站内信
	 */
	public static final int CUST_MESSAGE_NOTIFY_TYPE_0 = 0;
	/**
	 * APP消息未读
	 */
	public static final int CUST_MESSAGE_VIEW_STATUS_0 = 0;
	/**
	 * APP消息已读
	 */
	public static final int CUST_MESSAGE_VIEW_STATUS_1 = 1;

	/**
	 * 默认消息来源[6](系统)
	 */
	public static final int DEFAULT_SOURCE = 6;

	/**
	 * 默认操作id
	 */
	public static final String DEFAULT_OPERATOR_NAME = "system";

	/**
	 * D-天,M-月
	 */
	public static final String DEFAULT_PERIOD_UNIT = "M";

	/**
	 * 不保留小数
	 */
	public static final int DEFAULT_ZERO_SCALE = 0;

	/**
	 * 金额默认精确位数
	 */
	public static final int DEFAULT_AMT_SCALE = 2;

	/**
	 * 精确6数
	 */
	public static final int SIX_SCALE = 6;

	/**
	 * 精确4数
	 */
	public static final int FOUR_SCALE = 4;

	/**
	 * 默认证件类型
	 */
	public static final String DEFAULT_ID_TYPE = "0";

	/**
	 * 默认证件类型-Integer
	 */
	public static final Integer DEFAULT_ID_TYPE_INT = 1;

	/**
	 * 一年计息天数
	 */
	public static final int YEAR_DAYS = 365;

	/**
	 * 一年计息天数(分期)
	 */
	public static final int YEAR_DAYS_FENQI = 360;

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final int YES = 1;
	public static final int NO = 0;

	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * app端 BANNERS的默认分类编号
	 */
	public static final String APP_BANNERS_CATEGORY_ID = "19";

	/**
	 * 合同编号前缀
	 */
	public static final String AGREEMENT_NO_PREFIX = "XY";

	/**
	 * 用户信息缓存key前缀
	 */
	public static final String USER_CACHE_PREFIX = "user_";

	/**
	 * 用户密码输错次数统计缓存key前缀
	 */
	public static final String PWDERROR_CNT_CACHE_PREFIX = "pwd_err_cnt_";

	/**
	 * 用户锁定标识缓存key前缀
	 */
	public static final String LOCK_USER_PREFIX = "lock_user_";

	/**
	 * 用户认证标识缓存key前缀
	 */
	public static final String USER_AUTH_PREFIX = "user_auth_";

	/**
	 * 用户锁定标识
	 */
	public static final Integer LOCK_USER_FLAG = 0;

	/**
	 * 密码输错达6次用户锁定时间（4小时）
	 */
	public static final int USER_LOCK_CACHESECONDS = 60 * 60 * 4;

	/**
	 * 用户密码输错最大次数
	 */
	public static final int PWDERROR_MAX_CNT = 15;

	/**
	 * 营销方案缓存key前缀
	 */
	public static final String PROMOTION_CASE_CACHE_PREFIX = "promotionCase_";

	/**
	 * 短信验证码日限制条数
	 */
	public static final int MSG_SEND_DAY_LIMIT = 5;

	/**
	 * 短信验证码类型限制条数
	 */
	public static final int MSG_SEND_TYPE_LIMIT = 5;

	/**
	 * 短信验证码ip黑名单允许最大值
	 */
	public static final int MSG_IP_BL_LIMIT = 6;

	/**
	 * 短信验证码日统计缓存key后缀
	 */
	public static final String COUNT_DAY_MCODE_SUFFIX = "_mcode_day_count";

	/**
	 * 短信验证码日统计缓存key后缀
	 */
	public static final String COUNT_TYPE_MCODE_SUFFIX = "_mcode_type_count";

	/**
	 * 短信天总发送条数缓存key
	 */
	public static final String MW_SEND_DAY_COUNT = "mw_send_day_count";
	
	/**
	 * 每天短信发送量预警提醒基数
	 */
	public static final int MSG_DAY_WARN_RADIX = 5000;

	/**
	 * 手机号限制1统计缓存key后缀
	 */
	public static final String MCODE_MOB_LIMT_S_SUFFIX = "_mcode_mob_ls_count";

	/**
	 * 手机号限制1最大条数
	 */
	public static final int MCODE_MOB_LIMT_S = 7;

	/**
	 * 手机号限制2统计缓存key后缀
	 */
	public static final String MCODE_MOB_LIMT_A_SUFFIX = "_mcode_mob_la_count";

	/**
	 * 手机号限制1最大条数
	 */
	public static final int MCODE_MOB_LIMT_A = 7;

	/**
	 * ip限制1统计缓存key后缀
	 */
	public static final String MCODE_IP_LIMT_S_SUFFIX = "_mcode_ip_ls_count";

	/**
	 * ip限制1最大条数
	 */
	public static final int MCODE_IP_LIMT_S = 7;

	/**
	 * ip限制2统计缓存key后缀
	 */
	public static final String MCODE_IP_LIMT_A_SUFFIX = "_mcode_ip_la_count";
	/**
	 * ip限制2最大条数
	 */
	public static final int MCODE_IP_LIMT_A = 7;

	/**
	 * 注册短信验证码key后缀
	 */
	public static final String REG_MCODE_SUFFIX = "_reg_mcode";

	/**
	 * 忘记密码修改密钥后缀
	 */
	public static final String FORGET_PWD_SUFFIX = "_forget_pwd";

	/**
	 * 忘记密码短信验证码key后缀
	 */
	public static final String FORGET_MCODE_SUFFIX = "_forget_mcode";

	/**
	 * 登录短信验证码key后缀
	 */
	public static final String LOGIN_MCODE_SUFFIX = "_login_mcode";

	/**
	 * 默认码短信验证码位数
	 */
	public static final int MSG_CODE_SIZE = 6;

	/**
	 * 短信验证码类型-注册
	 */
	public static final int MSG_TYPE_REG = 1;

	/**
	 * 短信验证码类型-忘记密码
	 */
	public static final int MSG_TYPE_FORGET = 2;

	/**
	 * 短信验证码类型-短信登录验证
	 */
	public static final int MSG_TYPE_LOGIN = 3;

	/**
	 * 默认码短信验证码位数
	 */
	public static final int MSG_CODE_FOUR = 4;
	
	/**
	 * 存管开户业务授权码key后缀
	 */
	public static final String BANKDEPOSIT_SRVAUTHCODE_SUFFIX = "_bankdeposit_srvauthcode";

	/**
	 * 用户token缓存前缀
	 */
	public static final String USER_TOKEN_PREFIX = "user_token_";

	/**
	 * 用户appkey缓存前缀
	 */
	public static final String APP_TEY_PREFIX = "app_key_";

	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * ip是否黑名单-否
	 */
	public static final Integer IP_NOTIN_BLACKLIST = 0;

	/**
	 * ip是否黑名单-是
	 */
	public static final Integer IP_IN_BLACKLIST = 1;

	/**
	 * 等级
	 */
	public static final int LEVEL_1 = 1;
	public static final int LEVEL_2 = 2;

	/**
	 * 申请编号缓存时间（1小时） 3*24*60*60
	 */
	public static final int APPLY_NO_CACHESECONDS = 60 * 60;

	/**
	 * 缓存有效时间1天
	 */
	public static final int ONE_DAY_CACHESECONDS = 1*24 * 60 * 60;

	/**
	 * 缓存有效时间2小时
	 */
	public static final int TWO_HOURS_CACHESECONDS = 2 * 60 * 60;

	/**
	 * 缓存有效时间3天
	 */
	public static final int THREE_DAY_CACHESECONDS = 3 * 24 * 60 * 60;
	
	/**
	 * 缓存有效时间3天
	 */
	public static final int SEVEN_DAY_CACHESECONDS = 7 * 24 * 60 * 60;

	/**
	 * 缓存有效时间2分钟
	 */
	public static final int TWO_MINUTES_CACHESECONDS = 2 * 60;
	
	/**
	 * 产品类别
	 */
	public static final String PRODUCT_CATEGORY_LIST_PREFIX = "product:category_";

	public static final String LOAN_PRO_SUFFIX = "_loan_product";
	
	public static final String PRODUCT_LIST_SUFFIX = "_product_list";
	
	public static final String CHANNEL_LIST_SUFFIX = "_loan_channel";
	
	public static final String CHANNEL_STAT_SUFFIX = "_channel_stat";

	/**
	 *  基础注册数
	 */
	public static final int baseRegSum = 5;

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置
	 * 
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}

	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 页面获取常量
	 * 
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	// /**
	// * 获取上传文件的根目录
	// * @return
	// */
	// public static String getUserfilesBaseDir() {
	// String dir = getConfig("userfiles.basedir");
	// if (StringUtils.isBlank(dir)){
	// try {
	// dir = ServletContextFactory.getServletContext().getRealPath("/");
	// } catch (Exception e) {
	// return "";
	// }
	// }
	// if(!dir.endsWith("/")) {
	// dir += "/";
	// }
	// System.out.println("userfiles.basedir: " + dir);
	// return dir;
	// }

	/**
	 * 获取上传文件的根目录
	 * 
	 * @return
	 */
	public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		return dir;
	}

	/**
	 * ftp服务器IP
	 */
	public static String getFTPServer() {
		return getConfig("ftp.server");
	}

	/**
	 * ftp服务器端口
	 */
	public static int getFTPPort() {
		return Integer.parseInt(getConfig("ftp.port"));
	}

	/**
	 * ftp服务器登录名
	 */
	public static String getFTPUsername() {
		return getConfig("ftp.username");
	}

	/**
	 * ftp服务器密码
	 */
	public static String getFTPPwd() {
		return getConfig("ftp.pwd");
	}

	/**
	 * 获取工程路径
	 * 
	 * @return
	 */
	public static String getProjectPath() {
		// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)) {
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null) {
				while (true) {
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()) {
						break;
					}
					if (file.getParentFile() != null) {
						file = file.getParentFile();
					} else {
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
	}

}
