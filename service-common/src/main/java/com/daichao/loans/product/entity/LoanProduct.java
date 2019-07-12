package com.daichao.loans.product.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 产品信息
 * @author zcl<yczclcn@163.com>
 */
public class LoanProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 产品编号
	 */
	private String productCode;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品类型（1-现金贷 2-贷超）
	 */
	private Integer type;
	
	/**
	 * 公司ID
	 */
	private Integer companyId;
	
	/**
	 * 产品图片
	 */
	private String logo;
	
	/**
	 * 产品优势
	 */
	private String advantage;
	
	/**
	 * 放款速度(小时)
	 */
	private String lendSpeed;
	
	/**
	 * 放款最小额
	 */
	private BigDecimal minAmt;
	
	/**
	 * 放款最大额
	 */
	private BigDecimal maxAmt;
	
	/**
	 * 最短周期(天)
	 */
	private Integer minTerm;
	
	/**
	 * 最大周期(天)
	 */
	private Integer maxTerm;
	
	/**
	 * 日利率
	 */
	private BigDecimal dayRate;
	
	/**
	 * 借款单位（M-月、Q-季、Y-年、D-天）
	 */
	private String loanUnit;
	
	/**
	 * 最快审核周期(小时)
	 */
	private String fastestAuditCircle;
	
	/**
	 * 通过率
	 */
	private Double passRate;
	
	/**
	 * 跳转链接
	 */
	private String link;
	
	/**
	 * 1-h5, 2-api
	 */
	private Integer linkType;
	
	/**
	 * 产品介绍
	 */
	private String introduction;
	
	/**
	 * 申请条件
	 */
	private String applyCondition;
	
	/**
	 * 所需资料
	 */
	private String requireDocument;
	
	/**
	 * 审核流程
	 */
	private String auditProcess;
	
	/**
	 * 产品分类
	 */
	private Integer categoryId;
	
	/**
	 * 产品标签
	 */
	private Integer label;
	
	/**
	 * 是否加入轮播图
	 */
	private Integer bannaerTag;
	
	/**
	 * 排位
	 */
	private Integer scort;
	
	/**
	 * 申请人数/uv
	 */
	private Integer applyNum;
	
	/**
	 * 应用编号
	 */
	private Integer appId;
	
	/**
	 * 产品状态(0-初始，1-正常，2-下架)
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
	

	public LoanProduct() {
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
     * setter for companyId
	 * @param companyId
     */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

    /**
     * getter for companyId
     */
	public Integer getCompanyId() {
		return companyId;
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
     * setter for advantage
	 * @param advantage
     */
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

    /**
     * getter for advantage
     */
	public String getAdvantage() {
		return advantage;
	}
	
    /**
     * setter for lendSpeed
	 * @param lendSpeed
     */
	public void setLendSpeed(String lendSpeed) {
		this.lendSpeed = lendSpeed;
	}

    /**
     * getter for lendSpeed
     */
	public String getLendSpeed() {
		return lendSpeed;
	}
	
    /**
     * setter for minAmt
	 * @param minAmt
     */
	public void setMinAmt(BigDecimal minAmt) {
		this.minAmt = minAmt;
	}

    /**
     * getter for minAmt
     */
	public BigDecimal getMinAmt() {
		return minAmt;
	}
	
    /**
     * setter for maxAmt
	 * @param maxAmt
     */
	public void setMaxAmt(BigDecimal maxAmt) {
		this.maxAmt = maxAmt;
	}

    /**
     * getter for maxAmt
     */
	public BigDecimal getMaxAmt() {
		return maxAmt;
	}
	
    /**
     * setter for minTerm
	 * @param minTerm
     */
	public void setMinTerm(Integer minTerm) {
		this.minTerm = minTerm;
	}

    /**
     * getter for minTerm
     */
	public Integer getMinTerm() {
		return minTerm;
	}
	
    /**
     * setter for maxTerm
	 * @param maxTerm
     */
	public void setMaxTerm(Integer maxTerm) {
		this.maxTerm = maxTerm;
	}

    /**
     * getter for maxTerm
     */
	public Integer getMaxTerm() {
		return maxTerm;
	}
	
    /**
     * setter for dayRate
	 * @param dayRate
     */
	public void setDayRate(BigDecimal dayRate) {
		this.dayRate = dayRate;
	}

    /**
     * getter for dayRate
     */
	public BigDecimal getDayRate() {
		return dayRate;
	}
	
    /**
     * setter for loanUnit
	 * @param loanUnit
     */
	public void setLoanUnit(String loanUnit) {
		this.loanUnit = loanUnit;
	}

    /**
     * getter for loanUnit
     */
	public String getLoanUnit() {
		return loanUnit;
	}
	
    /**
     * setter for fastestAuditCircle
	 * @param fastestAuditCircle
     */
	public void setFastestAuditCircle(String fastestAuditCircle) {
		this.fastestAuditCircle = fastestAuditCircle;
	}

    /**
     * getter for fastestAuditCircle
     */
	public String getFastestAuditCircle() {
		return fastestAuditCircle;
	}
	
    /**
     * setter for passRate
	 * @param passRate
     */
	public void setPassRate(Double passRate) {
		this.passRate = passRate;
	}

    /**
     * getter for passRate
     */
	public Double getPassRate() {
		return passRate;
	}
	
    /**
     * setter for link
	 * @param link
     */
	public void setLink(String link) {
		this.link = link;
	}

    /**
     * getter for link
     */
	public String getLink() {
		return link;
	}
	
    /**
     * setter for linkType
	 * @param linkType
     */
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}

    /**
     * getter for linkType
     */
	public Integer getLinkType() {
		return linkType;
	}
	
    /**
     * setter for introduction
	 * @param introduction
     */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

    /**
     * getter for introduction
     */
	public String getIntroduction() {
		return introduction;
	}
	
    /**
     * setter for applyCondition
	 * @param applyCondition
     */
	public void setApplyCondition(String applyCondition) {
		this.applyCondition = applyCondition;
	}

    /**
     * getter for applyCondition
     */
	public String getApplyCondition() {
		return applyCondition;
	}
	
    /**
     * setter for requireDocument
	 * @param requireDocument
     */
	public void setRequireDocument(String requireDocument) {
		this.requireDocument = requireDocument;
	}

    /**
     * getter for requireDocument
     */
	public String getRequireDocument() {
		return requireDocument;
	}
	
    /**
     * setter for auditProcess
	 * @param auditProcess
     */
	public void setAuditProcess(String auditProcess) {
		this.auditProcess = auditProcess;
	}

    /**
     * getter for auditProcess
     */
	public String getAuditProcess() {
		return auditProcess;
	}
	
    /**
     * setter for categoryId
	 * @param categoryId
     */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

    /**
     * getter for categoryId
     */
	public Integer getCategoryId() {
		return categoryId;
	}
	
    /**
     * setter for label
	 * @param label
     */
	public void setLabel(Integer label) {
		this.label = label;
	}

    /**
     * getter for label
     */
	public Integer getLabel() {
		return label;
	}
	
    /**
     * setter for bannaerTag
	 * @param bannaerTag
     */
	public void setBannaerTag(Integer bannaerTag) {
		this.bannaerTag = bannaerTag;
	}

    /**
     * getter for bannaerTag
     */
	public Integer getBannaerTag() {
		return bannaerTag;
	}
	
    /**
     * setter for scort
	 * @param scort
     */
	public void setScort(Integer scort) {
		this.scort = scort;
	}

    /**
     * getter for scort
     */
	public Integer getScort() {
		return scort;
	}
	
    /**
     * setter for applyNum
	 * @param applyNum
     */
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

    /**
     * getter for applyNum
     */
	public Integer getApplyNum() {
		return applyNum;
	}
	
    /**
     * setter for appId
	 * @param appId
     */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}

    /**
     * getter for appId
     */
	public Integer getAppId() {
		return appId;
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
