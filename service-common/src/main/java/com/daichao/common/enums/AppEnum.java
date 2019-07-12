package com.daichao.common.enums;

/**
 * app应用名称
 * @author zcb
 */
public enum AppEnum {
	LEXY("10", "乐享用");

	private String id;
	private String name;

	AppEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static String getName(String id) {
		for (AppEnum userTypeEnum : AppEnum.values()) {
			if (userTypeEnum.getId().equals(id)) {
				return userTypeEnum.getName();
			}
		}
		return null;
	}

	public static AppEnum get(String id) {
		for (AppEnum p : AppEnum.values()) {
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