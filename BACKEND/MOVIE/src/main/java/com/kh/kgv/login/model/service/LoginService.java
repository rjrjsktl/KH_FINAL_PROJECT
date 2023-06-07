package com.kh.kgv.login.model.service;

import java.util.HashMap;
import java.util.List;

import com.kh.kgv.customer.model.vo.User;

public interface LoginService {

	/** 로그인 서비스
	 * @param inputUser
	 * @return loginUser
	 */
	public abstract User login(User inputUser);

	/** 회원 조회 서비스
	 * @return
	 */
	public abstract List<User> selectAll();

	/** 비밀번호 찾기 checkUser 서비스
	 * @param userName
	 * @param userBirth
	 * @param userEmail
	 * @return
	 */

	// 4. 흔한 서비스
	public abstract Boolean checkUser(User user);

	
	
	
}
