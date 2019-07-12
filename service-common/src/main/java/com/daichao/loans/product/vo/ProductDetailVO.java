/**
 *Copyright 2014-2017 再来借 All rights reserved.
 */
package com.daichao.loans.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品信息Entity
 * @author
 * @version 2019-05-31
 */
public class ProductDetailVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer productId;
	/**
	  * 产品名称
	  */
	private String productName;		
	/**
	  *产品图片
	  */
	private String logo;		
	/**
	  *产品优势
	  */
	private String advantage;		
	/**
	  *放款最小额
	  */
	private BigDecimal minAmt;		
	/**
	  *放款最大额
	  */
	private BigDecimal maxAmt;		
	/**
	  *最短周期(天)
	  */
	private Integer minTerm;		
	/**
	  *最大周期(天)
	  */
	private Integer maxTerm;		
	/**
	  *日利率
	  */
	private BigDecimal dayRate;		
	/**
	  *借款单位（M-月、Q-季、Y-年、D-天）
	  */
	private String loanUnit;		
	/**
	  *跳转链接
	  */
	private String link;		
	
	/**
	 * 链接类型 1:h5  2:api
	 */
	private String linkType;
	
	/**
	  *产品介绍
	  */
	private String introduction;		
	/**
	  *申请条件
	  */
	private String applyCondition;		
	/**
	  *所需资料
	  */
	private String requireDocument;		

	/**
	  *申请人数/uv
	  */
	private Integer applyNum;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public BigDecimal getMinAmt() {
		return minAmt;
	}
	public void setMinAmt(BigDecimal minAmt) {
		this.minAmt = minAmt;
	}
	public BigDecimal getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(BigDecimal maxAmt) {
		this.maxAmt = maxAmt;
	}
	public Integer getMinTerm() {
		return minTerm;
	}
	public void setMinTerm(Integer minTerm) {
		this.minTerm = minTerm;
	}
	public Integer getMaxTerm() {
		return maxTerm;
	}
	public void setMaxTerm(Integer maxTerm) {
		this.maxTerm = maxTerm;
	}
	public BigDecimal getDayRate() {
		return dayRate;
	}
	public void setDayRate(BigDecimal dayRate) {
		this.dayRate = dayRate;
	}
	public String getLoanUnit() {
		return loanUnit;
	}
	public void setLoanUnit(String loanUnit) {
		this.loanUnit = loanUnit;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getApplyCondition() {
		return applyCondition;
	}
	public void setApplyCondition(String applyCondition) {
		this.applyCondition = applyCondition;
	}
	public String getRequireDocument() {
		return requireDocument;
	}
	public void setRequireDocument(String requireDocument) {
		this.requireDocument = requireDocument;
	}
	public Integer getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}		
}