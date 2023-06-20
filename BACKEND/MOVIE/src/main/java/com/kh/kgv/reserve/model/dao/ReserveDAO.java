package com.kh.kgv.reserve.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;

@Repository
public class ReserveDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Cinema> getAreaCinemaList(String areaName) {
		return sqlSession.selectList("cinemaMapper.getAreaCinemaList", areaName);
	}

	// 상영영화 리스트 이름 순
	public List<Movie> getPlayingMovieList() {
		return sqlSession.selectList("playMapper.getPlayingMovieList");
	}
	
	// 상영영화 리스트 예매율 순
	public List<Movie> getPlayingThumbList() {
		return sqlSession.selectList("playMapper.getPlayingThumbList");
	}

	public List<JoinPlay> getTotalPlayList(Map<String, Object> condition) {
		return sqlSession.selectList("playMapper.getTotalPlayList", condition);
	}

	public List<Screen> getScreenList(String cinemaName) {
		return sqlSession.selectList("cinemaMapper.getScreenList", cinemaName);
	}

	public List<JoinPlay> getMoviePlayList(Map<String, Object> condition) {
		return sqlSession.selectList("playMapper.getMoviePlayList", condition);
	}




}
