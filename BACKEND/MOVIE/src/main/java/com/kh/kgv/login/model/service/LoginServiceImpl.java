package com.kh.kgv.login.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.login.model.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
}
