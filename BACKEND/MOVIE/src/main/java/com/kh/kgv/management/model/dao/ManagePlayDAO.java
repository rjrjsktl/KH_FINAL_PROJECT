package com.kh.kgv.management.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.management.model.vo.Cinema;

@Repository
public class ManagePlayDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Cinema> getAreaCinemaList(String areaName) {
		return sqlSession.selectList("cinemaMapper.getAreaCinemaList", areaName);
	}

}
