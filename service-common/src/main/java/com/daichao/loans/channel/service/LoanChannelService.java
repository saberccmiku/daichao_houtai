package com.daichao.loans.channel.service;

import java.util.List;
import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.channel.entity.LoanChannel;

/**
 * 渠道信息
 * @author zcl<yczclcn@163.com>
 */
public interface LoanChannelService {

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<LoanChannel> listLoanChannel(Map<String, Object> params);

    /**
     * 新增
     * @param loanChannel
     * @return
     */
	int saveLoanChannel(LoanChannel loanChannel);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	LoanChannel getLoanChannelById(Long id);

    /**
     * 修改
     * @param loanChannel
     * @return
     */
	int updateLoanChannel(LoanChannel loanChannel);

    /**
     * 列表
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
	List<LoanChannel> getChannelList(Map<String, Object> params);
}
