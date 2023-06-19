package com.kh.kgv.reserve.model.service;

import java.util.List;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Screen;

public interface ReserveService {

	List<Cinema> getAreaCinemaList(String areaName);

	List<Movie> getPlayingMovieList();

	List<Movie> getPlayingThumbList();

	List<Play> getTotalPlayList(int cinemaNo, String strDate);

	List<Screen> getScreenList(String cinemaName);

}
