package com.daichao.loans.statistics.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.statistics.entity.StatisticsProduct;

/**
 * @author yuanxianchu
 * @date 2019-06-01 14:17:51
 */
public interface StatisticsProductService {

//    public PageInfo<StatisticsProduct> selectByPageNumSize(int pageNum, int pageSize);
    
    /**
  	 * 分页查询
  	 * @param params
  	 * @return
  	 */
//  	Page<StatisticsProduct> listStatisticsProduct(Map<String, Object> params);
	
    /**
     * 新增
     * @param statisticsProduct
     * @return
     */
	int saveStatisticsProduct(StatisticsProduct statisticsProduct);

    int updatePvByProduct(StatisticsProduct statisticsProduct);
    
//	public List<StatisticsProduct> selectList(StatisticsProduct entity);
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    StatisticsProduct getStatisticsProductById(Long id);

    /**
     * 修改
     * @param statisticsProduct
     * @return
     */
	int updateStatisticsProduct(StatisticsProduct statisticsProduct);

    /**
     * 列表
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
    
    Page<StatisticsProduct> listStatisticsProduct(Map<String, Object> params);

}
