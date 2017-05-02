package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.OrderDao;
import com.jx372.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
	}
	
	public static void insertTest(){
		OrderVo orderVo = new OrderVo();
		
		orderVo.setMemberNo(1);
		orderVo.setOrderPrice(10000);
		orderVo.setAddress("BIT st");
		
		new OrderDao().insert(orderVo);
		
	}
	public static void selectTest(){
		List<OrderVo> list = new OrderDao().getList();
		for(OrderVo cv : list){
			System.out.println(cv);
		}
	}
}
