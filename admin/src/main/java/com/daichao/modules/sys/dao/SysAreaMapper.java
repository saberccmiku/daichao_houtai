package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.common.entity.Query;
import com.daichao.modules.sys.entity.SysAreaEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 行政区域
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	/**
	 * 根据上级id查询子节点集合
	 * @param query
	 * @return
	 */
	List<SysAreaEntity> listAreaByParentCode(Query query);

	/**
	 * 统计子节点数量
	 * @param areaId
	 * @return
	 */
	int countAreaChildren(Long areaId);
	
}
