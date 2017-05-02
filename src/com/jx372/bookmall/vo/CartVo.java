package com.jx372.bookmall.vo;

public class CartVo {
	private Integer bookNo;
	private Integer memNo;
	private Integer stock;
	private String bookTitle;
	private Integer price;

	
	@Override
	public String toString() {
		return bookNo+","+ bookTitle+","+stock+", "+price;
	}
	public final Integer getPrice() {
		return price;
	}

	public final void setPrice(Integer price) {
		this.price = price;
	}

	public final Integer getBookNo() {
		return bookNo;
	}
	public final void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public final Integer getMemNo() {
		return memNo;
	}
	public final void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public final Integer getStock() {
		return stock;
	}
	public final void setStock(Integer stock) {
		this.stock = stock;
	}
	public final String getBookTitle() {
		return bookTitle;
	}
	public final void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	
}
