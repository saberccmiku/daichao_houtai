package com.daichao.loans.app.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * APP版本升级
 * @author zcl<yczclcn@163.com>
 */
public class AppUpgrade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private String id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 类型：1-ios，2-android
	 */
	private Integer type;
	
	/**
	 * 版本号
	 */
	private String version;
	
	/**
	 * 是否强制升级：0-非强制，1-强制
	 */
	private Integer forced;
	
	/**
	 * 安装包ID
	 */
	private String fileId;
	
	/**
	 * 安装包地址
	 */
	private String pkgUrl;
	
	/**
	 * 状态：0-待发布，1-发布，2-失效
	 */
	private String status;
	
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
	

	public AppUpgrade() {
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
     * setter for name
	 * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * getter for name
     */
	public String getName() {
		return name;
	}
	
    /**
     * setter for type
	 * @param type
     */
	public void setType(Integer type) {
		this.type = type;
	}

    /**
     * getter for type
     */
	public Integer getType() {
		return type;
	}
	
    /**
     * setter for version
	 * @param version
     */
	public void setVersion(String version) {
		this.version = version;
	}

    /**
     * getter for version
     */
	public String getVersion() {
		return version;
	}
	
    /**
     * setter for forced
	 * @param forced
     */
	public void setForced(Integer forced) {
		this.forced = forced;
	}

    /**
     * getter for forced
     */
	public Integer getForced() {
		return forced;
	}
	
    /**
     * setter for fileId
	 * @param fileId
     */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

    /**
     * getter for fileId
     */
	public String getFileId() {
		return fileId;
	}
	
    /**
     * setter for pkgUrl
	 * @param pkgUrl
     */
	public void setPkgUrl(String pkgUrl) {
		this.pkgUrl = pkgUrl;
	}

    /**
     * getter for pkgUrl
     */
	public String getPkgUrl() {
		return pkgUrl;
	}
	
    /**
     * setter for status
	 * @param status
     */
	public void setStatus(String status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public String getStatus() {
		return status;
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
