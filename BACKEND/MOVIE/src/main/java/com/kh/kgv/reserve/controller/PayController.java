package com.kh.kgv.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	// 결제페이지로 이동하기
	@GetMapping("/pay")
	public String movePay() {
		
		
		return "pay/pay";
	}
	

}
