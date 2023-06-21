package com.kh.kgv.mypage.model.service;

import java.util.List;
import java.util.Map;

import com.kh.kgv.customer.model.vo.Review;
import com.kh.kgv.customer.model.vo.User;

public interface MyPageService {

	// 회원 탈퇴
	int secession(User loginUser);

	// 비밀번호 변경
	int changePw(Map<String, Object> paramMap);

	// 회원 정보 변경
	int updateInfo(Map<String, Object> paramMap);

	// review카드 불러오기
	List<Review> myReviewList(int userNo);

}
