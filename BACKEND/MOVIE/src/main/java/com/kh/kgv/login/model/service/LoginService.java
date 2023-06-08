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

	
	/** 비밀번호 찾기 checkUser 서비스
	 * @param user
	 * @return
	 */
	public abstract Boolean checkUser(User user);
	
	
	/** 인증메일 보내기 서비스
	 * @param cnum
	 * @param userEmail
	 * @return
	 */
	public abstract int insertCertification(String cnum, String userEmail);


	/** 인증완료 서비스
	 * @param cNumber
	 * @param userEmail
	 * @return
	 */
	public abstract int checkNumber(String cNumber, String userEmail);

	
	
	
}
