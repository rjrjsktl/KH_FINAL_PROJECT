package com.kh.kgv.reserve.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.reserve.model.dao.PayDAO;
import com.kh.kgv.reserve.model.dao.ReserveDAO;
import com.kh.kgv.store.model.vo.StoreCoupon;

@Service
public class PayServiceImpl implements PayService {
	
	@Autowired
	private PayDAO dao;
	
	// 예매금액 찾기
	@Override
	public String serchPrice(int bookNo) {
		
		return dao.serchPrice(bookNo);
	}
	
	// 관람권 코드 검색
	@Override
	public List<StoreCoupon> selectCoupon(String couponNo) {
		return dao.selectCoupon(couponNo);
	}
	
	// 관람권 상태 변경
	@Override
	public int updateTicketStatus(String couponNo) {
		
		Map<String, Object> CT = new HashMap<>();
		
		CT.put("couponDetailNo", couponNo);
		
		
		return dao.updateTicketStatus(CT);
	}
	
	// 좌석 수 확인
	@Override
	public int checkSeatCount(int bookNo) {
		String seat = dao.checkSeat(bookNo);
		return seat.split(",").length;
	}
	
	// 쿠폰 카테고리 검색
	@Override
	public String serchCategory(String couponNo) {
		return dao.serchCategory(couponNo);
	}

}