package com.kh.kgv.login.model.service;

import com.kh.kgv.customer.model.vo.User;

public interface SignUpService {

	/** 이메일 중복검사 서비스
	 * @param inputEmail
	 * @return
	 */
	int emailDupCheck(String userEmail);
	
	
	/** 닉네임 중복검사 서비스
	 * @param inputNickname
	 * @return
	 */
	int nicknameDupCheck(String userNick);

	
	
	/** 이름 중복검사 서비스
	 * @param userName
	 * @return
	 */
	int nameDupCheck(String userName);


	/** 회원가입 서비스
	 * @param inputUser
	 * @return
	 */
	int signUp(User inputUser);

	
	
	

	

	

}
