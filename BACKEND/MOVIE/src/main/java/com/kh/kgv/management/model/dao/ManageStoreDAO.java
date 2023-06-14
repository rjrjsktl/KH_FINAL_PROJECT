package com.kh.kgv.management.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManageStoreDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int titleDupCheck(String storeTitle) {
		return sqlSession.selectOne("storeMapper.titleDupCheck", storeTitle );
		
	}
}
