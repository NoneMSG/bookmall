package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.OrderBookDao;
import com.jx372.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
	}
	public static void insertTest(){
		OrderBookVo orderBookVo = new OrderBookVo();
		
		orderBookVo.setBookNo(2);
		orderBookVo.setOrderNo(2);
		orderBookVo.setStock(1);
		
		new OrderBookDao().insert(orderBookVo);
	}
	public static void selectTest(){
		List<OrderBookVo> list = new OrderBookDao().getList();
		for(OrderBookVo obv : list){
			System.out.println(obv);
		}
	}
}
