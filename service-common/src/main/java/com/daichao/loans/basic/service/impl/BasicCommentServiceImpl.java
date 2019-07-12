package com.daichao.loans.basic.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.loans.basic.dao.BasicCommentDao;
import com.daichao.loans.basic.entity.BasicComment;
import com.daichao.loans.basic.service.BasicCommentService;

/**
 * @author yuanxianchu
 * @date 2019-06-02 17:44:28
 */
@Service("basicCommentService")
public class BasicCommentServiceImpl implements BasicCommentService{
	
	@Autowired
	private BasicCommentDao basicCommentDao;

	@Override
	public Page<BasicComment> listBasicComment(Map<String, Object> params) {
		Query form = new Query(params);
		Page<BasicComment> page = new Page<>(form);
		basicCommentDao.listForPage(page, form);
		return page;
	}

	@Override
	public int saveBasicComment(BasicComment basicComment) {
		return basicCommentDao.save(basicComment);
	}

	@Override
	public BasicComment getBasicCommentById(Long id) {
		return basicCommentDao.getObjectById(id);
	}

	@Override
	public int updateBasicComment(BasicComment basicComment) {
		return basicCommentDao.update(basicComment);
	}

	@Override
	public int batchRemove(Long[] id) {
		return basicCommentDao.batchRemove(id);
	}
}
