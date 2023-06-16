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

	public List<Movie> movieList() {
		
		return sqlSession.selectList("movieMapper.getMovieList", null);
	}
}
