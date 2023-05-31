package com.kh.kgv.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	// 로그인	
	@RequestMapping("/login")
	public String login(@ModelAttribute User inputUser 
			, Model model
			, RedirectAttributes ra
			, HttpServletResponse resp 
			, HttpServletRequest req
			, @RequestParam(value="saveId", required = false) String saveId 
			
			) {
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
