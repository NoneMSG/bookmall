package com.jx372.bookmall.vo;

public class BookVo {
	private Integer no;
	private String title;
	private Integer price;
	private Integer categoryNo; 
	private String categoryName;
	
	
	@Override
	public String toString() {
		return no+", "+ title+", "+ categoryName+", "+price;
	}

	public final String getCategoryName() {
		return categoryName;
	}

	public final void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

		public final Integer getNo() {
		return no;
	}

	public final Integer getCategoryNo() {
			return categoryNo;
		}

		public final void setCategoryNo(Integer categoryNo) {
			this.categoryNo = categoryNo;
		}

	public final void setNo(Integer no) {
		this.no = no;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final Integer getPrice() {
		return price;
	}

	public final void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
