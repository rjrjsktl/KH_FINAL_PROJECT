package com.kh.kgv.management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.management.model.service.ManagerService;

@Controller
@RequestMapping("/manager")
@SessionAttributes({"loginUser"})
public class ManagerController {
	
	@Autowired
	private ManagerService service;

	// 관리자_메인페이지 이동
	@GetMapping("/main")
	public String moveMain() {
		System.out.println("관리자_메인페이지 이동");
		return "manager/managerPage";
	}
	
	// 관리자_회원 리스트 이동
	@GetMapping("/member")
	public String moveMember(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp
			) {
		Map<String, Object>getUserList = null;
		
		// 회원 리스트 얻어오기
		 getUserList = service.selectAll(cp);
		
	model.addAttribute("getUserList", getUserList);
	
	System.out.println("관리자_회원 리스트 이동");
		return "manager/manager_member_list";
	}

	
	// 관리자 상태 변경
	@PostMapping("/Manager_ST")
		public int changeMgSt(
			@RequestParam("ST") String st
			,@RequestParam("userId") String userId
				) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + st);
		System.out.println("AJAX로 가지고 온 userId의 값은 : " + userId);
		
		int  result  =  1 ;
		
		result = 0;		
		
			return result;
	}
	
	
	
	
	
	// 관리자_1:1 문의 목록 이동
	@GetMapping("/ask_list")
	public String moveAskList() {
		System.out.println("관리자_1:1 문의 목록 이동");
		return "manager/manager_ask_list";
	}
	
	// 관리자_영화 목록 이동
	@GetMapping("/movie_list")
	public String moveMovieList() {
		System.out.println("관리자_영화 목록 이동");
		return "manager/manager_movie_list";
	}
	
	// 관리자_영화 등록 이동
	@GetMapping("/movie_add")
	public String moveMovieAdd() {
		System.out.println("관리자_영화 등록 이동");
		return "manager/manager_movie_add";
	}
	
	// 관리자_상영시간 목록 이동
	@GetMapping("/play_list")
	public String movePlayList() {
		System.out.println("관리자_상영시간 목록 이동");
		return "manager/manager_movie_play_list";
	}
	
	// 관리자_상영시간 등록 이동
	@GetMapping("/play_add")
	public String movePlayAdd() {
		System.out.println("관리자_상영시간 등록 이동");
		return "manager/manager_movie_play_add";
	}
	
	// 관리자_이벤트 목록 이동
	@GetMapping("/event_list")
	public String moveEventList() {
		System.out.println("관리자_이벤트 목록 이동");
		return "manager/manager_event_list";
	}
	
	// 관리자_이벤트 등록 이동
	@GetMapping("/event_add")
	public String moveEventAdd() {
		System.out.println("관리자_이벤트 등록 이동");
		return "manager/manager_event_add";
	}
	
	// 관리자_공지사항 목록 이동
	@GetMapping("/notice_list")
	public String moveNoticeList() {
		System.out.println("관리자_공지사항 목록 이동");
		return "manager/manager_notice_list";
	}
	
	// 관리자_공지사항 등록 이동
	@GetMapping("/notice_add")
	public String moveNoticeAdd() {
		System.out.println("관리자_공지사항 등록 이동");
		return "manager/manager_notice_add";
	}
	
}
