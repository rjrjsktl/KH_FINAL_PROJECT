package com.kh.kgv.reserve.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Play;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;
import com.kh.kgv.reserve.model.service.ReserveService;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	
	@Autowired
	private ReserveService service;
	
	private String[] areaArray = {"서울", "경기", "충청", "전라", "경남", "경북", "강원", "제주"};
	private List<Cinema> cinemaList = null;
	private List<Movie> movieList = null;
	private List<Movie> thumbList = null;
	private List<JoinPlay> joinPlayList = null;
	private Map<String, Object> reserveMap = null;
	

	@GetMapping("/choicePlay")
	public String enterReserve(Model model) {
		reserveMap = new HashMap<>(); 
		movieList = service.getPlayingMovieList();
		thumbList = service.getPlayingThumbList();
		cinemaList = service.getAreaCinemaList("서울");
		
		reserveMap.put("movieList", movieList);
		reserveMap.put("thumbList", thumbList);
		reserveMap.put("cinemaList", cinemaList);
		model.addAttribute("reserveMap", reserveMap);
		
		return "reserve/choicePlay";
	}
	
	
	@GetMapping("/cinemaList")
	@ResponseBody
	public List<Cinema> getCinemaList(String areaIndex) {
		try {
			String areaName = areaArray[Integer.parseInt(areaIndex)];
			cinemaList = service.getAreaCinemaList(areaName);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		
		return cinemaList;
	}
	
	
	@GetMapping("/playList")
	@ResponseBody
	public List<JoinPlay> getTotalPlayList(String areaIndex, String cinemaIndex, String dateIndex ) {
		
		try {
			String areaName = areaArray[Integer.parseInt(areaIndex)];
			cinemaList = service.getAreaCinemaList(areaName);
			int cinemaNo = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaNo();
			
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime date = now.plusDays(Integer.parseInt(dateIndex));
			String strDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			
			joinPlayList = service.getTotalPlayList(cinemaNo, strDate);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		return joinPlayList;
	}
	
	
	@GetMapping("/moviePlayList")
	@ResponseBody
	public List<JoinPlay> getMoviePlayList(String areaIndex, String cinemaIndex, String dateIndex, 
			                               String movieOptionIndex, String movieIndex ) {
		
		try {
			String areaName = areaArray[Integer.parseInt(areaIndex)];
			cinemaList = service.getAreaCinemaList(areaName);
			int cinemaNo = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaNo();
			int movieNo;
			
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime date = now.plusDays(Integer.parseInt(dateIndex));
			String strDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			
			if(movieOptionIndex.equals("0")) {
				movieList = service.getPlayingMovieList();
				movieNo = movieList.get(Integer.parseInt(movieIndex)).getMovieNo();
				joinPlayList = service.getMovieNamePlayList(cinemaNo, strDate, movieNo);
			} else if(movieOptionIndex.equals("1")) {
				thumbList = service.getPlayingThumbList();
				movieNo = thumbList.get(Integer.parseInt(movieIndex)).getMovieNo();
				joinPlayList = service.getMovieRankPlayList(cinemaNo, strDate, movieNo);
			}
			
			
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		return joinPlayList;
	}
	
	
}
