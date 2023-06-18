package com.kh.kgv.movieList.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.common.Util;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Pagination;
import com.kh.kgv.movieList.model.dao.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDAO dao;
	
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
	        
	    		cleanedList.add(cleanedMovie);
	    	}
	    	Map<String, Object> getMovieList = new HashMap<String, Object>();
	    	getMovieList.put("cleanedList", cleanedList);
		
		return getMovieList;
	}
	
}
