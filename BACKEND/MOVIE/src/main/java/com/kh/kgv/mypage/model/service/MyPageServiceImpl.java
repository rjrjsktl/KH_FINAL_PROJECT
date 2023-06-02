package com.kh.kgv.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.mypage.model.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	
	
	
	
	
	
	
	// 회원 탈퇴 서비스 구현
	@Override
	public int secession(User loginUser) {
			
		// 1) DB에서 암호화된 비밀번호를 조회하여 입력받은 비밀번호와 비교
		String encPw = dao.selectEncPw( loginUser.getUserNo() );
			
		if( bcrypt.matches( loginUser.getUserPw() , encPw ) ) {
				
			// 2) 비밀번호가 일치하면 회원 번호를 이용해서 탈퇴 진행
			return dao.secession(loginUser.getUserNo());
		}
			
		// 3) 비밀번호가 일치하지 않으면 0 반환
		return 0;
	}

	
}
