package com.daichao.modules.sys.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.modules.sys.entity.GeneratorParamEntity;
import com.daichao.modules.sys.entity.TableEntity;

/**
 * 代码生成器
 * @author zcl<yczclcn@163.com>
 */
public interface SysGeneratorService {

	/**
	 * 分页查询表格
	 * @param params
	 * @return
	 */
	Page<TableEntity> listTable(Map<String, Object> params);

	/**
	 * 生成代码
	 * @param params
	 * @return
	 */
	byte[] generator(GeneratorParamEntity params);
	
}
