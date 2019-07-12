package com.daichao.loans.statistics.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.loans.statistics.dao.StatisticsChannelDao;
import com.daichao.loans.statistics.entity.StatisticsChannel;
import com.daichao.loans.statistics.service.StatisticsChannelService;
import com.daichao.loans.channel.dao.LoanChannelDao;
import com.daichao.loans.channel.entity.LoanChannel;
import com.daichao.loans.cust.vo.CustUserVO;
import com.daichao.common.config.Global;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.common.utils.DateUtils;
import com.daichao.common.utils.JedisUtils;

/**
 * @author yuanxianchu
 * @date 2019-06-01 13:13:09
 */
@Service("statisticsChannelService")
public class StatisticsChannelServiceImpl implements StatisticsChannelService {

	@Autowired
	private LoanChannelDao loanChannelDao;
	
	@Autowired
	private StatisticsChannelDao statisticsChannelDao;

	@Override
	public int addPV(String channelId, int addCount) {
		int statDate = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));

		String cacheKey = channelId + "_" + statDate + Global.CHANNEL_STAT_SUFFIX;
		StatisticsChannel statisticsChannel = (StatisticsChannel) JedisUtils.getObject(cacheKey);
		if(null == statisticsChannel) {
			StatisticsChannel statChannel = new StatisticsChannel();
			statChannel.setChannelId(channelId);
			statChannel.setStatDate(statDate);
			statisticsChannel = statisticsChannelDao.getObject(statChannel);
		}

		if (statisticsChannel == null) {
			statisticsChannel = new StatisticsChannel();
			statisticsChannel.setChannelId(channelId);

			String channelCacheKey = channelId + Global.CHANNEL_LIST_SUFFIX;
			LoanChannel loanChannel = (LoanChannel)JedisUtils.getObject(channelCacheKey);
	        if (loanChannel == null){
	        	loanChannel = loanChannelDao.getObjectById(channelId);
	        	if(null == loanChannel) {
	        		return 0;
	        	}
	            // 结果保存到缓存
	            JedisUtils.setObject(channelCacheKey, loanChannel, Global.THREE_DAY_CACHESECONDS);
	        }
	        
//			statisticsChannel.setChannelCode(loanChannel.getChannelCode());
			statisticsChannel.setChannelName((loanChannel != null) ? loanChannel.getChannelName() : "");
			statisticsChannel.setChannelPv(0);
			statisticsChannel.setStatDate(statDate);
			statisticsChannel.setRealRegNumber(0);
			statisticsChannel.setRegBase(0);
			statisticsChannel.setLoginNum(0);
			statisticsChannel.setDiscount((null != loanChannel.getDiscount())? loanChannel.getDiscount().doubleValue() : 0.0);
			statisticsChannel.setCompanyId(loanChannel.getCompanyId());
			statisticsChannel.setStatus(1);
			statisticsChannel.setDel(Global.NO);
			statisticsChannel.setCreateTime(new Date());
		}

		statisticsChannel.setChannelPv(statisticsChannel.getChannelPv() + addCount);
		
		int result = 0;
		if (statisticsChannel.getId() == null) {
			result = statisticsChannelDao.save(statisticsChannel);
		} else {
			result = statisticsChannelDao.update(statisticsChannel);
		}
		// 结果保存到缓存
		JedisUtils.setObject(cacheKey, statisticsChannel, Global.ONE_DAY_CACHESECONDS);
		return result;
	}

	@Override
	public int addRegNumber(String channelId, int addCount) {
		int statDate = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));

		String cacheKey = channelId + "_" + statDate + Global.CHANNEL_STAT_SUFFIX;
		StatisticsChannel statisticsChannel = (StatisticsChannel) JedisUtils.getObject(cacheKey);
		if(null == statisticsChannel) {
			StatisticsChannel statChannel = new StatisticsChannel();
			statChannel.setChannelId(channelId);
			statChannel.setStatDate(statDate);
			statisticsChannel = statisticsChannelDao.getObject(statChannel);
		}
		if(statisticsChannel == null) {
			// 当日首次
			String channelCacheKey = channelId + Global.CHANNEL_LIST_SUFFIX;
			LoanChannel loanChannel = (LoanChannel)JedisUtils.getObject(channelCacheKey);
			if (loanChannel == null){
				loanChannel = loanChannelDao.getObjectById(channelId);
				if(null == loanChannel) {
					return 0;
				}
				// 结果保存到缓存
				JedisUtils.setObject(channelCacheKey, loanChannel, Global.THREE_DAY_CACHESECONDS);
			}
			
			statisticsChannel = new StatisticsChannel();
			statisticsChannel.setChannelId(channelId);

//			statisticsChannel.setChannelCode(loanChannel.getChannelCode());
			statisticsChannel.setChannelName((loanChannel != null) ? loanChannel.getChannelName() : "");
			statisticsChannel.setChannelPv(0);
			statisticsChannel.setStatDate(statDate);
			statisticsChannel.setRealRegNumber(0);
			statisticsChannel.setRegBase(0);
			statisticsChannel.setLoginNum(0);
			statisticsChannel.setDiscount((null != loanChannel.getDiscount())? loanChannel.getDiscount().doubleValue() : 0.0);
			statisticsChannel.setCompanyId(loanChannel.getCompanyId());
			statisticsChannel.setStatus(0);
			statisticsChannel.setDel(Global.NO);
			statisticsChannel.setCreateTime(new Date());
		} 
		
		int currentRegSum = statisticsChannel.getRealRegNumber() + addCount; //实际注册数
		int currentShowReg = statisticsChannel.getRegBase(); //当前显示数
		int baseSum = Global.baseRegSum;
		int showReg = currentShowReg+ addCount;
		
		// 前10不discount
		if(null != statisticsChannel.getDiscount() && statisticsChannel.getDiscount().doubleValue() > 0 && currentRegSum > baseSum) {
			int discSum = Double.valueOf(Math.ceil(currentRegSum * statisticsChannel.getDiscount())).intValue(); //向上取整
			if(discSum <= baseSum) {
				showReg = baseSum;
			} 
//			else if(discSum < currentShowReg) {
//				showReg = currentShowReg;
//			} 
			else {
				showReg = discSum;
			}
		}
		statisticsChannel.setRegBase(showReg);
		statisticsChannel.setRealRegNumber(currentRegSum);

		int result = 0;
		if (statisticsChannel.getId() == null) {
			result = statisticsChannelDao.save(statisticsChannel);
		} else {
			result = statisticsChannelDao.update(statisticsChannel);
		}
		// 结果保存到缓存
		JedisUtils.setObject(cacheKey, statisticsChannel, Global.THREE_DAY_CACHESECONDS);
		return result;
		
	}

	@Override
	public int addLoginNum(CustUserVO user) {
		int statDate = Integer.parseInt(DateUtils.format(new Date(), "yyyyMMdd"));
		int regDate = Integer.parseInt(DateUtils.format(user.getRegisterTime(), "yyyyMMdd"));
		// 判断是否是当天注册当天登陆、是否同一渠道
		if(statDate != regDate) {
			return 0;
		}
		String channelId = user.getChannel();
		String cacheKey = channelId + "_" + statDate + Global.CHANNEL_STAT_SUFFIX;
		StatisticsChannel statisticsChannel = (StatisticsChannel) JedisUtils.getObject(cacheKey);
		if(null == statisticsChannel) {
			StatisticsChannel statChannel = new StatisticsChannel();
			statChannel.setChannelId(channelId);
			statChannel.setStatDate(statDate);
			statisticsChannel = statisticsChannelDao.getObject(statChannel);
		}
		
		if (statisticsChannel == null) {
			String chanllenCacheKey = channelId + Global.CHANNEL_LIST_SUFFIX;
			LoanChannel loanChannel = (LoanChannel)JedisUtils.getObject(chanllenCacheKey);
			if (loanChannel == null){
				loanChannel = loanChannelDao.getObjectById(channelId);
				if(null == loanChannel) {
					return 0;
				}
				// 结果保存到缓存
				JedisUtils.setObject(chanllenCacheKey, loanChannel, Global.ONE_DAY_CACHESECONDS);
			}
			
			statisticsChannel = new StatisticsChannel();
			statisticsChannel.setChannelId(channelId);
			
//			statisticsChannel.setChannelCode(loanChannel.getChannelCode());
			statisticsChannel.setChannelName((loanChannel != null) ? loanChannel.getChannelName() : "");
			statisticsChannel.setChannelPv(0);
			statisticsChannel.setStatDate(statDate);
			statisticsChannel.setRealRegNumber(0);
			statisticsChannel.setRegBase(0);
			statisticsChannel.setLoginNum(0);
			statisticsChannel.setDiscount((null != loanChannel.getDiscount())? loanChannel.getDiscount().doubleValue() : 0.0);
			statisticsChannel.setCompanyId(loanChannel.getCompanyId());
			statisticsChannel.setStatus(0);
			statisticsChannel.setDel(Global.NO);
			statisticsChannel.setCreateTime(new Date());
		}
		
		int currentRegSum = statisticsChannel.getLoginNum() + 1; //实际登陆数
		int currentShowReg = statisticsChannel.getRegBase(); //当前显示数
		int baseSum = Global.baseRegSum;
		int showReg = currentShowReg+ 1;
		
		// 前10不discount
		if(null != statisticsChannel.getDiscount() && statisticsChannel.getDiscount().doubleValue() > 0 && currentRegSum > baseSum) {
			int discSum = Double.valueOf(Math.ceil(currentRegSum * statisticsChannel.getDiscount())).intValue(); //向上取整
			if(discSum <= baseSum) {
				showReg = baseSum;
			} 
//			else if(discSum < currentShowReg) {
//				showReg = currentShowReg;
//			} 
			else {
				showReg = discSum;
			}
		}
		
		if(currentRegSum < showReg || showReg <= baseSum || statisticsChannel.getDiscount() == 0) {
			showReg = currentShowReg;
		}
		// 折扣等于0, 登陆数小于显示注册数, 则该值就不变
		statisticsChannel.setRegBase(showReg);
		statisticsChannel.setLoginNum(currentRegSum);

		int result = 0;
		if (statisticsChannel.getId() == null) {
			result = statisticsChannelDao.save(statisticsChannel);
		} else {
			result = statisticsChannelDao.update(statisticsChannel);
		}
		// 结果保存到缓存
		JedisUtils.setObject(cacheKey, statisticsChannel, Global.ONE_DAY_CACHESECONDS);
		return result;
	}
	
    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<StatisticsChannel> listStatisticsChannel(Map<String, Object> params) {
		Query query = new Query(params);
		Page<StatisticsChannel> page = new Page<>(query);
		statisticsChannelDao.listForPage(page, query);
		return page;
	}
	
	   /**
     * 新增
     * @param statisticsChannel
     * @return
     */
	@Override
	public int saveStatisticsChannel(StatisticsChannel statisticsChannel) {
		return statisticsChannelDao.save(statisticsChannel);
	}

	@Override
	public StatisticsChannel getStatisticsChannelById(Long id) {
		return statisticsChannelDao.getObjectById(id);
	}
	
	 /**
     * 修改
     * @param statisticsChannel
     * @return
     */
	@Override
	public int updateStatisticsChannel(StatisticsChannel statisticsChannel) {
		return statisticsChannelDao.update(statisticsChannel);
	}
	
	@Override
	public int batchRemove(Long[] id) {
		return statisticsChannelDao.batchRemove(id);
	}

}
