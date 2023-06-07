package com.kh.kgv.management.model.service;

import java.util.List;
import java.util.Map;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;

public interface ManagerService {

	// 회원 목록 조회
	Map<String, Object> selectAll(int cp);

	// 회원 관리자 상태 업데이트
	int updateST(User user);

	// 영화 등록 서비스
	int MovieAdd(Movie inputMovie);

}
