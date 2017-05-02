package com.jx372.bookmall.vo;

public class OrderVo {
	private Integer no;
	private Integer memberNo;
	private Integer orderPrice;
	private String address;
	private String memberName;
	private String email;
	
	
	
	@Override
	public String toString() {
		return no+", "+memberName+"/"+email+", "+orderPrice+", "+address;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getMemberName() {
		return memberName;
	}
	public final void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public final Integer getNo() {
		return no;
	}
	public final void setNo(Integer no) {
		this.no = no;
	}
	public final Integer getMemberNo() {
		return memberNo;
	}
	public final void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public final Integer getOrderPrice() {
		return orderPrice;
	}
	public final void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	
	
}
