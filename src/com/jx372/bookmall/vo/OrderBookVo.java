package com.jx372.bookmall.vo;

public class OrderBookVo {
	private Integer orderNo;
	private Integer bookNo;
	private Integer stock;
	private String bookTitle;
		
	@Override
	public String toString() {
		return  bookNo +", "+ bookTitle + ", "+ stock;
	}
	public final String getBookTitle() {
		return bookTitle;
	}
	public final void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public final Integer getOrderNo() {
		return orderNo;
	}
	public final void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public final Integer getBookNo() {
		return bookNo;
	}
	public final void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public final Integer getStock() {
		return stock;
	}
	public final void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
