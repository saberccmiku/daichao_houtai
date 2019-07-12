package com.daichao.common.enums;

/**
 * 终端类型1-app 2-微信 3-qq 4-浏览器,5其它
 * @author zcb
 */
public enum TerminalEnum {
	OTHER("0", "其它"),
	WEIXIN("1", "微信"),
	QQ("2", "qq"),
	BROWSER("3", "浏览器"),
	APP("4", "app");

	private String id;
	private String name;

	TerminalEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static String getName(String id) {
		for (TerminalEnum userTypeEnum : TerminalEnum.values()) {
			if (userTypeEnum.getId().equals(id)) {
				return userTypeEnum.getName();
			}
		}
		return null;
	}

	public static TerminalEnum get(String id) {
		for (TerminalEnum p : TerminalEnum.values()) {
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