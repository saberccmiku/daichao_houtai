package com.daichao.loans.statistics.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.cust.vo.CustUserVO;
import com.daichao.loans.statistics.entity.StatisticsChannel;

/**
 * @author yuanxianchu
 * @date 2019-06-01 13:13:09
 */
public interface StatisticsChannelService {

	/**
	 * 
	* @Title: addPV
	* @Description:增加pv
	* @return int    返回类型
	* @throws
	 */
	int addPV(String channelId, int addCount);
	/**
	 * 
	* @Title: addPV
	* @Description:增加注册数
	* @return int    返回类型
	* @throws
	 */
	int addRegNumber(String channelId, int addCount);
	
	/**
	 * 注册并登陆
	 * @param channelId
	 * @param addCount
	 * @return
	 */
	int addLoginNum(CustUserVO user);
	
//	public List<StatisticsChannel> selectList(StatisticsChannel entity);
	
	  /**
     * 新增
     * @param statisticsChannel
     * @return
     */
	int saveStatisticsChannel(StatisticsChannel statisticsChannel);
	
	 /**
     * 根据id查询
     * @param id
     * @return
     */
	StatisticsChannel getStatisticsChannelById(Long id);
	
	   /**
     * 修改
     * @param statisticsChannel
     * @return
     */
	int updateStatisticsChannel(StatisticsChannel statisticsChannel);
	
	Page<StatisticsChannel> listStatisticsChannel(Map<String, Object> params);

	int batchRemove(Long[] id);
}
