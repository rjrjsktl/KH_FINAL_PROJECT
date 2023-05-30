package com.kh.kgv.login;

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
	
	@RequestMapping("/findEmail")
	public String findEmail() {
		return "login/findEmail_1";
			
	}
	
	//회원가입 선택창
	@RequestMapping("/signUp_sns")
	public String signUp_sns() {
		return "signup/signup_sns";
	}
	
	
	//회원가입창 화면 전환
	@RequestMapping("/signUp")
	public String singup() {
		return "signup/signUp";
	}
	
	
	
	
	
	
}
