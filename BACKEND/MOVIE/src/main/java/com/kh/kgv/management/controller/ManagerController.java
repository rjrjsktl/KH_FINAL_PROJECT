package com.kh.kgv.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	// 관리자_메인페이지 이동
	@GetMapping("/main")
	public String moveMain() {
		System.out.println("관리자_메인페이지 이동");
		return "manager/managerPage";
	}
	
	// 관리자_회원 리스트 이동
	@GetMapping("/member")
	public String moveMember() {
		System.out.println("관리자_회원 리스트 이동");
		return "manager/manager_member_list";
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
