package com.kh.kgv.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.reserve.model.dao.ReserveDAO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
	private ReserveDAO dao;

	@Override
	public List<Cinema> getAreaCinemaList(String areaName) {
		List<Cinema> cinemaList = dao.getAreaCinemaList(areaName);
		return cinemaList;
	}

	@Override
	public List<Movie> getPlayingMovieList() {
		List<Movie> movieList = dao.getPlayingMovieList();
		return movieList;
	}

	@Override
	public List<Movie> getPlayingThumbList() {
		List<Movie> thumbList = dao.getPlayingThumbList();
		return thumbList;
	}

}
