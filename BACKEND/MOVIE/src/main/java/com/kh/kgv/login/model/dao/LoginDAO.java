package com.kh.kgv.login.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.User;

@Repository
public class LoginDAO {
	
	@Autowired   // root-context.xml 에서 생성된 SqlSessionTemplate bean을 의존성 주입(DI)
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(LoginDAO.class);

	
	public User login(User inputUser) {
		
		logger.info("3. 로그인 DAO 진입");
		
		User loginUser = sqlSession.selectOne("userMapper.login", inputUser ); 
		
		System.out.println("디버깅");
		
		logger.info("4. 받아온 loginUser :" + loginUser);
		return loginUser;
	}


	public List<User> selectAll() {
		// selectList() : 여러 행을 조회 -> 리턴 타입이 List
		//	* 조회되는 모든 행을 순차적으로 접근해서 VO에 필드 값을 담은 후 List에 자동 추가			
		return sqlSession.selectList("userMapper.selectAll");
	}

}
