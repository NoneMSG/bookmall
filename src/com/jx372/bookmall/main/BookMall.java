package com.jx372.bookmall.main;
import com.jx372.bookmall.vo.*;

import java.util.List;

import com.jx372.bookmall.dao.*;

public class BookMall {

	public static void main(String[] args) {
				
			System.out.println("회원정보");
			System.out.println();
			showMemberList();
			
			System.out.println("=========================================");
			System.out.println();
			System.out.println("카테고리 리스트");
			showCategoryList();
			
			System.out.println("=========================================");
			System.out.println("상품 리스트");
			System.out.println();
			showBookList();
			
			System.out.println("=========================================");
			System.out.println("카트 리스트");
			System.out.println();
			showCartList();
			
			System.out.println("=========================================");
			System.out.println("주문 리스트");
			System.out.println();
			showOrderList();
			
			System.out.println("=========================================");
			System.out.println("주문 도서 리스트");
			System.out.println();
			orderBookList();
			
	}
	public static void orderBookList(){
		List<OrderBookVo> list = new OrderBookDao().getList();
		for(OrderBookVo obv : list){
			System.out.println(obv);
		}
	}
	public static void showOrderList(){
		List<OrderVo> list = new OrderDao().getList();
		for(OrderVo cv : list){
			System.out.println(cv);
		}
	}
	public static void showCartList(){
		List<CartVo> list = new CartDao().getList();
		for(CartVo cv : list){
			System.out.println(cv);
		}
	}
	public static void showBookList(){
		List<BookVo> list = new BookDao().getList();
		for(BookVo bv : list){
			System.out.println(bv);
		}
	}
	public static void showCategoryList(){
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo gv : list){
			System.out.println(gv);
		}
	}
	public static void showMemberList(){
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo mv : list){
			System.out.println(mv);
		}
	}
}
