package com.kh.kgv.movieList.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
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

	// 관리자 페이지 상영 수 조회
	public int getNowPlayCount() {
		return sqlSession.selectOne("movieMapper.getNowPlayCount");
	}

	// 관리자 페이지 상영 조회
	public List<JoinPlay> getPlayList(Pagination pagination) {
		
	int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("movieMapper.getPlayList", null, rowBounds);
	}
	// 관리자_상영영화 종료 목록 수 조회
	public int getEndPlayCount() {
		return sqlSession.selectOne("movieMapper.getEndPlayCount");
	}

	// 관리자_상영영화 종료 목록 조회
	public List<JoinPlay> getPlayEndList(Pagination pagination) {
		
	int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("movieMapper.getPlayEndList", null, rowBounds);
	}
}
