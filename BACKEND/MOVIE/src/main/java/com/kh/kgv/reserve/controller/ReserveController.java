package com.kh.kgv.reserve.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;
import com.kh.kgv.reserve.model.service.ReserveService;

@Controller
@RequestMapping("/reserve")
@SessionAttributes({ "loginUser" })
public class ReserveController {
	
	@Autowired
	private ReserveService service;
	
	private String[] areaArray = {"서울", "경기", "충청", "전라", "경남", "경북", "강원", "제주"};
	private String[] specialArray = {"KMAX", "DOLBY", "CHEF &amp; CINE", "PUPPY &amp; ME", "YES KIDS"};
	private List<Cinema> cinemaList = null;
	private List<Screen> specialScreenList = null;
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
		specialScreenList = service.getSpecialScreenList(specialArray[0]); 
		
		reserveMap.put("movieList", movieList);
		reserveMap.put("thumbList", thumbList);
		reserveMap.put("cinemaList", cinemaList);
		reserveMap.put("specialScreenList", specialScreenList);
		model.addAttribute("reserveMap", reserveMap);
		
		return "reserve/choicePlay";
	}
	
	
	@GetMapping("/initialMap")
	@ResponseBody
	public Map<String, Object> getInitialMap() {
		Map<String, Object> initialMap = null;

		try {
			String areaName = areaArray[0];
			initialMap = service.getInitialMap(areaName);	
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		
		return initialMap;
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
	
	
	@GetMapping("/specialScreenList")
	@ResponseBody
	public List<Screen> getSpecialScreenList(String typeIndex) {
		try {
			String type = specialArray[Integer.parseInt(typeIndex)];
			specialScreenList = service.getSpecialScreenList(type);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 이외의 숫자입니다.");
		} catch(NumberFormatException e) {
			System.out.println("잘못된 인덱스입니다.");
		}
		
		return specialScreenList;
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
	
	
	@PostMapping("/checkTicket")
	@ResponseBody
	public String checkTicket(HttpServletRequest req, String countArray, String seatArray, 
			                      @ModelAttribute("loginUser") User loginUser) throws Exception {
		int condition = 0;
		String url = "fail";
		try {
			// 세션에서 상영 번호와 가격 번호를 가져옴.
			HttpSession session = req.getSession();
			int playNo = Integer.parseInt( (String) session.getAttribute("playNo"));
			int priceNo = (int) session.getAttribute("priceNo");
			int userNo = loginUser.getUserNo();

			System.out.println(countArray);
			System.out.println(seatArray);
			
			// 인원별 몇 명 선택했는지 배열[bookAge]로 나타냄
			countArray = countArray.replaceAll("[^0-9]", "");
			priceMap = service.getPriceMap(priceNo, countArray);
			String bookAge = Arrays.toString( (int[]) priceMap.get("countArray") );
			int bookPrice = (int) priceMap.get("totalPrice");
			
			// 어떤 좌석을 선택했는지 배열[bookSeat]로 나타냄
			seatArray = seatArray.replaceAll("&quot", "");
			Gson gson = new Gson();
	        String[] gsonSeat = gson.fromJson(seatArray, String[].class);
	        List<String> seatList = new ArrayList<>();
	        // System.out.println(Arrays.toString(gsonSeat));
	        
	        for(String seat: gsonSeat) {
	        	if(seat != null) seatList.add('"' + seat + '"');
	        }
	        
	        // String bookSeat = Arrays.deepToString(seatList.toArray());
	        
	        String bookSeat = seatArray;

	        // condition = service.checkTicket(playNo, bookAge, seatList);
	        // 일단 0으로 함
	        if(condition == 0) {
	        	int result = service.buyTicket(playNo, userNo, bookAge, bookSeat, bookPrice);
	        	System.out.println(result);
				url = "/movie";
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 유효성 검사가 통과되면 예매 테이블에 데이터 축적
		// 1. PLAY_NO, USER_NO, BOOK_AGE(countArray), BOOK_SEAT(seatArray), BOOK_PRICE가 전달됨
		// 2. 성공하면 숫자 1이 전달됨.
		
		return url;
	}
	
	
}
