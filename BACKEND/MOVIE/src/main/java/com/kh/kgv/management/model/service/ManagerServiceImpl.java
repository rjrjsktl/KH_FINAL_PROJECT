package com.kh.kgv.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.management.model.dao.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO dao;

	@Override
	public List<User> selectAll() {
		List<User>getUserList = dao.selectAll();
		return getUserList;
	}
	
	
}
