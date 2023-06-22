package com.kh.kgv.reserve.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;
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

	@Override
	public List<JoinPlay> getTotalPlayList(int cinemaNo, String strDate) {
		Map<String, Object> condition = new HashMap<>();
		condition.put("cinemaNo", cinemaNo);
		condition.put("strDate", strDate);
		List<JoinPlay> totalPlayList = dao.getTotalPlayList(condition);
		return totalPlayList;
	}

	@Override
	public List<Screen> getScreenList(String cinemaName) {
		List<Screen> screenList = dao.getScreenList(cinemaName);
		return screenList;
	}

	@Override
	public List<JoinPlay> getMoviePlayList(int cinemaNo, String strDate, int movieNo) {
		Map<String, Object> condition = new HashMap<>();
		condition.put("cinemaNo", cinemaNo);
		condition.put("strDate", strDate);
		condition.put("movieNo", movieNo);
		List<JoinPlay> moviePlayList = dao.getMoviePlayList(condition);
		return moviePlayList;
	}

	@Override
	public JoinPlay getUserPlay(int playNo) {
		return dao.getUserPlay(playNo);
	}




}
