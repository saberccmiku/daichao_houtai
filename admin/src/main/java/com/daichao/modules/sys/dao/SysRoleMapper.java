package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.SysRoleEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 系统角色
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

	/**
	 * 查询用户角色
	 * @param userId
	 * @return
	 */
	List<String> listUserRoles(Long userId);
	
}
