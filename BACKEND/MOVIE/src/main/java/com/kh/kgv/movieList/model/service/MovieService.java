package com.kh.kgv.movieList.model.service;

import java.util.Map;

import com.kh.kgv.items.model.vo.Movie;

public interface MovieService {
	
//	메인페이지 -> 영화 -> 무비차트 이동 시 영화 목록 조회
	Map<String, Object> movieList();
}
