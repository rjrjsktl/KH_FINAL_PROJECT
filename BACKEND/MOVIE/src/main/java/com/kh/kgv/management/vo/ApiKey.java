package com.kh.kgv.management.vo;

import com.kh.kgv.helpDesk.model.vo.LostPagenation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {
	
	//네아로
	private String naverKey = "zbgd6cEyo8jMiPuWLAHo";
	private String naverAddress = "https://kgv.co.kr/movie/sign_Up/sns/naver";
	private String naverSecret = "SduvBv1SRj";
	
	//카카오
	private String kakaoKey = "2efba8f52b3a5151a0a8fdbfc437d7b2";
	private String kakaoAddress = "https://kgv.co.kr/movie/sign_Up/sns/kakao";
	
	//스토어 API key
	private String iamportKey = "0627322105730646";
	private String iamportSecretKey = "JzwxnKxJni1QUcFAIZF514JQfFWxBWCVhWwYuNqY2Y5OTEWzCMMesOjkwDua393IiXeGJwmkBZ87XYkS";
	
	// 티켓 API key
	private String ticketKey= "1212046075703083";
	private String ticketSecretKey= "0aTIevttJkDRmm2iLKZSTbstVQ6wPUVjq9Ijg1X1xy6AtrSO3opsXaKPfKKueEhf2GNsv5T2CKl9Fe1X";

}
