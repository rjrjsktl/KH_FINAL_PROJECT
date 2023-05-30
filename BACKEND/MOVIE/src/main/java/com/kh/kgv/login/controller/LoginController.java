package com.kh.kgv.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	// 로그인	
	@RequestMapping("/login")
	public String login() {
		return "login/login";
			
	}
	
	// 비밀번호찾기
	@RequestMapping("/findPw")
	public String findPw() {
		return "login/findPw_1";
			
	}
	
	// 아이디 찾기
	@RequestMapping("/findEmail")
	public String findEmail() {
		return "login/findEmail_1";
			
	}
	
	// 회원가입 sns 화면
	@RequestMapping("/signUp_sns")
	public String signUp_sns() {
		return "signUp/signUp_sns";
	}
		
	// 이메일 회원가입 창
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp/signUp";
	}
	
	
}
