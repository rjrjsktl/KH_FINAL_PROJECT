package com.kh.kgv.management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.management.model.dao.ManageStoreDAO;



@Service
public class ManageStoreServiceImpl implements ManageStoreService{
	
	@Autowired
	private ManageStoreDAO dao;

	@Override
	public int titleDupCheck(String storeTitle) {
		
		return dao.titleDupCheck(storeTitle);
	}

}
