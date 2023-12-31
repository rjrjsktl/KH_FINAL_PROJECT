package com.kh.kgv.login.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.login.model.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	// 로그인 서비스 구현
	@Override
	public User login(User inputUser) {
		
		logger.info("2. 로그인 Service 진입");
		
		logger.debug( inputUser.getUserPw() + " / " +  bcrypt.encode(inputUser.getUserPw()) );
		
		User loginUser = dao.login(inputUser);
		
		logger.info("5. DAO에서 넘어온 loginUser :" + loginUser);
		
		if(loginUser != null) { // 일치하는 이메일을 가진 회원 정보가 있을 경우
			
			// 입력된 비밀번호(평문) , 조회된 비밀번호(암호화) 비교 (같으면 true)
							 		//평문                  ,   암호화
			if( bcrypt.matches(  inputUser.getUserPw()   ,  loginUser.getUserPw() ) ) {
				// 비밀번호가 일치할 경우
				
				loginUser.setUserPw(null); // 비교 끝났으면 비밀번호 지우기
				
			} else { // 비밀번호가 일치하지 않은 경우
				loginUser = null; // 로그인을 실패한 형태로 바꿔줌
				
			}
		}
		
		return loginUser;
	}

	// 회원조회 서비스
	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}
	
	
	
}
