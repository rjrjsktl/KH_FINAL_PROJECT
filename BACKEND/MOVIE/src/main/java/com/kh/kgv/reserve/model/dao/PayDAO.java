package com.kh.kgv.reserve.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.store.model.vo.StoreCoupon;

@Repository
public class PayDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 예매금액 찾기
	public String serchPrice(int bookNo) {
		return sqlSession.selectOne("playMapper.serchPrice", bookNo);
	}
	
	// 관람 쿠폰 검색
	public List<StoreCoupon> selectCoupon(String couponNo) {
		return sqlSession.selectList("playMapper.selectCoupon", couponNo);
	}
	

}
