package com.kh.kgv.reserve.model.service;

import java.util.List;

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

}
