package com.jx372.bookmall.vo;

public class MemberVo {
	private Integer no;
	private String name;
	private String phone;
	private String email;
	private String pw;
	@Override
	public String toString() {
		return no+", "+name+", "+ phone+", "+email+", "+pw ;
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
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getPw() {
		return pw;
	}
	public final void setPw(String pw) {
		this.pw = pw;
	}
	
}
