package com.kh.kgv.management.model.service;

import java.util.List;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.items.model.vo.TimeTable;
import com.kh.kgv.management.model.vo.Cinema;

public interface ManagePlayService {

	List<Cinema> getAreaCinemaList(String areaName);

	List<Movie> getPlayingMovieList();

	List<TimeTable> getTimeTableList();

	List<Play> playTimeCheck(String cinemaName, int screenName, int startTime, int endTime, String startDate, String endDate);

	int enrollPlay(String cinemaName, int screenName, int movieNo, int startTime, int endTime, String startDate, String endDate);

	
	

}
