package com.kh.kgv.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.management.model.service.ManageCinemaService;
import com.kh.kgv.common.Util;

@Controller
@RequestMapping("/manager/manager_cinema_add")
@SessionAttributes({ "loginUser" })
public class ManageCinemaController {
	
	@Autowired
	private ManageCinemaService service;
	
	// private Logger logger = LoggerFactory.getLogger(ManageCinemaController.class);

	@PostMapping("/test")
	public String enrollCinema(
			@RequestParam("cinemaName") String cinemaName,
			@RequestParam("cinemaAddr") String[] cinemaAddr,
			@RequestParam("screenStyle") String[] screenStyle,
			@RequestParam("screenSeat") String[] screenSeat,
			@RequestParam("screenDetail") String[] screenDetail
			) {
	
		String area = cinemaAddr[1].substring(0, 2);
		String cinemaArea;
		
		switch(area) {
			case "서울":
				cinemaArea = "서울";
				break;
			case "경기": case "인천":
				cinemaArea = "경기";
				break;
			case "충남": case "충북": case "대전": case "세종":
				cinemaArea = "충청";
				break;
			case "전남": case "전북": case "광주":
				cinemaArea = "전라";
				break;
			case "경남": case "부산": case "울산":
				cinemaArea = "경남";
				break;
			case "경북": case "대구":
				cinemaArea = "경북";
				break;
			case "강원":
				cinemaArea = "강원";
				break;
			case "제주":
				cinemaArea = "제주";
				break;
			default:
				cinemaArea = "없음";
		}
		
		String cinemaRegion = String.join(",,", cinemaAddr);   
		int cinemaScreen = screenDetail.length;
		
		/*
		for(int i=0; i<screenDetail.length; i++) {
			System.out.println((i+1)+ "관 : " +screenDetail[i].replace("&quot;", "\""));
		}
		*/
		
		int cinemaResult = service.enrollCinema(cinemaName, cinemaArea, cinemaRegion, cinemaScreen);
		System.out.println(cinemaResult);
		
		int screenResult = 0;
		

		for(int i=0; i<screenDetail.length; i++) {
			
			int seat = Integer.parseInt(screenSeat[i]);
			String detail = screenDetail[i].replace("&quot;", "\"");
			
			int r = service.enrollScreen(cinemaName, (i+1), screenStyle[i], seat, detail);
			System.out.println(r);
		}
		
		return "redirect:/manager/main";
	}
	
	
	@GetMapping("/cinemaDupCheck")
	@ResponseBody
	public int cinemaDupCheck(String cinemaName) {
		System.out.println(cinemaName);
		int result = service.cinemaDupCheck(cinemaName);
		return result;
	} 

}
