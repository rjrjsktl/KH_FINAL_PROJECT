package com.kh.kgv.theater.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.theater.model.service.TheaterService;
import com.kh.kgv.theater.model.vo.Screen;


@Controller
@RequestMapping("/theater")
@SessionAttributes({ "loginUser" })
public class TheaterController {

	@Autowired
	private ManagerService service;

	@Autowired
	private TheaterService services;

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


	//	Map<String, Object>cinemaList = null;
	//	cinemaList = services.cinemaList();

	@RequestMapping("/specialTheater/{theaterID}")
	public String specialTheater(
			Model model,
			@PathVariable("theaterID") int theaterID
			) {

		String special = null;
		if( theaterID ==1 ) {
			special = "KMAX";
		}else if(theaterID==2) {
			special = "DOLBY";
		}else if (theaterID==3) {
			special = "PUPPY &amp; ME";
		}else if(theaterID==4) {
			special = "YES KIDS";
		}else {
			special = "CHEF &amp; CINE";
		}
		
		List<Screen> screenInfo =  services.getScreenInfo(special);
		model.addAttribute("screenInfo", screenInfo);
		

		switch (theaterID) {
		case 1:
			return "theater/theaterS1";
		case 2:
			return "theater/theaterS2";
		case 3:
			return "theater/theaterS3";
		case 4:
			return "theater/theaterS4";
		case 5:
			return "theater/theaterS5";
		default:
			return "error";
		}


	}


}
