package com.kh.kgv.login.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpDAO {
	
	private SqlSessionTemplate sqlSession;
	
	

	public int emailDupCheck(String inputEmail) {
		
		return sqlSession.selectOne("intputMapper.emailDupCheck",inputEmail);
	}

}
