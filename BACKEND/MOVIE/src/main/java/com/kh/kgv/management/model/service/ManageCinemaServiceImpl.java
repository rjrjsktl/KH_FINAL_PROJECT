package com.kh.kgv.management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.management.model.dao.ManageCinemaDAO;

@Service
public class ManageCinemaServiceImpl implements ManageCinemaService {

	@Autowired
	private ManageCinemaDAO dao;

	@Override
	public int cinemaDupCheck(String cinemaName) {
		return 0;
	}

	@Override
	public int enrollCinema(String cinemaName, String cinemaArea, String cinemaRegion, int cinemaScreen) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int enrollScreen(String cinemaName, int screenName, String screenStyle, int screenSeat, String screenDetail) {
		return 1;
	}
}
