package com.kh.kgv.management.model.service;

import java.util.List;
import java.util.Map;

import com.kh.kgv.customer.model.vo.User;

public interface ManagerService {

	/** 회원 목록 조회
	 * @return
	 */
	Map<String, Object> selectAll(int cp);

}
