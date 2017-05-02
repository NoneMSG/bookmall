package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CartDao;
import com.jx372.bookmall.vo.CartVo;



public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
	}
	public static void insertTest(){
		CartVo cartVo = new CartVo();
		
		cartVo.setBookNo(2);;
		cartVo.setMemNo(1);
		cartVo.setStock(2);
				
		new CartDao().insert(cartVo);
		
	}
	public static void selectTest(){
		List<CartVo> list = new CartDao().getList();
		for(CartVo cv : list){
			System.out.println(cv);
		}
	}
	
}
