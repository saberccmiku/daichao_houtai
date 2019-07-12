package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.SysRoleMenuEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 系统角色与菜单关系
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	/**
	 * 根据菜单id删除角色与菜单关系
	 * @param id
	 * @return
	 */
	int batchRemoveByMenuId(Long[] id);

	/**
	 * 根据角色id删除角色与菜单关系
	 * @param id
	 * @return
	 */
	int batchRemoveByRoleId(Long[] id);

	/**
	 * 查询角色的菜单集合
	 * @param id
	 * @return
	 */
	List<Long> listMenuId(Long id);
	
}
