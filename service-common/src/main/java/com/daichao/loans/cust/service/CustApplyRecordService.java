package com.daichao.loans.cust.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.cust.entity.CustApplyRecord;

/**
 * @author yuanxianchu
 * @date 2019-06-02 20:22:15
 */
public interface CustApplyRecordService {


    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<CustApplyRecord> listCustApplyRecord(Map<String, Object> params);

    /**
     * 新增
     * @param custApplyRecord
     * @return
     */
	int saveCustApplyRecord(CustApplyRecord custApplyRecord);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	CustApplyRecord getCustApplyRecordById(String id);

    /**
     * 修改
     * @param custApplyRecord
     * @return
     */
	int updateCustApplyRecord(CustApplyRecord custApplyRecord);

}
