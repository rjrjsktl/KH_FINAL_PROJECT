package com.kh.kgv.management.model.service;

public interface ManageCinemaService {

	int cinemaDupCheck(String cinemaName);

	int enrollCinema(String cinemaName, String cinemaArea, String cinemaRegion, int cinemaScreen);

	int enrollScreen(String cinemaName, int screenName, String screenStyle, int screenSeat, String screenDetail);

}
