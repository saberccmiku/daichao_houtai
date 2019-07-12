package com.daichao.loans.statistics.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 产品统计
 * @author zcl<yczclcn@163.com>
 */
public class StatisticsProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 统计日期YYYYMMDD
	 */
	private Integer statDate;
	
	/**
	 * 产品id
	 */
	private Integer productId;
	
	/**
	 * 产品编码
	 */
	private String productCode;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品公司id
	 */
	private String companyId;
	
	/**
	 * 游客点击数
	 */
	private Integer touristPv;
	
	/**
	 * 游客申请数
	 */
	private Integer touristUv;
	
	/**
	 * 用户点击数
	 */
	private Integer userPv;
	
	/**
	 * 用户申请数
	 */
	private Integer userUv;
	
	/**
	 * 产品注册数/产品返数
	 */
	private Integer regNum;
	
	/**
	 * 状态(0-不可用，1-可用)
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
	

	public StatisticsProduct() {
		super();
	}

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
     * setter for statDate
	 * @param statDate
     */
	public void setStatDate(Integer statDate) {
		this.statDate = statDate;
	}

    /**
     * getter for statDate
     */
	public Integer getStatDate() {
		return statDate;
	}
	
    /**
     * setter for productId
	 * @param productId
     */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

    /**
     * getter for productId
     */
	public Integer getProductId() {
		return productId;
	}
	
    /**
     * setter for productCode
	 * @param productCode
     */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

    /**
     * getter for productCode
     */
	public String getProductCode() {
		return productCode;
	}
	
    /**
     * setter for productName
	 * @param productName
     */
	public void setProductName(String productName) {
		this.productName = productName;
	}

    /**
     * getter for productName
     */
	public String getProductName() {
		return productName;
	}
	
    /**
     * setter for companyId
	 * @param companyId
     */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

    /**
     * getter for companyId
     */
	public String getCompanyId() {
		return companyId;
	}
	
    /**
     * setter for touristPv
	 * @param touristPv
     */
	public void setTouristPv(Integer touristPv) {
		this.touristPv = touristPv;
	}

    /**
     * getter for touristPv
     */
	public Integer getTouristPv() {
		return touristPv;
	}
	
    /**
     * setter for touristUv
	 * @param touristUv
     */
	public void setTouristUv(Integer touristUv) {
		this.touristUv = touristUv;
	}

    /**
     * getter for touristUv
     */
	public Integer getTouristUv() {
		return touristUv;
	}
	
    /**
     * setter for userPv
	 * @param userPv
     */
	public void setUserPv(Integer userPv) {
		this.userPv = userPv;
	}

    /**
     * getter for userPv
     */
	public Integer getUserPv() {
		return userPv;
	}
	
    /**
     * setter for userUv
	 * @param userUv
     */
	public void setUserUv(Integer userUv) {
		this.userUv = userUv;
	}

    /**
     * getter for userUv
     */
	public Integer getUserUv() {
		return userUv;
	}
	
    /**
     * setter for regNum
	 * @param regNum
     */
	public void setRegNum(Integer regNum) {
		this.regNum = regNum;
	}

    /**
     * getter for regNum
     */
	public Integer getRegNum() {
		return regNum;
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
