package com.kh.kgv.management.model.service;

import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Screen;

public interface ManageCinemaService {

	int cinemaDupCheck(String cinemaName);

	int enrollCinema(Cinema cinema);

	int enrollScreen(Screen screen);

}
