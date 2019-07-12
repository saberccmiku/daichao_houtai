package com.daichao.loans.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhangbo
 *
 */
public class ProductVO implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer productId;
	
	private String productName;
	
	private String logo;
	
	private String advantage;	// 产品优势
	
	private BigDecimal minAmt; //起始金额
	
	private BigDecimal maxAmt;	//最大金额
	
	private BigDecimal dayRate;
	
	private double passRate; // 通过率
	
	private String link; //H5跳转链接
	
	private String linkType; //链接类型 1:h5  2:api
	
	private Integer scort; //排位
	
	private Integer status;

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

	public BigDecimal getDayRate() {
		return dayRate;
	}

	public void setDayRate(BigDecimal dayRate) {
		this.dayRate = dayRate;
	}

	public double getPassRate() {
		return passRate;
	}

	public void setPassRate(double passRate) {
		this.passRate = passRate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getScort() {
		return scort;
	}

	public void setScort(Integer scort) {
		this.scort = scort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	} 
}
