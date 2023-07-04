package com.kh.kgv.reserve.model.service;

import java.util.List;

import com.kh.kgv.store.model.vo.StoreCoupon;

public interface PayService {
	
	// 예매금액 찾기
	String serchPrice(int bookNo);
	
	// 관람권 코드 검색
	List<StoreCoupon> selectCoupon(String couponNo);
	
	// 관람권 상태 변경 
	int updateTicketStatus(String couponNo);
	
	// 좌석 수 확인
	int checkSeatCount(int bookNo);
	
	// 쿠폰 카테고리 검색
	String serchCategory(String couponNo);

}
