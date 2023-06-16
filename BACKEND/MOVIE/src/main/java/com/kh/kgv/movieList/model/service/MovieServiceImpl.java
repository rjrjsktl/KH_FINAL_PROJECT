package com.kh.kgv.movieList.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.movieList.model.dao.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDAO dao;

	@Override
	public Movie movieList() {
		return dao.movieList();
	}
	
	
}
