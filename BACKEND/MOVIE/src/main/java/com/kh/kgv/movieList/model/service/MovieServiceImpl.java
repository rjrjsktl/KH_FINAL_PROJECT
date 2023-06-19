package com.kh.kgv.movieList.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.common.Util;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Pagination;
import com.kh.kgv.movieList.model.dao.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDAO dao;
	
//	메인페이지 -> 영화 -> 상영중인영화 이동 시 영화 목록 조회
	@Override
	public Map<String, Object> movieList() {
		
		List<Movie> movielist = dao.movieList();
		// movielist에서 따온 값 가공하기
	    List<Movie> cleanedList = new ArrayList<>();
	    	for (Movie movie : movielist) {
	    		Movie cleanedMovie = new Movie();
	    		cleanedMovie.setMgNo(Util.removeQuotes(movie.getMgNo()));
	    		cleanedMovie.setGenreName(Util.removeQuotes(movie.getGenreName()));
	    		cleanedMovie.setMovieNo(movie.getMovieNo());
	    		cleanedMovie.setMovieRuntime(movie.getMovieRuntime());
	    		cleanedMovie.setMovieTitle(movie.getMovieTitle());
	    		cleanedMovie.setMovieNation(movie.getMovieNation());
	    		cleanedMovie.setMovieOpen(movie.getMovieOpen());
	    		cleanedMovie.setMovieContent(movie.getMovieContent());
	    		cleanedMovie.setMovieImg1(movie.getMovieImg1());
	    		cleanedMovie.setMovieImg2(movie.getMovieImg2());
	    		cleanedMovie.setMovieImg3(movie.getMovieImg3());
	    		cleanedMovie.setMovieImg4(movie.getMovieImg4());
	    		cleanedMovie.setMovieImg5(movie.getMovieImg5());
	    		cleanedMovie.setMovieImg6(movie.getMovieImg6());
	    		cleanedMovie.setMovieUploader(movie.getMovieUploader());
	    		cleanedMovie.setMovieDirector(movie.getMovieDirector());
	    		cleanedMovie.setMovieCast(movie.getMovieCast());
	    		cleanedMovie.setMovieRegdate(movie.getMovieRegdate());
	    		cleanedMovie.setMovieSt(movie.getMovieSt());
	        
	    		cleanedList.add(cleanedMovie);
	    	}
	    	Map<String, Object> getMovieList = new HashMap<String, Object>();
	    	getMovieList.put("cleanedList", cleanedList);
		
		return getMovieList;
	}

	// 메인 상영중인 영화 목록 가지고 오기 - 7개
	@Override
	public Map<String, Object> mainMovieList() {
		List<Movie> movielist = dao.mainMovieList();
		// movielist에서 따온 값 가공하기
	    List<Movie> cleanedList = new ArrayList<>();
	    	for (Movie movie : movielist) {
	    		Movie cleanedMovie = new Movie();
	    		cleanedMovie.setMgNo(Util.removeQuotes(movie.getMgNo()));
	    		cleanedMovie.setGenreName(Util.removeQuotes(movie.getGenreName()));
	    		cleanedMovie.setMovieNo(movie.getMovieNo());
	    		cleanedMovie.setMovieRuntime(movie.getMovieRuntime());
	    		cleanedMovie.setMovieTitle(movie.getMovieTitle());
	    		cleanedMovie.setMovieNation(movie.getMovieNation());
	    		cleanedMovie.setMovieOpen(movie.getMovieOpen());
	    		cleanedMovie.setMovieContent(movie.getMovieContent());
	    		cleanedMovie.setMovieImg1(movie.getMovieImg1());
	    		cleanedMovie.setMovieImg2(movie.getMovieImg2());
	    		cleanedMovie.setMovieImg3(movie.getMovieImg3());
	    		cleanedMovie.setMovieImg4(movie.getMovieImg4());
	    		cleanedMovie.setMovieImg5(movie.getMovieImg5());
	    		cleanedMovie.setMovieImg6(movie.getMovieImg6());
	    		cleanedMovie.setMovieUploader(movie.getMovieUploader());
	    		cleanedMovie.setMovieDirector(movie.getMovieDirector());
	    		cleanedMovie.setMovieCast(movie.getMovieCast());
	    		cleanedMovie.setMovieRegdate(movie.getMovieRegdate());
	    		cleanedMovie.setMovieSt(movie.getMovieSt());
	        
	    		cleanedList.add(cleanedMovie);
	    	}
	    	Map<String, Object> getMovieList = new HashMap<String, Object>();
	    	getMovieList.put("cleanedList", cleanedList);
		
		return getMovieList;
	}
	
	// 관리자 페이지 상영 조회
	@Override
	public Map<String, Object> managerMovieList(int cp) {
		// 현재 상영중인 영화 수 조회
		int cinemaCount = dao.getNowPlayCount();

		// 조회한 현재 상영중인 영화 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, cinemaCount);

		// 영화관 리스트 조회
		List<Movie> playMovieList = dao.getPlayList(pagination);
		
		Map<String, Object> getMovieList = new HashMap<String, Object>();
		getMovieList.put("pagination", pagination);
		getMovieList.put("playMovieList", playMovieList);
		
		return getMovieList;
	}
	
	
	
	
}
