package com.kh.kgv.login.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDAO {
	
	private SqlSessionTemplate sqlSession;
	
	

	public int emailDupCheck(String userEmail) {
		
		return sqlSession.selectOne("userMapper.emailDupCheck",userEmail);
	}

}
