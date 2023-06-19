package com.kh.kgv.reserve.model.service;

import java.util.List;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;

public interface ReserveService {

	List<Cinema> getAreaCinemaList(String areaName);

	List<Movie> getPlayingMovieList();

	List<Movie> getPlayingThumbList();

}
