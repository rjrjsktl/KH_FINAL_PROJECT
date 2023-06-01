package com.kh.kgv.login.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.login.model.dao.SignUpDAO;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpDAO dao;
	
	
	@Override
	public int emailDupCheck(String userEmail) {
		return dao.emailDupCheck(userEmail);
	}

	

}
