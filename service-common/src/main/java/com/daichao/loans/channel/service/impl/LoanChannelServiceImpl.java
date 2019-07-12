package com.daichao.loans.channel.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.loans.channel.dao.LoanChannelDao;
import com.daichao.loans.channel.entity.LoanChannel;
import com.daichao.loans.channel.service.LoanChannelService;

/**
 * 渠道信息
 * @author zcl<yczclcn@163.com>
 */
@Service("loanChannelService")
public class LoanChannelServiceImpl implements LoanChannelService {

	@Autowired
	private LoanChannelDao loanChannelDao;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<LoanChannel> listLoanChannel(Map<String, Object> params) {
		Query query = new Query(params);
		Page<LoanChannel> page = new Page<>(query);
		loanChannelDao.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param loanChannel
     * @return
     */
	@Override
	public int saveLoanChannel(LoanChannel loanChannel) {
		int count = loanChannelDao.save(loanChannel);
		return count;
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public LoanChannel getLoanChannelById(Long id) {
		LoanChannel loanChannel = loanChannelDao.getObjectById(id);
		return loanChannel;
	}

    /**
     * 修改
     * @param loanChannel
     * @return
     */
	@Override
	public int updateLoanChannel(LoanChannel loanChannel) {
		int count = loanChannelDao.update(loanChannel);
		return count;
	}

    /**
     * 列表
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		int count = loanChannelDao.batchRemove(id);
		return count;
	}
	
	@Override
	public List<LoanChannel> getChannelList(Map<String, Object> params) {
		Query query = new Query(params);
		return loanChannelDao.list(query);
	}
}
