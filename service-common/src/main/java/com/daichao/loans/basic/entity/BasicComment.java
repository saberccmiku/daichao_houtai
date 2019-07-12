package com.daichao.loans.basic.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 留言反馈
 * @author zcl<yczclcn@163.com>
 */
public class BasicComment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 详情
	 */
	private String detail;
	
	/**
	 * 应用ID
	 */
	private Integer appid;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 删除标记
	 */
	private Integer del;
	
    /**
     * setter for id
	 * @param id
     */
	public void setId(Integer id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Integer getId() {
		return id;
	}
	
    /**
     * setter for userId
	 * @param userId
     */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    /**
     * getter for userId
     */
	public Integer getUserId() {
		return userId;
	}
	
    /**
     * setter for title
	 * @param title
     */
	public void setTitle(String title) {
		this.title = title;
	}

    /**
     * getter for title
     */
	public String getTitle() {
		return title;
	}
	
    /**
     * setter for detail
	 * @param detail
     */
	public void setDetail(String detail) {
		this.detail = detail;
	}

    /**
     * getter for detail
     */
	public String getDetail() {
		return detail;
	}
	
    /**
     * setter for appid
	 * @param appid
     */
	public void setAppid(Integer appid) {
		this.appid = appid;
	}

    /**
     * getter for appid
     */
	public Integer getAppid() {
		return appid;
	}
	
    /**
     * setter for createTime
	 * @param createTime
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    /**
     * getter for createTime
     */
	public Date getCreateTime() {
		return createTime;
	}
	
    /**
     * setter for updateTime
	 * @param updateTime
     */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    /**
     * getter for updateTime
     */
	public Date getUpdateTime() {
		return updateTime;
	}
	
    /**
     * setter for del
	 * @param del
     */
	public void setDel(Integer del) {
		this.del = del;
	}

    /**
     * getter for del
     */
	public Integer getDel() {
		return del;
	}
	
}
