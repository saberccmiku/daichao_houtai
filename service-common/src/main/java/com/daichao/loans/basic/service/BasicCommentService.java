package com.daichao.loans.basic.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.basic.entity.BasicComment;

/**
 * 留言反馈
 * @author zcl<yczclcn@163.com>
 */
public interface BasicCommentService {

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	Page<BasicComment> listBasicComment(Map<String, Object> params);

    /**
     * 新增
     * @param basicComment
     * @return
     */
	int saveBasicComment(BasicComment basicComment);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	BasicComment getBasicCommentById(Long id);

    /**
     * 修改
     * @param basicComment
     * @return
     */
	int updateBasicComment(BasicComment basicComment);

	 /**
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
}
