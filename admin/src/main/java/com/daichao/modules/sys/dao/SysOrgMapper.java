package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.SysOrgEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 组织架构
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	/**
	 * 统计子机构数量
	 * @param parentId
	 * @return
	 */
	int countOrgChildren(Long parentId);

	/**
	 * 查询子机构集合
	 * @param parentId
	 * @return
	 */
	List<Long> listOrgChildren(Long parentId);
	
}
