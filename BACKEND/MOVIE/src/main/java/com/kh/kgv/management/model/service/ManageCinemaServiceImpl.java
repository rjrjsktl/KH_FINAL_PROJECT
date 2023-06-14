package com.kh.kgv.management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.management.model.dao.ManageCinemaDAO;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Screen;

@Service
public class ManageCinemaServiceImpl implements ManageCinemaService {

	@Autowired
	private ManageCinemaDAO dao;

	@Override
	public int cinemaDupCheck(String cinemaName) {
		return 0;
	}

	@Override
	public int enrollCinema(Cinema cinema) {
		return 0;
	}

	@Override
	public int enrollScreen(Screen screen) {
		return 0;
	}


}
