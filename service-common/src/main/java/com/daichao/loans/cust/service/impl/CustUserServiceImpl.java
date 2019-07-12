package com.daichao.loans.cust.service.impl;

import com.daichao.common.entity.Page;
import com.daichao.common.entity.Query;
import com.daichao.common.enums.SourceEnum;
import com.daichao.common.mapper.BeanMapper;
import com.daichao.loans.cust.dao.CustUserDao;
import com.daichao.loans.cust.entity.CustUser;
import com.daichao.loans.cust.option.LoginOP;
import com.daichao.loans.cust.option.RegisterOP;
import com.daichao.loans.cust.option.UpdatePwdOP;
import com.daichao.loans.cust.service.CustUserService;
import com.daichao.loans.cust.vo.CustUserVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author yuanxianchu
 * @date 2019-06-01 13:40:55
 */
@Service("custUserService")
public class CustUserServiceImpl implements CustUserService {
	
	@Autowired
	private CustUserDao custUserDao;

	@Override
	public CustUserVO getCustUserByMobile(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return null;
		}
		CustUser custUser = new CustUser();
		custUser.setMobile(mobile);
		custUser = custUserDao.getObject(custUser);
		
		if (custUser == null) {
			return null;
		}
		return BeanMapper.map(custUser, CustUserVO.class);
	}

	@Override
	public CustUserVO getCustUserById(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		CustUser custUser = custUserDao.getObjectById(userId);
		if (custUser == null) {
			return null;
		}
		return BeanMapper.map(custUser, CustUserVO.class);
	}

	@Override
	public String saveRegister(RegisterOP registerOP) {
		if (null == registerOP) {
			return "0";
		}
		CustUser user = new CustUser();
		// 用户手机号
		user.setMobile(registerOP.getAccount());
		// 用户密码
		user.setPassword(registerOP.getPassword());
		// 注册时间
		Date currentDate = new Date();
		//user.setLoginTime(currentDate);
		user.setRegisterTime(currentDate);
		user.setRegIp(registerOP.getIp());
		if("1".equals(registerOP.getSource()) || "2".equals(registerOP.getSource())) {
			// 当前登录ip
			user.setLoginIp(registerOP.getIp());
			user.setLoginTime(new Date());
			user.setLoginSource(StringUtils.isNotBlank(registerOP.getSource()) ? Integer.valueOf(registerOP.getSource()) :null);
			user.setUpdateTime(new Date());
		}
		// 邀请码
		user.setInviteCode(registerOP.getInviteCode());

		// 来源 (1-ios，2-android，3-H5，4-api，5-网站，6-system)
		if (StringUtils.isBlank(registerOP.getSource())) {
			user.setSource(SourceEnum.ANDROID.getValue());
		} else {
			try {
				Integer source = Integer.valueOf(registerOP.getSource());
				user.setSource(source);
			} catch (Exception e) {
				user.setSource(SourceEnum.ANDROID.getValue());
			}
		}
		user.setChannel(registerOP.getChannel());
		user.setTerminal(registerOP.getTerminal());
		user.setAppId(registerOP.getAppId());

		if (StringUtils.isNotBlank(registerOP.getRealName())) {
			user.setRealName(registerOP.getRealName());
		}
		user.setCreateTime(new Date());
		// 数据有效性状态 默认有效
		user.setStatus(1);
		int rz = custUserDao.save(user);

		if (rz == 1) {
			return user.getId().toString();
		}
		return "0";
	}

	@Override
	public int updateLoginRecord(LoginOP loginOP) {
		if (null == loginOP) {
			return 0;
		}
		Date loginTime = new Date();
		CustUser entity = new CustUser();
		entity.setMobile(loginOP.getAccount());
		entity.setLastLoginIp(loginOP.getLastIp());
		entity.setLoginIp(loginOP.getCurrentIp());
		entity.setLastLoginTime(loginOP.getLastLoginTime());
		entity.setLoginNum(loginOP.getLoginNum());
		entity.setLoginTime(loginTime);
		entity.setLoginSource(StringUtils.isNotBlank(loginOP.getSource()) ? Integer.valueOf(loginOP.getSource()) :null);
		entity.setUpdateTime(new Date());
		return custUserDao.update(entity);
	}

	@Override
	public boolean isRegister(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}
		Query query = new Query();
		query.put("mobile", mobile);
		return custUserDao.countTotal(query) > 0;
	}

	@Override
	public int updatePwd(UpdatePwdOP updatePwdOP) {
		if (null == updatePwdOP || StringUtils.isBlank(updatePwdOP.getAccount())
				|| StringUtils.isBlank(updatePwdOP.getPassword())) {
			return 0;
		} else {
			updatePwdOP.setUpdateTime(new Date());
			return custUserDao.updatePwd(updatePwdOP);
		}
	}
	
	@Override
	public Page<CustUser> selectList(Map<String, Object> params) {
		Query form = new Query(params);
		Page<CustUser> page = new Page<>(form);
		custUserDao.listForPage(page, form);
		return page;
	}

	@Override
	public CustUser getCustById(String userId) {
		return custUserDao.getObjectById(userId);
	}
	
    /**
     * 修改
     * @param custUser
     * @return
     */
	@Override
	public int updateCustUser(CustUser custUser) {
		return custUserDao.update(custUser);
	}
	
	@Override
	public int batchRemove(Long[] id) {
		return custUserDao.batchRemove(id);
	}
}
