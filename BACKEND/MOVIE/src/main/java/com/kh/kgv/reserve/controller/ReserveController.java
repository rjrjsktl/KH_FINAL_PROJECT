package com.kh.kgv.reserve.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
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
	public String enterChoicePlay(Model model) {
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
				joinPlayList = service.getMoviePlayList(cinemaNo, strDate, movieNo);
			} else if(movieOptionIndex.equals("1")) {
				thumbList = service.getPlayingThumbList();
				movieNo = thumbList.get(Integer.parseInt(movieIndex)).getMovieNo();
				joinPlayList = service.getMoviePlayList(cinemaNo, strDate, movieNo);
			}
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		return joinPlayList;
	}
	
	
	
	@GetMapping("/selectPlay")
	@ResponseBody
	public int selectPlay(HttpServletRequest req, String playNo) {
		int result = 0;
		
		try {
			HttpSession session = req.getSession();
			session.setAttribute("playNo", playNo);
		    System.out.println(playNo);
			result = 1;		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 추후 PostMapping으로 변경함
	
	@GetMapping("/choiceTicket")
	public String enterChoiceTicket(HttpServletRequest req, Model model) {
		
		try {
			HttpSession session = req.getSession();
			int playNo = Integer.parseInt( (String) session.getAttribute("playNo"));
			JoinPlay userPlay = service.getUserPlay(playNo);
			model.addAttribute("userPlay", userPlay);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "reserve/choiceTicket";
	}
	
	
	@GetMapping("/loadPlay")
	@ResponseBody
	public JoinPlay LoadPlay(HttpServletRequest req) {
		JoinPlay userPlay = null;
		String priceDay = null;
		String priceTime = null;
		String screenStyle = null;
		
		try {
			HttpSession session = req.getSession();
			int playNo = Integer.parseInt( (String) session.getAttribute("playNo"));
			userPlay = service.getUserPlay(playNo);

			screenStyle = userPlay.getScreen().getScreenStyle();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate = formatter.parse(userPlay.getPlay().getPlayStart());
			Calendar cal = Calendar.getInstance() ;
			cal.setTime(startDate);
			
			if(cal.get(Calendar.DAY_OF_WEEK) >=1 && cal.get(Calendar.DAY_OF_WEEK) <=4) {
				priceDay = "평일";
			} else {
				priceDay = "주말";
			}
			
			if(cal.get(Calendar.HOUR) > 12) {
				priceTime = "오전";
			} else {
				priceTime = "오후";
			}
			
			System.out.println(priceDay + " " + priceTime);
			int priceNo = service.getPriceNo(screenStyle, priceDay, priceTime);
			System.out.println(priceNo);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userPlay;
	}
	
}
