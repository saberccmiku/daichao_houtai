package com.daichao.loans.basic.service;

import org.springframework.stereotype.Service;

import com.daichao.loans.basic.option.BasicBlacklistOP;
import com.daichao.loans.basic.option.SendShortMsgOP;

/**
 * 短信服务
 * @author likang
 * @version 2017-07-15
 */
@Service
public interface ShortMsgService {

    /**
     * 发送短信
     * @param sendShortMsgOP
     * @return
     */
    void sendMsg(SendShortMsgOP sendShortMsgOP);
	
    /**
     * 发送短信验证码
     * @param sendShortMsgOP
     * @return
     */
	String sendMsgCode(SendShortMsgOP sendShortMsgOP);

    /**
     * 保存短信发送日志
     * @param sendShortMsgOP
     * @return
     */
    int saveSmsLog(SendShortMsgOP sendShortMsgOP, String msgVerCode);
    
	/**
	 * ip、手机号是否录入在黑名单表
	 * @param ip
	 * @param mob
	 * @return
	 */
	boolean isInBlackListTab(String ip, String mob);
	
	boolean sendMsgYiMei(String phones, String msg);
	
	/**
	 * 录入在黑名单表
	 * @param BasicBlacklistOP
	 * @return
	 */
	int saveToBlackListTab(BasicBlacklistOP op);
}
