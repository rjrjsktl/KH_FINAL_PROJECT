package com.kh.kgv.management.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.common.Util;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.items.model.vo.TimeTable;
import com.kh.kgv.management.model.dao.ManagerDAO;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.DailyEnter;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.Pagination;
import com.kh.kgv.management.model.vo.WeeklyEnter;
import com.kh.kgv.management.model.vo.banner;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO dao;
	
//	@Override
//	public List<Movie> movieList(Movie movie) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	// 관리자 메인 신규 회원 목록 조회
	@Override
	public List<User> getAllUser() {
		List<User> getUser = dao.getAllUser();
		return getUser;
	}
	
	// 관리자 메인 공지사항 목록 조회
	@Override
	public List<Notice> getAllNotice() {
		List<Notice> getNotice = dao.getAllNotice();
		return getNotice;
	}
	
	// 관리자 메인 일일 접속자 수 조회
	@Override
	public List<DailyEnter> getWeeklyEnter(WeeklyEnter we) {
		return dao.getWeeklyEnter(we);
	}

	// 회원 목록 조회
	@Override
	public Map<String, Object> selectAll(int cp) {

		// 회원 수 조회
		int listCount = dao.getListCount();
		System.out.println("========================================listCount : " + listCount);

		// 조회한 회원을 pagination 에 담기
		Pagination pagination = new Pagination(cp, listCount);

		// 회원 리스트 조회
		List<User> userList = dao.selectAll(pagination);

		Map<String, Object> getUserList = new HashMap<String, Object>();
		getUserList.put("pagination", pagination);
		getUserList.put("userList", userList);

		return getUserList;
	}

	// 회원 관리자 상태 업데이트
	@Override
	public int updateST(User user) {
		return dao.updateST(user);
	}
	
	// 회원 이용제한 업데이트
	@Override
	public int blockST(User user) {
		return dao.blockST(user);
	}

	// 영화 등록
	@Override
	public int MovieAdd(Movie inputMovie) {

		System.out.println("==============영화등록 serviceimpl");

		int result = dao.MovieAdd(inputMovie);
		System.out.println("serviceImpl result:" + result);
		return result;
	}

	/**
	 * Grade 호출 서비스
	 *
	 */
	@Override
	public List<String> mgradeList() {
		System.out.println("===== Grade 호출 service");

		return dao.mgradeList();
	}

	/**
	 * genre 호출 서비스
	 *
	 */
	@Override
	public List<String> mgenreList() {
		System.out.println("===== Genre 호출 service");

		return dao.mgenreList();
	}

	/**
	 * movielist 호출 서비스
	 *
	 */
