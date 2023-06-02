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
	

	
	
	
	
	
	
	
	
	
}
