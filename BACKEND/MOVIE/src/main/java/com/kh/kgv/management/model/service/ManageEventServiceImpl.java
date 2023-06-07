package com.kh.kgv.management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.management.model.dao.ManageEventDAO;

@Service
public class ManageEventServiceImpl implements ManageEventService{
	
	@Autowired
	private ManageEventDAO dao;


	
}
