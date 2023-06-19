package com.kh.kgv.movieList.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Pagination;

@Repository
public class MovieDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
//	메인페이지 -> 영화 -> 상영중인영화 이동 시 영화 목록 조회
	public List<Movie> movieList() {
		
		return sqlSession.selectList("movieMapper.getMovieList", null);
	}
	
	// 메인 상영중인 영화 목록 가지고 오기 - 7개
	public List<Movie> mainMovieList() {
		
		return sqlSession.selectList("movieMapper.mainMovieList", null);
	}
}
