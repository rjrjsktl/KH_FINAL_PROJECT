package com.kh.kgv.benefits.model.service;

import java.util.Map;

public interface BenefitsService {
	
	// 진행중인 혜택 리스트 불러오기
	Map<String, Object> getBenefitsList();

}
