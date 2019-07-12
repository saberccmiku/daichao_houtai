package com.daichao.loans.statistics.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.loans.statistics.dao.StatisticsProductDao;
import com.daichao.loans.statistics.entity.StatisticsProduct;
import com.daichao.loans.statistics.service.StatisticsProductService;
import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;

/**
 * @author yuanxianchu
 * @date 2019-06-01 14:17:51
 */
@Service("statisticsProductService")
public class StatisticsProductServiceImpl implements StatisticsProductService{

//    @Override
//    public PageInfo<StatisticsProduct> selectByPageNumSize(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        return new PageInfo<>(this.selectAll());
//    }
	
	@Autowired
	private StatisticsProductDao statisticsProductDao;
	
    /**
     * 新增
     * @param statisticsProduct
     * @return
     */
	@Override
	public int saveStatisticsProduct(StatisticsProduct statisticsProduct) {
		return statisticsProductDao.save(statisticsProduct);
	}

    @Override
    public int updatePvByProduct(StatisticsProduct statisticsProduct) {
        return statisticsProductDao.update(statisticsProduct);
    }
    
//    @Override
//	public List<StatisticsProduct> selectList(StatisticsProduct entity) {
//		MyExample example = new MyExample(StatisticsProduct.class);
//		Criteria criteria =  example.createCriteria();
//		
//		
//		if(StringUtils.isNotBlank(entity.getProductName())){
//			criteria.andEqualTo("productName",entity.getProductName());
//		}
//		
//		String dateRange = entity.getDateRange();
//        if (StringUtils.isNotBlank(dateRange)) {
//            String[] dates = dateRange.split(" - ");
//            String startDate = dates[0].replaceAll("-", "");
//            String endDate = dates[1].replaceAll("-", "");
//            criteria.andGreaterThanOrEqualTo("statDate", startDate);
//            criteria.andLessThanOrEqualTo("statDate", endDate);
//        }
//        example.setPageNumber(entity.getPageNumber());
//        example.setPageSize(entity.getPageSize());
//        example.setOrderByClause("stat_date desc");
//		return selectByExample(example);
//	}

	@Override
	public Page<StatisticsProduct> listStatisticsProduct(Map<String, Object> params) {
		Query query = new Query(params);
		Page<StatisticsProduct> page = new Page<>(query);
		statisticsProductDao.listForPage(page, query);
		return page;
	}

	@Override
	public StatisticsProduct getStatisticsProductById(Long id) {
		return statisticsProductDao.getObjectById(id);
	}

	@Override
	public int updateStatisticsProduct(StatisticsProduct statisticsProduct) {
		return statisticsProductDao.update(statisticsProduct);
	}

	@Override
	public int batchRemove(Long[] id) {
		return statisticsProductDao.batchRemove(id);
	}
}
