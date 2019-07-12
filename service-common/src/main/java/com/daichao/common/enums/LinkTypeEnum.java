package com.daichao.common.enums;

/**
 * 产品对接方式 1:h5, 2:api联登撞库
 * @author zcb
 */
public enum LinkTypeEnum {
	H5("1", "H5"), API("2", "联登撞库");

	private String id;
	private String name;

	LinkTypeEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static String getName(String id) {
		for (LinkTypeEnum userTypeEnum : LinkTypeEnum.values()) {
			if (userTypeEnum.getId().equals(id)) {
				return userTypeEnum.getName();
			}
		}
		return null;
	}

	public static LinkTypeEnum get(String id) {
		for (LinkTypeEnum p : LinkTypeEnum.values()) {
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
