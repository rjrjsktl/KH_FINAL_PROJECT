package com.kh.kgv.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.items.model.vo.TimeCheck;
import com.kh.kgv.management.model.service.ManagePlayService;
import com.kh.kgv.management.model.vo.Cinema;

@Controller
@RequestMapping("/manager/play_add")
@SessionAttributes({ "loginUser" })
public class ManagePlayController {
	
	@Autowired
	private ManagePlayService service;
	
	private String[] areaArray = {"서울", "경기", "충청", "전라", "경남", "경북", "강원", "제주"};
	private List<Cinema> cinemaList = null;
	private List<Movie> movieList = null;
	
	private String areaName;
	private String cinemaName;
	private int screenName;
	private String runTime;
	private int startTime;
	private int endTime;
	private int movieNo;
	
	
	@GetMapping("/areaCinemaList")
	@ResponseBody
	public List<Cinema> getAreaCinemaList(String areaIndex) {
		
		try {
		    areaName = areaArray[Integer.parseInt(areaIndex)];
		    cinemaList = service.getAreaCinemaList(areaName);
		    System.out.println(areaName);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		
		return cinemaList;
	}
	

	@GetMapping("/playTimeCheck")
	@ResponseBody
	public List<Play> playTimeCheck(String areaIndex, String cinemaIndex, String screenIndex, 
			                        String movieIndex, String timeIndex, String startDate, String endDate) {
		
		List<Play> playList = null;
		
		try {
			
			playList = timeCheck(areaIndex, cinemaIndex, screenIndex, movieIndex, timeIndex, startDate, endDate);

		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}

		return playList;
	}

	
	
	@PostMapping("/enroll")
	public String enrollPlay(String areaIndex, String cinemaIndex, String screenIndex, 
                             String movieIndex, String timeIndex, String startDate, String endDate) {
		
        List<Play> playList = null;
        String url = "redirect:/";
		
		try {
			
			playList = timeCheck(areaIndex, cinemaIndex, screenIndex, movieIndex, timeIndex, startDate, endDate);

		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		
		if(playList.size() == 0) {
			areaName = areaArray[Integer.parseInt(areaIndex)];
		    cinemaList = service.getAreaCinemaList(areaName);
		    cinemaName = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaName();
		    screenName = Integer.parseInt(screenIndex) + 1;
			
		    movieList = service.getPlayingMovieList();
		    movieNo = movieList.get(Integer.parseInt(movieIndex)).getMovieNo();
		    
		    int result = service.enrollPlay(cinemaName, screenName, movieNo, startTime, endTime, startDate, endDate);
		    
		    if(result > 0) {
		    	url = "redirect:/manager/main";
		    }
		    
		}
		
		return url;
	}
	
	
	
	public List<Play> timeCheck(String areaIndex, String cinemaIndex, String screenIndex, 
                                String movieIndex, String timeIndex, String startDate, String endDate) {
		
		List<Play> playList = null;
		
		TimeCheck tc = new TimeCheck();
		tc.setAreaIndex(areaIndex);
		tc.setCinemaIndex(cinemaIndex);
		tc.setScreenIndex(screenIndex);
		tc.setMovieIndex(movieIndex);
		tc.setTimeIndex(timeIndex);
		tc.setStartDate(startDate);
		tc.setEndDate(endDate);

		
		areaName = areaArray[Integer.parseInt(areaIndex)];
	    cinemaList = service.getAreaCinemaList(areaName);
	    cinemaName = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaName();
	    screenName = Integer.parseInt(screenIndex) + 1;
	    
	    // 시작시각과 종료시각은 00시 정각을 기준으로 몇 분 이상 지났는지 계산합니다.
	    
	    movieList = service.getPlayingMovieList();
	    runTime = movieList.get(Integer.parseInt(movieIndex)).getMovieRuntime();
	    startTime = Integer.parseInt(timeIndex) * 30;
	    endTime = startTime + Integer.parseInt(runTime);
	    
	    tc.setStartTime(startTime);
	    tc.setEndTime(endTime);
	    
	    playList = service.playTimeCheck(cinemaName, screenName, startTime, endTime, startDate, endDate);
	    
	    System.out.println(areaName + " " + cinemaName + " " + screenName + "관");
	    System.out.println(startTime + " ~ " + endTime);
	    
	    if(playList.size() == 0) {
	    	System.out.println("겹치는 것 없어요.");
	    }
	    if(playList.size() != 0) {
	    	playList = service.getDupTime(tc);
	    	System.out.println("중복될 때 가지고온 playList : " + playList);
	    }
		
		return playList;
		
	}

}
