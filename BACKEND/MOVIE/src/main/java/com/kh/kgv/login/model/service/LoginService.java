package com.kh.kgv.login.model.service;

import com.kh.kgv.customer.model.vo.User;

public interface LoginService {

	/** 로그인 서비스
	 * @param inputUser
	 * @return loginUser
	 */
	public abstract User login(User inputUser);

}
