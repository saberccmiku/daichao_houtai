package com.daichao.loans.mq.loanApi;

import com.daichao.common.config.BaiduMap;
import com.daichao.common.config.Global;
import com.daichao.common.mapper.BeanMapper;
import com.daichao.common.mapper.JsonMapper;
import com.daichao.common.utils.IdGen;
import com.daichao.common.utils.JedisUtils;
import com.daichao.common.utils.StringUtils;
import com.daichao.loans.app.dao.AppAccessLogDao;
import com.daichao.loans.app.entity.AppAccessLog;
import com.daichao.loans.app.vo.AccessLogOP;
import com.daichao.loans.cust.entity.CustLoginLog;
import com.daichao.loans.cust.service.CustLoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;


/**
 * api端访问日志
 * @author likang
 */
@Component("accessLogExecuter")
public class AccessLogExecuter {

    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    // 缓存时间20秒
  	private static final int CACHESECONDS = 20;
  	// 分布式锁前缀
  	private static final String LOCK_PREFIX = "lock_";
    // 锁状态
   	private static final String LOCK = "lock";
    
	/**
 	* APP访问日志-实体管理接口
 	*/
	@Autowired
	private AppAccessLogDao accessLogDao;
	
	@Autowired
	private CustLoginLogService custLoginLogService;
	
    public void execute(Message message){
    	// 构造参数对象
    	AppAccessLog accessLog = new AppAccessLog();
		try {
			String body = new String(message.getBody(),"UTF-8");
			// 对象转换
	        accessLog = getAccessLog(body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        if(null != accessLog) {
	        // 数据入库
	        accessLog.setRemark(" ");
	        accessLog.setId(IdGen.uuid());
	        accessLog.setCreateTime(new Date());
        	accessLogDao.save(accessLog);
        	if(StringUtils.isNotBlank(accessLog.getUserId())) {
        		// 保存鉴权登陆日志
        		CustLoginLog entity = new CustLoginLog();
        		entity.setUserId(accessLog.getUserId());
        		entity.setLoginIp(accessLog.getIp());
        		entity.setSource(StringUtils.isNotBlank(accessLog.getSource()) ? Integer.valueOf(accessLog.getSource()) : null);
        		entity.setLoginTime(new Date());
        		custLoginLogService.saveLoginLog(entity);
        	}
        }
        // ip处理逻辑 TODO
//        if(StringUtils.isNotBlank(accessLog.getIp())) {
//        	ipLocation(accessLog.getIp());
//        }
    }
    
    /**
     * json转换AccessLog对象
     * @param body
     * @return
     * @throws UnsupportedEncodingException 
     */
    private AppAccessLog getAccessLog(String body) 
    		throws UnsupportedEncodingException{
    	if(StringUtils.isBlank(body)) {
    		logger.error("消息解析异常，the body is null");
    		return null;
    	}
    	if(logger.isDebugEnabled()) {
    		logger.debug("消费消息内容:[{}]",
    				URLDecoder.decode(body, "UTF-8"));
    	}
        try {       	
        	AccessLogOP accessLogOP = 
        			JsonMapper.getInstance().fromJson(
        					body, AccessLogOP.class);
        	AppAccessLog accessLog = 
        			BeanMapper.map(accessLogOP, AppAccessLog.class);
            return accessLog;
        } catch (Exception e){
            logger.error("消息解析异常, body:[{}]", 
            		URLDecoder.decode(body, "UTF-8"));
            return null;
        }
    }
}
