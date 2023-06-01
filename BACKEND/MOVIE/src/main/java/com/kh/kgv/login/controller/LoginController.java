package com.kh.kgv.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@SessionAttributes({"loginUser"}) // Model에 추가된 값의 key와 어노테이션에 작성된 값이 같으면
// 해당 값을 session scope 이동시키는 역할
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired // bean으로 등록된 객체 중 타입이 같거나, 상속 관계인 baen을 주입 해주는 역할
	private LoginService service;   // -> 의존성 주입(DI, Dependency Injection)
	
	
	// 로그인 페이지 들어가기
	@GetMapping("/login")
	public String enterLogin() {
		return "login/login";
	}
	
	
	// 로그인	
	@PostMapping("/login")
	public String login(@ModelAttribute User inputUser 
			, Model model
			, RedirectAttributes ra
			, HttpServletResponse resp 
			, HttpServletRequest req
			, @RequestParam(value="saveId", required = false) String saveId ) {
		
		logger.info("로그인 기능 수행됨");
		
		User loginUser = service.login(inputUser);
		
		if(loginUser != null) { // 로그인 성공 시
			model.addAttribute("loginUser", loginUser); // == req.setAttribute("loginMember", loginMember);
	
			
			// 로그인 성공 시 무조건 쿠키 생성
			// 단, 아이디 저장 체크 여부에 따라서 쿠기의 유지 시간을 조정
			Cookie cookie = new Cookie("saveId", loginUser.getUserEmail());
			
			if(saveId != null) { // 아이디 저장이 체크 되었을 때
				
				cookie.setMaxAge(60 * 60 * 24 * 365); // 초 단위로 지정 (1년)
				
			} else { // 체크 되지 않았을 때
				cookie.setMaxAge(0); // 0초 -> 생성 되자마자 사라짐 == 쿠키 삭제
			}
			
			
			// 쿠키가 적용될 범위(경로) 지정
			cookie.setPath(req.getContextPath());
			
			// 쿠키를 응답 시 클라이언트에게 전달
			resp.addCookie(cookie);
			
			
			
		} else {
			//model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			// -> redirect 시 잠깐 Session scope로 이동후
			//    redirect가 완료되면 다시 Request scope로 이동
			
			// redirect 시에도 request scope로 세팅된 데이터가 유지될 수 있도록 하는 방법을
			// Spring에서 제공해줌
			// -> RedirectAttributes 객체  (컨트롤러 매개변수에 작성하면 사용 가능)
		}
		
		//session.setAttribute("loginUser", loginUser);
		logger.info("마지막 로그인 기능 수행됨");
		
		//return "redirect:/";
		return "login/login_welcome";
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
