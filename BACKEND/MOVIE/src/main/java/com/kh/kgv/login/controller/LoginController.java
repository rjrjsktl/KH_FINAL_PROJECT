package com.kh.kgv.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.login.model.service.LoginService;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginUser")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String enterLogin() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User inputUser,
	                    Model model,
	                    RedirectAttributes ra,
	                    HttpServletResponse resp,
	                    HttpServletRequest req,
	                    @RequestParam(value="saveId", required=false) String saveId) {
		logger.info("로그인 기능 수행됨");
		
		User loginUser = service.login(inputUser);
		
		if (loginUser != null) { // 로그인 성공 시
			// 비밀번호 검증
			if (passwordEncoder.matches(inputUser.getUserPw(), loginUser.getUserPw())) {
				model.addAttribute("loginUser", loginUser);
				
				// 쿠키 생성
				Cookie cookie = new Cookie("saveId", loginUser.getUserEmail());
				
				if (saveId != null) { // 아이디 저장이 체크 되었을 때
					cookie.setMaxAge(60 * 60 * 24 * 365); // 1년 유지
				} else { // 체크 되지 않았을 때
					cookie.setMaxAge(0); // 쿠키 삭제
				}
				
				cookie.setPath(req.getContextPath()); // 쿠키의 경로 설정
				resp.addCookie(cookie); // 쿠키 전달
			} else {
				ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} else {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		logger.info("마지막 로그인 기능 수행됨");
		return "login/login_welcome";
	}
	
	@RequestMapping("/findPw")
	public String findPw() {
		return "login/findPw_1";
	}
	
	@RequestMapping("/findEmail")
	public String findEmail() {
		return "login/findEmail_1";
	}
	
	@RequestMapping("/signUp_sns")
	public String signUp_sns() {
		return "signUp/signUp_sns";
	}
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp/signUp";
	}
}