package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.MemberDao;
import com.jx372.bookmall.vo.MemberVo;



public class MemberDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
	}
	
	public static void insertTest(){
		MemberVo member = new MemberVo();
		
		member.setName("비트교육센터");
		member.setEmail("anstjdgns@anstjdgns.com");
		member.setPhone("010-1111-1111");
		member.setPw("12345");
		
		new MemberDao().insert(member);
		
	}
	public static void selectTest(){
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo mv : list){
			System.out.println(mv);
		}
	}
}
