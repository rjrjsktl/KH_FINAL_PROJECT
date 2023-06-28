package com.kh.kgv.theater.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.management.model.service.ManagerService;


@Controller
@RequestMapping("/theater")
@SessionAttributes({ "loginUser" })
public class TheaterController {

	@Autowired
	private ManagerService service;


	@GetMapping("/normalTheater")
	public String normarTheater(	Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp) {

		Map<String, Object>getNoticeList = null;

		// 회원 리스트 얻어오기
		getNoticeList = service.noticeList(cp);
		
		model.addAttribute("getNoticeList", getNoticeList);

		System.out.println("관리자_공지사항 목록 이동");
		return "theater/normalTheater";
	}


	@RequestMapping("/specialTheater")
	public String specialTheater() {
		return "theater/specialTheater";
	}


	@RequestMapping("/theaterS")
	public String specialS() {
		return "theater/theaterS";
	}

	@RequestMapping("/theaterS2")
	public String specialS2() {
		return "theater/theaterS2";
	}

	@RequestMapping("/theaterS3")
	public String specialS3() {
		return "theater/theaterS3";
	}

	@RequestMapping("/theaterS4")
	public String specialS4() {
		return "theater/theaterS4";
	}

	@RequestMapping("/theaterS5")
	public String specialS5() {
		return "theater/theaterS5";
	}


}
