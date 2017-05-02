package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CategoryDao;
import com.jx372.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
	}
	public static void insertTest(){
		CategoryVo catrgory = new CategoryVo();
		
		catrgory.setName("예술");
				
		new CategoryDao().insert(catrgory);
		
	}
	public static void selectTest(){
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo gv : list){
			System.out.println(gv);
		}
	}
}
