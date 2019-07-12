package com.daichao.loans.cust.service;

import java.util.Map;

import com.daichao.common.entity.Page;
import com.daichao.loans.cust.entity.CustUser;
import com.daichao.loans.cust.option.LoginOP;
import com.daichao.loans.cust.option.RegisterOP;
import com.daichao.loans.cust.option.UpdatePwdOP;
import com.daichao.loans.cust.vo.CustUserVO;

/**
 * 客户信息
 * @author zcl<yczclcn@163.com>
 */
public interface CustUserService {

    /**
     * 通过手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    CustUserVO getCustUserByMobile(String mobile);

    /**
     * 通过用户id获取用户信息
     *
     * @param userId
     * @return
     */
    CustUserVO getCustUserById(String userId);

    /**
     * 保存注册信息
     *
     * @param registerOP
     * @return
     */
    String saveRegister(RegisterOP registerOP);

    /**
     * 更新登录记录
     *
     * @param loginOP
     * @return
     */
    int updateLoginRecord(LoginOP loginOP);

    /**
     * 当前用户是否注册
     *
     * @param mobile
     * @return [true] 已经注册过; [false] 未注册
     */
    boolean isRegister(String mobile);

    /**
     * 忘记密码修改用户密码
     *
     * @param updatePwdOP
     * @return
     */
    int updatePwd(UpdatePwdOP updatePwdOP);
    
//    public List<CustUser> selectList(CustUser entity);
    
    Page<CustUser> selectList(Map<String, Object> params);
    
    CustUser getCustById(String userId);
    
    /**
     * 修改
     * @param custUser
     * @return
     */
	int updateCustUser(CustUser custUser);
	
	int batchRemove(Long[] id);
}