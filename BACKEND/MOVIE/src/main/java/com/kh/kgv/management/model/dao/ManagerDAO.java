package com.kh.kgv.management.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.User;

@Repository
public class ManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<User> selectAll() {
		List<User>getUserList = sqlSession.selectList("managerMapper.selectAll");
		return getUserList;
	}
	
	

}