//	@Override
//	public List<Movie> movieList(Movie movie) {
//		System.out.println("===== movieList 호출 service");
//
//		return dao.movieList(movie);
//	}
	
	/** movieList 호출 서비스
	 *  coMovielist 호출 서비스 페이지네이션
	 */
	@Override
	public Map<String, Object> movieList(int cp) {

		// 영화 수 조회
		int movielistCount = dao.getmovielistCount();
		
		// 조회한 공지사항 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, movielistCount);
 
		// 공지사항 리스트 조회
		System.out.println("===== movieList 호출 service");
		List<Movie> movielist = dao.movieList(pagination);
		System.out.println("movielist 값 :::::" + movielist);
		// movielist에서 따온 값 가공하기
	    List<Movie> cleanedList = new ArrayList<>();
	    	for (Movie movie : movielist) {
	    		Movie cleanedMovie = new Movie();
	    		cleanedMovie.setMgNo(Util.removeQuotes(movie.getMgNo()));
	    		cleanedMovie.setGenreName(Util.removeQuotes(movie.getGenreName()));
	    		cleanedMovie.setMovieNo(movie.getMovieNo());
	    		cleanedMovie.setMovieRuntime(movie.getMovieRuntime());
	    		cleanedMovie.setMovieTitle(movie.getMovieTitle());
	    		cleanedMovie.setMovieNation(movie.getMovieNation());
	    		cleanedMovie.setMovieOpen(movie.getMovieOpen());
	    		cleanedMovie.setMovieContent(movie.getMovieContent());
	    		cleanedMovie.setMovieImg1(movie.getMovieImg1());
	    		cleanedMovie.setMovieImg2(movie.getMovieImg2());
	    		cleanedMovie.setMovieImg3(movie.getMovieImg3());
	    		cleanedMovie.setMovieImg4(movie.getMovieImg4());
	    		cleanedMovie.setMovieImg5(movie.getMovieImg5());
	    		cleanedMovie.setMovieImg6(movie.getMovieImg6());
	    		cleanedMovie.setMovieUploader(movie.getMovieUploader());
	    		cleanedMovie.setMovieDirector(movie.getMovieDirector());
	    		cleanedMovie.setMovieCast(movie.getMovieCast());
	    		cleanedMovie.setMovieRegdate(movie.getMovieRegdate());
	    		cleanedMovie.setMovieSt(movie.getMovieSt());
	        
	    		cleanedList.add(cleanedMovie);
	    	}
	    	Map<String, Object> getMovieList = new HashMap<String, Object>();
	    	getMovieList.put("pagination", pagination);
	    	getMovieList.put("cleanedList", cleanedList);
		
		return getMovieList;
	}
	
	/**
	 * 영화 수정 페이지 이동
	 */
	@Override
	public Movie getEditMovieList(Movie movie) {
		return dao.getEditMovieList(movie);
	}
	
	/** 
	 * 영화 수정 등록
	 */
	@Override
	public int MovieEdit(Movie updateMovie) {

		System.out.println("==============영화등록 serviceimpl");

		int result = dao.MovieEdit(updateMovie);
		System.out.println("serviceImpl result:::::" + result);
		return result;
	}

	@Override
	public Map<String, Object> eventList(int cp) {
		// 회원 수 조회
		int eventlistCount = dao.getEventListCount();

		// 조회한 회원을 pagination 에 담기
		Pagination pagination = new Pagination(cp, eventlistCount);

		// 회원 리스트 조회
		List<Event> eventList = dao.eventList(pagination);

		Map<String, Object> getEventList = new HashMap<String, Object>();
		getEventList.put("pagination", pagination);
		getEventList.put("eventList", eventList);

		return getEventList;
	}

	// 이벤트 수정 조회
	@Override
	public Map<String, Object> getEditEventList(Event event) {

		return dao.getEditEventList(event);
	}

	// 이벤트 수정(업데이트)
	@Override
	public int editEvent(Event event) {
		return dao.editEvent(event);
	}

	// 이벤트 상태 업데이트
	@Override
	public int updateEventST(Event event) {
		return dao.updateEventST(event);
	}

	// 공지사항 등록
	@Override
	public int addNotice(Notice notice) {
		return dao.addNotice(notice);
	}

	// 공지사항 목록 조회
	@Override
	public Map<String, Object> noticeList(int cp) {

		// 공지사항 수 조회
		int noticelistCount = dao.getNoticeListCount();

		// 조회한 공지사항 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, noticelistCount);

		// 공지사항 리스트 조회
		List<Notice> noticeLists = dao.noticeList(pagination);

		Map<String, Object> getNoticeList = new HashMap<String, Object>();
		getNoticeList.put("pagination", pagination);
		getNoticeList.put("noticeLists", noticeLists);

		return getNoticeList;
	}
	// 공지사항 수정 조회
	@Override
	public Map<String, Object> getEditNoticeList(Notice notice) {
		
		return dao.getEditNoticeList(notice);
	}

	// 공지사항 수정(업데이트)
	@Override
	public int editNotice(Notice notice) {
		return dao.editNotice(notice);
	}

	//공지사항 상태 업데이트
	@Override
	public int updateNoticeST(Notice notice) {
		return dao.updateNoticeST(notice);
	}

	// 영화관 목록 조회
	@Override
	public Map<String, Object> getCinemaMap(int cp) {
		// 영화관 수 조회
		int cinemaCount = dao.getCinemaCount();

		// 조회한 영화관 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, cinemaCount);

		// 영화관 리스트 조회
		List<Cinema> cinemaList = dao.getCinemaList(pagination);
		
		Map<String, Object> cinemaMap = new HashMap<String, Object>();
		cinemaMap.put("pagination", pagination);
		cinemaMap.put("cinemaList", cinemaList);
		
		return cinemaMap;
	
	}
	
	//	 영화 상영 상태 업데이트
	@Override
	public int updateMovieST(Movie movie) {
		return dao.updateMovieST(movie);
	}
	
	// 공지사항 리스트 갯수 반환
	@Override
	public int getNoticeListCount() {
		return dao.getNoticeListCount();
	}

	// 유저용 공지사항
	@Override
	public Map<String, Object> userNoticeList(int cp) {
		// 공지사항 수 조회
		int noticelistCount = dao.getNoticeListCount();

		// 조회한 공지사항 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, noticelistCount);

		// 공지사항 리스트 조회
		List<Notice> noticeLists = dao.userNoticeList(pagination);

		Map<String, Object> userNoticeList = new HashMap<String, Object>();
		userNoticeList.put("pagination", pagination);
		userNoticeList.put("noticeLists", noticeLists);

		return userNoticeList;
	}

	
	// 상영 중인 영화, 상영 시간표 
	public Map<String, Object> getPlayMap() {
		List<Movie> playingMovieList = dao.getPlayingMovieList();
		List<TimeTable> timeTableList = dao.getTimeTableList();
		
		Map<String, Object> playMap = new HashMap<String, Object>();
		playMap.put("playingMovieList", playingMovieList);
		playMap.put("timeTableList", timeTableList);
		return playMap;
	}
	

	// 스토어 
	@Override
	public Map<String, Object> getStoreMap(int cp) {
		// 영화관 수 조회
				int storeCount = dao.getStoreCount();

				// 조회한 영화관 수를 pagination 에 담기
				Pagination pagination = new Pagination(cp, storeCount);

				// 영화관 리스트 조회
				List<Store> storeList = dao.getStoreList(pagination);
				
				Map<String, Object> storeMap = new HashMap<String, Object>();
				storeMap.put("pagination", pagination);
				storeMap.put("storeList", storeList);
				
				return storeMap;
	}

	// 메인 -> 이벤트 이동 시 이벤트 
	@Override
	public Map<String, Object> selectEventList() {
		
		List<Event>EventList = dao.selectEventList();
		
		Map<String, Object>getEvnetList = new HashMap<String, Object>();
		getEvnetList.put("getEvnetList", EventList);
		
		
		return getEvnetList;
	}

	// 메인 -> 이벤트 상세 내용
	@Override
	public Event getEventList(Event event) {
		return dao.getEventList(event);


	}
	// 메인 이벤트 목록 가지고 오기 - 7개
	@Override
	public Map<String, Object> mainEventList() {
		List<Event>EventList = dao.mainEventList();
		
		Map<String, Object>getEvnetList = new HashMap<String, Object>();
		getEvnetList.put("getEvnetList", EventList);
		
		
		return getEvnetList;
	}

	// 관리자_배너 등록
	@Override
	public int addBanner(banner banner) {
		return dao.addBanner(banner);
	}

	// 관리자_배너 목록 이동시 목록 조회
	@Override
	public Map<String, Object> getBannerList(int cp) {
		
		int bannerCount = dao.bannerCount(cp);
		
		// 조회한 영화관 수를 pagination 에 담기
		Pagination pagination = new Pagination(cp, bannerCount);

		// 영화관 리스트 조회
		
		List<banner>BannerList = dao.getBannerList(pagination);
		
		Map<String, Object>getBannerList = new HashMap<String, Object>();
		getBannerList.put("BannerList", BannerList);
		
		return getBannerList;
	}

	// 관리자_배너 상태 업데이트
	@Override
	public int updateBannerST(banner banner) {
		return dao.updateBannerST(banner);
	}
	
	// 스토어 수정 조회
	@Override
	public Store getEditStoreList(Store store) {
		return dao.getEditStoreList(store);
	}
	
	// 스토어 수정 등록
	@Override
	public int StoreEdit(Store updateStore) {
		int result = dao.StoreEdit(updateStore);
		System.out.println("serviceImpl result:::::" + result);
		return result;
	}






	
	
	
	
}
