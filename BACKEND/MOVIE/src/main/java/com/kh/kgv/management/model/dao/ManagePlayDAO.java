package com.kh.kgv.management.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.items.model.vo.TimeTable;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Screen;

@Repository
public class ManagePlayDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	// 지역별 극장 리스트
	
	public List<Cinema> getAreaCinemaList(String areaName) {
		return sqlSession.selectList("cinemaMapper.getAreaCinemaList", areaName);
	}

	
	// 상영 중인 영화 리스트
	
	public List<Movie> getPlayingMovieList() {
		return sqlSession.selectList("playMapper.getPlayingMovieList");
	}

	
	// 상영시간 리스트
	
	public List<TimeTable> getTimeTableList() {
		return sqlSession.selectList("playMapper.getPlayingMovieList");
	}


	// 상영관 번호
	
	public int getScreenNo(Screen screen) {
		return sqlSession.selectOne("cinemaMapper.getScreenNo", screen);
	}

	
	// 상영 유효성 검사
	
	public List<Play> playTimeCheck(Play play) {
		return sqlSession.selectList("playMapper.playTimeCheck", play);
	}


	// 상영 등록
	
	public int enrollPlay(Play play) {
		return sqlSession.insert("playMapper.enrollPlay", play);
	}


}
