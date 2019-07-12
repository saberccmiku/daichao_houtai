package com.daichao.loans.channel.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 渠道公司
 * @author zcl<yczclcn@163.com>
 */
public class LoanChannelCompany implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 渠道公司ID
	 */
	private Integer id;
	
	/**
	 * 渠道公司编码
	 */
	private String companyCode;
	
	/**
	 * 渠道公司名称
	 */
	private String companyName;
	
	/**
	 * 公司类型
	 */
	private String type;
	
	/**
	 * 单价
	 */
	private BigDecimal price;
	
	/**
	 * 联系人姓名
	 */
	private String contactName;
	
	/**
	 * 联系人手机号
	 */
	private String contactPhone;
	
	/**
	 * 联系地址
	 */
	private String address;
	
	/**
	 * 状态(0-初始，1-正常 2-下架)
	 */
	private Integer status;
	
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
	

	public LoanChannelCompany() {
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
     * setter for companyCode
	 * @param companyCode
     */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

    /**
     * getter for companyCode
     */
	public String getCompanyCode() {
		return companyCode;
	}
	
    /**
     * setter for companyName
	 * @param companyName
     */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

    /**
     * getter for companyName
     */
	public String getCompanyName() {
		return companyName;
	}
	
    /**
     * setter for type
	 * @param type
     */
	public void setType(String type) {
		this.type = type;
	}

    /**
     * getter for type
     */
	public String getType() {
		return type;
	}
	
    /**
     * setter for price
	 * @param price
     */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    /**
     * getter for price
     */
	public BigDecimal getPrice() {
		return price;
	}
	
    /**
     * setter for contactName
	 * @param contactName
     */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

    /**
     * getter for contactName
     */
	public String getContactName() {
		return contactName;
	}
	
    /**
     * setter for contactPhone
	 * @param contactPhone
     */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

    /**
     * getter for contactPhone
     */
	public String getContactPhone() {
		return contactPhone;
	}
	
    /**
     * setter for address
	 * @param address
     */
	public void setAddress(String address) {
		this.address = address;
	}

    /**
     * getter for address
     */
	public String getAddress() {
		return address;
	}
	
    /**
     * setter for status
	 * @param status
     */
	public void setStatus(Integer status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public Integer getStatus() {
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
