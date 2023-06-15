package com.kh.kgv.management.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.common.Util;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.dao.ManagerDAO;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.Pagination;

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
	    		cleanedMovie.setGenreCode(Util.removeQuotes(movie.getGenreCode()));
	    		cleanedMovie.setMovieNo(movie.getMovieNo());
	    		cleanedMovie.setMovieRuntime(movie.getMovieRuntime());
	    		cleanedMovie.setMovieTitle(movie.getMovieTitle());
	    		cleanedMovie.setMovieNation(movie.getMovieNation());
	    		cleanedMovie.setMovieOpen(movie.getMovieOpen());
	    		cleanedMovie.setMovieContent(movie.getMovieContent());
	    		cleanedMovie.setMovieImg(movie.getMovieImg());
	    		cleanedMovie.setMovieUploader(movie.getMovieUploader());
	    		cleanedMovie.setMovieDirector(movie.getMovieDirector());
	    		cleanedMovie.setMovieCast(movie.getMovieCast());
	    		cleanedMovie.setMovieRegdate(movie.getMovieRegdate());
	        
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
	public Map<String, Object> getEditMovieList(Movie movie) {
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
	
	// 공지사항 리스트 갯수 반환
	@Override
	public int getNoticeListCount() {
		return dao.getNoticeListCount();
	}

	

	




	
	
	
	
}
