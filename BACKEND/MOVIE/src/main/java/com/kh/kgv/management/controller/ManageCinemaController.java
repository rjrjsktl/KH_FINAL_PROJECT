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
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Screen;

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
		
		Cinema cinema = new Cinema();
		Screen screen;

		cinema.setCinemaName(cinemaName);
		cinema.setCinemaArea(getCinemaArea(cinemaAddr[1].substring(0, 2)));
		cinema.setCinemaRegion(String.join(",,", cinemaAddr));
		cinema.setCinemaScreen(screenDetail.length);
		
		int cinemaResult = service.enrollCinema(cinema);
		int screenResult = 0;

		for(int i=0; i<screenDetail.length; i++) {
			// 추가용 원본 제외
			if(i==0) continue;
			
			screen = new Screen();
			screen.setCinemaName(cinemaName);
			screen.setScreenName(i);
			screen.setScreenStyle(screenStyle[i]);
			screen.setScreenSeat(Integer.parseInt(screenSeat[i]));
			screen.setScreenDetail(screenDetail[i].replace("&quot;", "\""));

			screenResult += service.enrollScreen(screen);
		}
		
		
		if(cinemaResult == 1 && screenResult == (screenDetail.length-1)) {
			System.out.println("등록 성공");
			return "redirect:/";
		} else {
			System.out.println("등록 실패");
			return "redirect:/manager/main";
		}
		
	}
	
	
	@GetMapping("/cinemaDupCheck")
	@ResponseBody
	public int cinemaDupCheck(String cinemaName) {
		System.out.println(cinemaName);
		int result = service.cinemaDupCheck(cinemaName);
		return result;
	} 
	
	
	public String getCinemaArea(String area) {
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
		
		return cinemaArea;
		
	}

}
