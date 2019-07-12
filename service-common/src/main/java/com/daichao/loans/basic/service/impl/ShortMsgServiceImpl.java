package com.daichao.loans.basic.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.loans.basic.dao.BasicBlacklistDao;
import com.daichao.loans.basic.dao.BasicSmsLogDao;
import com.daichao.common.config.Global;
import com.daichao.common.config.ShortMsgTemplate;
import com.daichao.common.enums.AppEnum;
import com.daichao.common.utils.DateUtils;
import com.daichao.common.utils.IdGen;
import com.daichao.common.utils.JedisUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.basic.entity.BasicBlacklist;
import com.daichao.loans.basic.entity.BasicSmsLog;
import com.daichao.loans.basic.option.BasicBlacklistOP;
import com.daichao.loans.basic.option.SendShortMsgOP;
import com.daichao.loans.basic.service.ShortMsgService;
import com.daichao.loans.basic.sms.Example;

@Service("shortMsgService")
public class ShortMsgServiceImpl implements ShortMsgService {
	
	/**
	 * 日志对象
	 */
	public Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BasicSmsLogDao basicSmsLogDao;

	@Autowired
	private BasicBlacklistDao basicBlacklistDao;

	@Override
	public void sendMsg(SendShortMsgOP sendShortMsgOP) {
		if (null == sendShortMsgOP) {
			logger.error("the param sendShortMsgOP is null");
			return;
		}
		try {
			send(sendShortMsgOP.getMobile(), sendShortMsgOP.getMessage(), sendShortMsgOP.getChannelId());
			// 保存短信记录
			saveSmsLog(sendShortMsgOP, null);

		} catch (Exception e) {
			logger.error("短信发送失败", e);
		}

	}

	@Override
	public String sendMsgCode(SendShortMsgOP sendShortMsgOP) {
		if (null == sendShortMsgOP) {
			logger.error("the param sendShortMsgOP is null");
			return null;
		}
		String msgVerCode = IdGen.genMsgCodeFour();
		String message = null;
		String mobile = sendShortMsgOP.getMobile();
		if (null != sendShortMsgOP.getMsgType()) {
			message = getMessageFromType(sendShortMsgOP.getMsgType(), msgVerCode);
		}
		if (null == message) {
			message = sendShortMsgOP.getMessage();
		} else {
			sendShortMsgOP.setMessage(message);
		}
		try {
			/** 发短信 */
			send(mobile, message, sendShortMsgOP.getChannelId());
			/** 保存短信记录 */
			saveSmsLog(sendShortMsgOP, msgVerCode);
			/** 当天发送条数统计缓存 以及 预警 */
			// statisticsAndWarn();

		} catch (Exception e) {
			logger.error("短信发送失败", e);
		}
		return msgVerCode;
	}

	/**
	 * 当天发送条数统计缓存 以及 预警
	 */
	private void statisticsAndWarn() {
		Integer count = (Integer) JedisUtils.getObject(Global.MW_SEND_DAY_COUNT);
		// 更新缓存中统计数
		if (null == count) {
			count = 1;
		} else {
			count++;
		}
		JedisUtils.setObject(Global.MW_SEND_DAY_COUNT, count, Global.ONE_DAY_CACHESECONDS);
		if (count % Global.MSG_DAY_WARN_RADIX == 0) {
			String mob = Global.getConfig("msg.warn.mobs");
			try {
				send(mob, ShortMsgTemplate.MSG_COUNT_WARN, null);
			} catch (Exception e) {
				logger.debug("短信发送量预警短信发送异常");
			}
		}
	}

	/**
	 * 根据信息类型获取短信信息
	 *
	 * @param msgType
	 * @param msgVerCode
	 * @return
	 */
	private String getMessageFromType(Integer msgType, String msgVerCode) {
		String rz = null;
		switch (msgType) {
		case 1: // 注册短信验证码
			rz = assembleMessage(ShortMsgTemplate.MSG_TEMP_REG, msgVerCode);
			break;
		case 2: // 忘记密码短信验证码
			rz = assembleMessage(ShortMsgTemplate.MSG_TEMP_FIND_PWD, msgVerCode);
			break;
		case 3: // 短信登录密码
			rz = assembleMessage(ShortMsgTemplate.MSG_TEMP_LOGIN, msgVerCode);
			break;
		default:
			logger.warn("请输入有效的短信验证类型");
			return null;
		}
		return rz;
	}

