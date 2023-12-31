package com.kh.kgv.login.model.service;

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

}
