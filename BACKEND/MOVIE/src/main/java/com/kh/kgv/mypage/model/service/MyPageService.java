package com.kh.kgv.mypage.model.service;

import java.util.Map;

import com.kh.kgv.customer.model.vo.User;

public interface MyPageService {

	int secession(User loginUser);

	int changePw(Map<String, Object> paramMap);

}
