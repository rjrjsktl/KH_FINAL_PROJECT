package com.kh.kgv.management.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManageEventDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

}
