package com.daichao.loans.app.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * AppBanner
 * @author zcl<yczclcn@163.com>
 */
public class AppBanner implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 分类编号
	 */
	private String categoryId;
	
	/**
	 * Banner名称
	 */
	private String title;
	
	/**
	 * 图片ID
	 */
	private String imageId;
	
	/**
	 * Banner图片存放地址
	 */
	private String imageUrl;
	
	/**
	 * 顺序
	 */
	private Integer imageOrder;
	
	/**
	 * 链接地址
	 */
	private String href;
	
	/**
	 * 备注信息
	 */
	private String remark;
	
	/**
	 * 创建者
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改者
	 */
	private String updateBy;
	
	/**
	 * 最后修改时间
	 */
	private Date updateTime;
	
	/**
	 * 删除标记：0-正常，1-已经删除
	 */
	private Integer del;
	

	public AppBanner() {
		super();
	}

    /**
     * setter for id
	 * @param id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public String getId() {
		return id;
	}
	
    /**
     * setter for categoryId
	 * @param categoryId
     */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

    /**
     * getter for categoryId
     */
	public String getCategoryId() {
		return categoryId;
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
     * setter for imageId
	 * @param imageId
     */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

    /**
     * getter for imageId
     */
	public String getImageId() {
		return imageId;
	}
	
    /**
     * setter for imageUrl
	 * @param imageUrl
     */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    /**
     * getter for imageUrl
     */
	public String getImageUrl() {
		return imageUrl;
	}
	
    /**
     * setter for imageOrder
	 * @param imageOrder
     */
	public void setImageOrder(Integer imageOrder) {
		this.imageOrder = imageOrder;
	}

    /**
     * getter for imageOrder
     */
	public Integer getImageOrder() {
		return imageOrder;
	}
	
    /**
     * setter for href
	 * @param href
     */
	public void setHref(String href) {
		this.href = href;
	}

    /**
     * getter for href
     */
	public String getHref() {
		return href;
	}
	
    /**
     * setter for remark
	 * @param remark
     */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    /**
     * getter for remark
     */
	public String getRemark() {
		return remark;
	}
	
    /**
     * setter for createBy
	 * @param createBy
     */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

    /**
     * getter for createBy
     */
	public String getCreateBy() {
		return createBy;
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
     * setter for updateBy
	 * @param updateBy
     */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

    /**
     * getter for updateBy
     */
	public String getUpdateBy() {
		return updateBy;
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
