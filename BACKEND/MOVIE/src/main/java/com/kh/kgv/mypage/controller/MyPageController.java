package com.kh.kgv.mypage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.mypage.model.service.MyPageService;

@Controller
@RequestMapping("/myPage")
@SessionAttributes({"loginUser"}) // session scope에서 loginMember를 얻어옴
public class MyPageController {

	private Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private MyPageService service;
	
	// 마이페이지 첫번째 화면 - info변경가능
	@GetMapping("/info")
	public String info() {
		return "myPage/myPage_info";
	}
	
	@GetMapping("/board")
	public String board() {
		return "myPage/myPage_myBoard";
	}
	
	@GetMapping("/reservationCf")
	public String reservationCf() {
		return "myPage/myPage_reservationCf";
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "myPage/myPage_changePw";
	}
	
	@GetMapping("/secession")
	public String secession() {
		return "myPage/myPage_secession";
	}
	
	// 회원 정보 수정
	
	
	
	// 회원 비밀번호 변경
		
	
	
	
	
	// 회원 탈퇴
	@PostMapping("/secession") 						// session 의 회원정보 + 입력받은 파라미터(비밀번호)
	public String secession( @ModelAttribute("loginUser") User loginUser,
							SessionStatus status,
							HttpServletRequest req,
							HttpServletResponse resp,
							RedirectAttributes ra ) {
		
		
		// 회원 탈퇴 서비스 호출
		int result = service.secession(loginUser);
		
		
		String message = null;
		String path = null;
		
		if(result > 0) {
			// 탈퇴 성공 -> 메인페이지
			message = "탈퇴 되었습니다";
			path = "/";
			
			// 세션 없애기
			status.setComplete(); 
			
			
			// 쿠키 없애기
			Cookie cookie = new Cookie("saveId", "");
			cookie.setMaxAge(0);
			cookie.setPath(req.getContextPath());
			resp.addCookie(cookie);
			
			
		} else {
			// 탈퇴 실패 -> secession
			message = "현재 비밀번호가 일치하지 않습니다.";
			path = "secession";
			
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:" + path;
	}
	
	
	// 리뷰나 영화예매내역 같은건 하나 더 만들생각 ㄱㄱ
	
	
	
	
	
	
	
}