	/**
	 * 拼装短信信息
	 *
	 * @param msg
	 * @param msgVerCode
	 * @return
	 */
	private String assembleMessage(String msg, String msgVerCode) {
		if (StringUtils.isNotBlank(msg)) {
			msg = msg.replaceFirst(ShortMsgTemplate.REPLACE_CODE, msgVerCode);
		}
		return msg;
	}

	/**
	 * 保存短信发送日志
	 *
	 * @param sendShortMsgOP
	 * @return
	 */
	public int saveSmsLog(SendShortMsgOP sendShortMsgOP, String msgVerCode) {
		if (null != sendShortMsgOP) {
			BasicSmsLog smsLog = new BasicSmsLog();
			smsLog.setSmsCode(msgVerCode);
			smsLog.setIp(sendShortMsgOP.getIp());
			smsLog.setContent(sendShortMsgOP.getMessage());
			smsLog.setMobile(sendShortMsgOP.getMobile());
			if (sendShortMsgOP.getMsgType() != null) {
				smsLog.setType(String.valueOf(sendShortMsgOP.getMsgType()));
			}
			smsLog.setUserId(sendShortMsgOP.getUserId());
			smsLog.setSendTime(new Date());
			smsLog.setSource(sendShortMsgOP.getSource());
			smsLog.setStatus(1);
			smsLog.setChannelCode(sendShortMsgOP.getProductId());
			smsLog.setChannelName(sendShortMsgOP.getChannelName());
			smsLog.setRemark(sendShortMsgOP.getRemark());
			smsLog.setId(IdGen.uuid());
			smsLog.setCreateTime(new Date());
			smsLog.setUpdateTime(new Date());
			return basicSmsLogDao.save(smsLog);
		}
		return 0;
	}

	/**
	 * 生成20位流水号
	 *
	 * @return 20位流水号，YYYYMMddHHmmss（14位）+随机数（6位）
	 */
	private String genSeqNo() {
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
		String rdmNo = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(0, 1000000)), 6,
				'0');
		return dateFormat.format(new Date()) + rdmNo;
	}

	private String send(String phone, String message, String channelId) throws Exception {
		/*
		 * switch (channelId) { case "1": // 注册短信验证码 message = "【乐享用】" + message; break;
		 * default: message = "【域新网络】" + message; return null; }
		 */
		
		String name = AppEnum.getName(channelId);
		if(StringUtils.isNotBlank(name)) {
			message = "【" + name + "】" + message;
		} else {
			message = "【乐享用】" + message;
		}
		
		sendMsgYiMei(phone, message);
		return null;
	}

	@Override
	public boolean isInBlackListTab(String ip, String mob) {
		// 初始化返回值
		boolean rz = false;
		if (StringUtils.isNotBlank(mob)) {
			// 判断手机号是否在黑名单中
			rz = isInBlacklist(mob);
			// 手机号不在黑名单中，再判断ip是否在黑名单中
			if (!rz) {
				if (StringUtils.isNotBlank(ip)) {
					// 判断ip是否在黑名单中
					return isInBlacklist(ip);
				}
			}
		}
		return rz;
	}
	
	public boolean isInBlacklist(String value) {
		return basicBlacklistDao.countByBlValue(value) > 0;
	}
	
	@Override
	public int saveToBlackListTab(BasicBlacklistOP op) {
		// 参数判断
		if (null == op) {
			logger.error("the param op is null");
			return 0;
		}
		// 构造接口参数对象
		BasicBlacklist entity = new BasicBlacklist();
		entity.setBlType(op.getBlType());
		entity.setBlValue(op.getBlValue());
		entity.setChannel(op.getChannel());
		entity.setBlDate(DateUtils.getDate());
		entity.setId(IdGen.uuid());
		entity.setCreateTime(new Date());
		return basicBlacklistDao.save(entity);
	}

	@Override
	public boolean sendMsgYiMei(String phones, String msg) {
		String appId = Global.YIMEI_APP_ID;// 请联系销售，或者在页面中 获取
		// 密钥
		String secretKey = Global.YIMEI_KEY;// 请联系销售，或者在页面中 获取
		// 接口地址
		String host = Global.YIMEI_URL;// 请联系销售获取
		// 加密算法
		String algorithm = "AES/ECB/PKCS5Padding";
		// 编码
		String encode = "UTF-8";
		// 是否压缩
		boolean isGizp = true;
		// 发送单条短信
		Example.setSingleSms(appId, secretKey, host, algorithm, msg, null, null, phones, isGizp, encode);
		
		return true;
	}
}
