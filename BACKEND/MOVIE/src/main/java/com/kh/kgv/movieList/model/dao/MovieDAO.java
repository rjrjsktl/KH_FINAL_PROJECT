package com.kh.kgv.movieList.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Movie;

@Repository
public class MovieDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Movie movieList() {
		return null;
	}
}
