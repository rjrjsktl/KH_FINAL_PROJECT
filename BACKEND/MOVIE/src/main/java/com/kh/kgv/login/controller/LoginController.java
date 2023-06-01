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
@SessionAttributes({"loginUser"})
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	/** 로그인 페이지 진입
	 * @return
	 */
	@GetMapping("/login")
	public String enterLogin() {
		return "login/login";
	}
	
	
	/** 로그인 기능 실행
	 * @param inputUser
	 * @param model
	 * @param ra
	 * @param resp
	 * @param req
	 * @param saveId
	 * @return
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute User inputUser,
	                    Model model,
	                    RedirectAttributes ra,
	                    HttpServletResponse resp,
	                    HttpServletRequest req,
	                    @RequestParam(value="saveId", required=false) String saveId) {
		
		logger.info("1. 로그인 기능 수행 시작");
		
		
		// 아이디, 비밀번호가 일치하는 회원 정보를 조회하는 Service 호출 후 결과 반환 받기
		User loginUser = service.login(inputUser);
		
		logger.info("6. service 에서 받아온 loginUser : " + loginUser);
		
		if(loginUser != null) { // 로그인 성공 시
			
			logger.info("로그인 성공!");
			
			model.addAttribute("loginUser", loginUser);
			
			// 로그인 성공 시 무조건 쿠키 생성
			// 단, 아이디 저장 체크 여부에 따라서 쿠기의 유지 시간을 조정
			Cookie cookie = new Cookie("saveId", loginUser.getUserEmail());
			
			if(saveId != null) { // 아이디 저장이 체크 되었을 때
				
				cookie.setMaxAge(60 * 60 * 24 * 365); // 초 단위로 지정 (1년)
			
				logger.info("쿠키 생성!");
				
			} else { // 체크 되지 않았을 때
				cookie.setMaxAge(0); // 0초 -> 생성 되자마자 사라짐 == 쿠키 삭제
				
				logger.info("쿠기 삭제!");
			}
			
			
			// 쿠키가 적용될 범위(경로) 지정
			cookie.setPath(req.getContextPath());
			
			// 쿠키를 응답 시 클라이언트에게 전달
			resp.addCookie(cookie);
			
			
		} else {
			
			logger.info("로그인 실패");
			
			//model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			// -> redirect 시 잠깐 Session scope로 이동후
			//    redirect가 완료되면 다시 Request scope로 이동
			
			// redirect 시에도 request scope로 세팅된 데이터가 유지될 수 있도록 하는 방법을
			// Spring에서 제공해줌
			// -> RedirectAttributes 객체  (컨트롤러 매개변수에 작성하면 사용 가능)
			
			return "redirect:/user/login"; 
		}
		
		//session.setAttribute("loginMember", loginMember);
		
		
		logger.info("마지막 로그인 기능 수행됨");
		
//		return "redirect:/";
		
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
	
	
}