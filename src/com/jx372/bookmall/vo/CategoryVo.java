package com.jx372.bookmall.vo;

public class CategoryVo {
	private Integer no;
	private String name;
	
	
	@Override
	public String toString() {
		return no+" "+name;
	}
	
	public final Integer getNo() {
		return no;
	}
	public final void setNo(Integer no) {
		this.no = no;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	
	
}
