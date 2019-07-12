package com.daichao.modules.sys.dao;

import com.daichao.common.base.BaseMapper;
import com.daichao.modules.sys.entity.SysMenuEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 系统菜单dao
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

	/**
	 * 查询子菜单id集合
	 * @param parentId
	 * @return
	 */
	List<SysMenuEntity> listParentId(Long parentId);

	/**
	 * 查询目录和菜单集合
	 * @return
	 */
	List<SysMenuEntity> listNotButton();

	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	List<String> listUserPerms(Long userId);

	/**
	 * 统计子菜单数量
	 * @param parentId
	 * @return
	 */
	int countMenuChildren(Long parentId);

}
