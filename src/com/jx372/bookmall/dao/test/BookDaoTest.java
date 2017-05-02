package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.BookDao;
import com.jx372.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		
		insertTest();
		selectTest();
	}
	
	public static void insertTest(){
		BookVo book = new BookVo();
		
		book.setTitle("예술 책입니다.");
		book.setPrice(40000);
		book.setCategoryNo(4);
		
		new BookDao().insert(book);
		
	}
	public static void selectTest(){
		List<BookVo> list = new BookDao().getList();
		for(BookVo bv : list){
			System.out.println(bv);
		}
	}
	
}	
