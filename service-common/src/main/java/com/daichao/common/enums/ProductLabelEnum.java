package com.daichao.common.enums;

/**
 * app应用名称
 * @author zcb
 */
public enum ProductLabelEnum {
	RENMEN("1", "热门排序"),
	EDUGAO("2", "额度高"),
	LILVDI("3", "利率低"),
	ZHOUQI("4", "周期长");

	private String id;
	private String name;

	ProductLabelEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static String getName(String id) {
		for (ProductLabelEnum userTypeEnum : ProductLabelEnum.values()) {
			if (userTypeEnum.getId().equals(id)) {
				return userTypeEnum.getName();
			}
		}
		return null;
	}

	public static ProductLabelEnum get(String id) {
		for (ProductLabelEnum p : ProductLabelEnum.values()) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}