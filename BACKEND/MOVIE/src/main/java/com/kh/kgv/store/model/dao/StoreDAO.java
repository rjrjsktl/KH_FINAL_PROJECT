package com.kh.kgv.store.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.items.model.vo.Store;

@Repository
public class StoreDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Store> getStoreList() {
		return sqlSession.selectList("storeMapper.getStoreList");
	}

}
