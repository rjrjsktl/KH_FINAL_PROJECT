package com.kh.kgv.reserve.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.CinemaPrice;
import com.kh.kgv.management.model.vo.JoinPlay;
import com.kh.kgv.management.model.vo.Screen;
import com.kh.kgv.reserve.model.dao.ReserveDAO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
	private ReserveDAO dao;
	
	private List<Cinema> cinemaList = null;
	private List<Movie> movieList = null;
	private List<Movie> thumbList = null;
	private List<JoinPlay> joinPlayList = null;

	@Override
	public List<Cinema> getAreaCinemaList(String areaName) {
		List<Cinema> cinemaList = dao.getAreaCinemaList(areaName);
		return cinemaList;
	}

	@Override
	public List<Movie> getPlayingMovieList() {
		List<Movie> movieList = dao.getPlayingMovieList();
		return movieList;
	}

	@Override
	public List<Movie> getPlayingThumbList() {
		List<Movie> thumbList = dao.getPlayingThumbList();
		return thumbList;
	}

	@Override
	public List<JoinPlay> getTotalPlayList(String areaName, String cinemaIndex, String dateIndex) {
		cinemaList = dao.getAreaCinemaList(areaName);
		int cinemaNo = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaNo();
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = now.plusDays(Integer.parseInt(dateIndex));
		String strDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		Map<String, Object> condition = new HashMap<>();
		condition.put("cinemaNo", cinemaNo);
		condition.put("strDate", strDate);
		List<JoinPlay> totalPlayList = dao.getTotalPlayList(condition);
		
		return totalPlayList;
	}

	@Override
	public List<Screen> getScreenList(String cinemaName) {
		List<Screen> screenList = dao.getScreenList(cinemaName);
		return screenList;
	}
	
	@Override
	public List<JoinPlay> getMoviePlayList(String areaName, String cinemaIndex, String dateIndex, 
			                                        String movieOptionIndex, String movieIndex) {
		
		cinemaList = dao.getAreaCinemaList(areaName);
		int cinemaNo = cinemaList.get(Integer.parseInt(cinemaIndex)).getCinemaNo();
		int movieNo = 0;
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = now.plusDays(Integer.parseInt(dateIndex));
		String strDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		if(movieOptionIndex.equals("0")) {
			movieList = dao.getPlayingMovieList();
			movieNo = movieList.get(Integer.parseInt(movieIndex)).getMovieNo();
		} else {
			thumbList = dao.getPlayingThumbList();
			movieNo = thumbList.get(Integer.parseInt(movieIndex)).getMovieNo();
		}

		Map<String, Object> condition = new HashMap<>();
		condition.put("cinemaNo", cinemaNo);
		condition.put("strDate", strDate);
		condition.put("movieNo", movieNo);
		List<JoinPlay> moviePlayList = dao.getMoviePlayList(condition);

		return moviePlayList;
	}


	@Override
	public JoinPlay getUserPlay(int playNo) {
		return dao.getUserPlay(playNo);
	}
	
	@Override
	public int getPriceNo(int playNo) {
		JoinPlay userPlay = dao.getUserPlay(playNo);
		
		String screenStyle = userPlay.getScreen().getScreenStyle();
		String priceDay = null;
		String priceTime = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = null;
		
		try {
			startDate = formatter.parse(userPlay.getPlay().getPlayStart());
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		
		Map<String, Object> condition = new HashMap<>();
		condition.put("screenStyle", screenStyle);
		condition.put("priceDay", priceDay);
		condition.put("priceTime", priceTime);
		int priceNo = dao.getPriceNo(condition);
		return priceNo;
	}


	@Override
	public CinemaPrice getPriceModel(int priceNo) {
		CinemaPrice cinemaPrice = dao.getPriceModel(priceNo);
		return cinemaPrice;
	}

	@Override
	public Map<String, Object> getPriceMap(int priceNo, String partialCountArray) {
		CinemaPrice cinemaPrice = dao.getPriceModel(priceNo);
		int[] priceArray = {0, 0, 0, 0, 0};
		int[] countArray = {0, 0, 0, 0, 0};
		int totalPrice = 0;
		
		// 스위트석은 연령에 상관없이 모두 같은 가격
		// 스위트석과 일반석을 같이 선택할 수 없음
		
		priceArray[0] = Integer.parseInt(cinemaPrice.getPriceNormal());
		priceArray[1] = Integer.parseInt(cinemaPrice.getPriceTeen());
		priceArray[2] = Integer.parseInt(cinemaPrice.getPriceElder());
		priceArray[3] = Integer.parseInt(cinemaPrice.getPriceSpecial());
		priceArray[4] = Integer.parseInt(cinemaPrice.getPriceCouple());
		
		for(int i=0; i<partialCountArray.length(); i++) {
			int countIndex = partialCountArray.charAt(i) - 48;
			countArray[countIndex] += 1;
			totalPrice += priceArray[countIndex];
		}
		
		Map<String, Object> priceMap = new HashMap<>();
		priceMap.put("priceArray", priceArray);
		priceMap.put("countArray", countArray);
		priceMap.put("totalPrice", totalPrice);
		
		return priceMap;
	}

	@Override
	public Map<String, Object> getInitialMap(String areaName) {
		Map<String, Object> initialMap = new HashMap<>();
		
		cinemaList = dao.getAreaCinemaList(areaName);
		
		List<Integer> titleRankList = new ArrayList<>();
		List<Integer> rateRankList = new ArrayList<>();
		
		movieList = dao.getPlayingMovieList();
		thumbList = dao.getPlayingThumbList();
		
		for(Movie movie : movieList) {
			titleRankList.add(movie.getMovieNo());
		}
		
		for(Movie movie : thumbList) {
			rateRankList.add(movie.getMovieNo());
		}
		
		initialMap.put("cinemaList", cinemaList);
		initialMap.put("titleRankList", titleRankList);
		initialMap.put("rateRankList", rateRankList);
		return initialMap;
	}

}
