package com.kh.kgv.management.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.management.model.dao.ManagerDAO;
import com.kh.kgv.management.model.vo.Pagination;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO dao;



	@Override
	public Map<String, Object> selectAll(int cp) {
		
		// 회원 수 조회
		int listCount = dao.getListCount();
		System.out.println("========================================listCount : " + listCount );
		
		// 조회한 회원을 pagination 에 담기
		Pagination pagination = new Pagination(cp, listCount);
		
		// 회원 리스트 조회
		List<User>userList = dao.selectAll(pagination);
		
		Map<String, Object>getUserList = new HashMap<String, Object>();
		getUserList.put("pagination", pagination);
		getUserList.put("userList", userList);
		
		return getUserList;
	}
	
	
}
