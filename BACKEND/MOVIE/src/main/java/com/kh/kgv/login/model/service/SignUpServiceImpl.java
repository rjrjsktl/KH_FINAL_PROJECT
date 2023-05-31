package com.kh.kgv.login.model.service;

import org.springframework.stereotype.Service;

import com.kh.kgv.login.model.dao.SignUpDAO;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	private SignUpDAO dao;
	
	
	@Override
	public int emailDupCheck(String userEmail) {
		return dao.emailDupCheck(userEmail);
	}

	

}
