package com.kh.kgv.reserve.model.service;

import java.util.List;
import java.util.Map;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.CinemaPrice;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;

public interface ReserveService {

	List<Cinema> getAreaCinemaList(String areaName);

	List<Movie> getPlayingMovieList();

	List<Movie> getPlayingThumbList();
	
	List<JoinPlay> getTotalPlayList(String areaName, String cinemaIndex, String dateIndex);

	List<JoinPlay> getMoviePlayList(String areaName, String cinemaIndex, String dateIndex, String movieOptionIndex, String movieIndex);
	
	List<Screen> getScreenList(String cinemaName);

	JoinPlay getUserPlay(int playNo);

	CinemaPrice getPriceModel(int priceNo);

	int getPriceNo(int playNo);

	Map<String, Object> getPriceMap(int priceNo, String partialCountArray);

	Map<String, Object> getInitialMap(String areaName);


}
