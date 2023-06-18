package com.kh.kgv.movieList.model.service;

import java.util.Map;

import com.kh.kgv.items.model.vo.Movie;

public interface MovieService {
	
//	메인페이지 -> 영화 -> 상영중인영화 이동 시 영화 목록 조회
	Map<String, Object> movieList();

	// 메인 상영중인 영화 목록 가지고 오기 - 7개
	Map<String, Object> mainMovieList();
}
