package com.kh.kgv.reserve.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.CinemaPrice;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.reserve.model.service.ReserveService;

@Controller
@RequestMapping("/reserve")
@SessionAttributes({ "loginUser" })
public class ReserveController {
	
	@Autowired
	private ReserveService service;
	
	private String[] areaArray = {"서울", "경기", "충청", "전라", "경남", "경북", "강원", "제주"};
	private List<Cinema> cinemaList = null;
	private List<Movie> movieList = null;
	private List<Movie> thumbList = null;
	private List<JoinPlay> joinPlayList = null;
	private Map<String, Object> reserveMap = null;
	private Map<String, Object> priceMap = null; 
	

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
	public List<JoinPlay> getTotalPlayList(String areaIndex, String cinemaIndex, String dateIndex ) throws Exception {
		
		try {
			String areaName = areaArray[Integer.parseInt(areaIndex)];
			joinPlayList = service.getTotalPlayList(areaName, cinemaIndex, dateIndex);
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
			joinPlayList = service.getMoviePlayList(areaName, cinemaIndex, dateIndex, movieOptionIndex, movieIndex);
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
	public JoinPlay LoadPlay(HttpServletRequest req) throws Exception {
		JoinPlay userPlay = null;

		try {
			HttpSession session = req.getSession();
			int playNo = Integer.parseInt( (String) session.getAttribute("playNo"));
			userPlay = service.getUserPlay(playNo);
			
			int priceNo = service.getPriceNo(playNo);
			session.setAttribute("priceNo", priceNo);
			System.out.println(priceNo);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userPlay;
	}
	
	
	@PostMapping("/updatePrice")
	@ResponseBody
	public Map<String, Object> updatePrice(HttpServletRequest req, String partialCountArray) throws Exception {
		
		try {
			HttpSession session = req.getSession();
			int priceNo = (int) session.getAttribute("priceNo");
			partialCountArray = partialCountArray.replaceAll("[^0-9]", "");
			
			priceMap = service.getPriceMap(priceNo, partialCountArray);
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return priceMap;
	}
	
	
	
	
}
