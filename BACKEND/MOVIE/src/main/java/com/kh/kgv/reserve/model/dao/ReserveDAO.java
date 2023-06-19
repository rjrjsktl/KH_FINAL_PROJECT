package com.kh.kgv.reserve.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;

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

}
