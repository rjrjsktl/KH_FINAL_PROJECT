package com.kh.kgv.login.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	

	public int emailDupCheck(String userEmail) {
		
		return sqlSession.selectOne("userMapper.emailDupCheck",userEmail);
	}

}
