package com.kh.kgv.login.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.User;

@Repository
public class SignUpDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	

	/** 이메일 중복검사
	 * @param userEmail
	 * @return
	 */
	public int emailDupCheck(String userEmail) {
		
		return sqlSession.selectOne("userMapper.emailDupCheck",userEmail);
	}



	/** 닉네임 중복검사
	 * @param inputNickname
	 * @return
	 */
	public int nicknameDupCheck(String userNick) {
		return sqlSession.selectOne("userMapper.nicknameDupCheck", userNick );
	}



	/** 이름 중복검사
	 * @param userName
	 * @return
	 */
	public int nameDupCheck(String userName) {
		return sqlSession.selectOne("userMapper.nameDupCheck",userName);
	}



	public int signUp(User inputUser) {
		
		return sqlSession.insert("userMapper.signUp",inputUser);
	}

}
