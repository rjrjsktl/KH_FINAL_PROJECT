package com.kh.kgv.management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.management.model.dao.ManagePlayDAO;
import com.kh.kgv.management.model.vo.Cinema;


@Service
public class ManagePlayServiceImpl implements ManagePlayService {
	
	@Autowired
	private ManagePlayDAO dao;

	@Override
	public List<Cinema> getAreaCinemaList(String areaName) {
		List<Cinema> areaCinemaList = dao.getAreaCinemaList(areaName);
		return areaCinemaList;
	}

}
