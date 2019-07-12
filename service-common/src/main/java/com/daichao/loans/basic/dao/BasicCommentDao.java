package com.daichao.loans.basic.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.daichao.common.base.BaseMapper;
import com.daichao.loans.basic.entity.BasicComment;

/**
 * 留言反馈
 * @author zcl<yczclcn@163.com>
 */
@MapperScan
public interface BasicCommentDao extends BaseMapper<BasicComment> {
	
}
