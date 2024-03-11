package com.beans;

public class FirstBean {
	
	// Beans 규약 : 빈 생성시 멤버는 private 으로 만들자는 약속
	private String name = "Hong, Gil-dong";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
