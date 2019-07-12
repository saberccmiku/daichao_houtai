package com.daichao.loans.product.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 放贷公司信息
 * @author zcl<yczclcn@163.com>
 */
public class LoanProductCompany implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 产品公司编码
	 */
	private String companyCode;
	
	/**
	 * 产品公司名称
	 */
	private String companyName;
	
	/**
	 * 公司logo
	 */
	private String logo;
	
	/**
	 * 类型
	 */
	private Integer type;
	
	/**
	 * 充值金额
	 */
	private BigDecimal rechargeAmt;
	
	/**
	 * 余额
	 */
	private BigDecimal balance;
	
	/**
	 * 单价
	 */
	private BigDecimal price;
	
	/**
	 * 联系人
	 */
	private String contactName;
	
	/**
	 * 联系人手机号
	 */
	private String contactPhone;
	
	/**
	 * 公司地址
	 */
	private String address;
	
	/**
	 * 状态（0-不可用,1-可用）
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
	

	public LoanProductCompany() {
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
     * setter for logo
	 * @param logo
     */
	public void setLogo(String logo) {
		this.logo = logo;
	}

    /**
     * getter for logo
     */
	public String getLogo() {
		return logo;
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
     * setter for rechargeAmt
	 * @param rechargeAmt
     */
	public void setRechargeAmt(BigDecimal rechargeAmt) {
		this.rechargeAmt = rechargeAmt;
	}

    /**
     * getter for rechargeAmt
     */
	public BigDecimal getRechargeAmt() {
		return rechargeAmt;
	}
	
    /**
     * setter for balance
	 * @param balance
     */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

    /**
     * getter for balance
     */
	public BigDecimal getBalance() {
		return balance;
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
