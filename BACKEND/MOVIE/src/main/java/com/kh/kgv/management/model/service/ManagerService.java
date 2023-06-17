package com.kh.kgv.management.model.service;

import java.util.List;
import java.util.Map;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.DailyEnter;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.WeeklyEnter;

public interface ManagerService {
	
	// 관리자 메인 신규 회원 목록 조회
	List<User> getAllUser();
	
	// 관리자 메인 공지사항 목록 조회
	List<Notice> getAllNotice();

	// 회원 목록 조회
	Map<String, Object> selectAll(int cp);
	
	// 관리자 메인 일일 접속자 수 조회
	List<DailyEnter> getWeeklyEnter(WeeklyEnter we);

	// 회원 관리자 상태 업데이트
	int updateST(User user);
	
	// 회원 이용제한 업데이트
	int blockST(User user);

	// 영화 등록 서비스
	int MovieAdd(Movie inputMovie);

	// Grade 호출 서비스
	List<String> mgradeList();

	// Gener
	List<String> mgenreList();

	// 영화 목록 조회
	Map<String, Object> movieList(int cp);
	
	// 영화 수정 조회
	Movie getEditMovieList(Movie movie);
	
	// 영화 수정 등록
	int MovieEdit(Movie updateMovie);

	// 이벤트 목록 조회
	Map<String, Object> eventList(int cp);

	// 이벤트 수정 조회
	Map<String, Object> getEditEventList(Event event);

	// 이벤트 수정(업데이트)
	int editEvent(Event event);

	// 이벤트 상태 업데이트
	int updateEventST(Event event);

	// 공지사항 등록
	int addNotice(Notice notice);

	// 공지사항 목록 조회
	Map<String, Object> noticeList(int cp);

	// 공지사항 수정 조회
	Map<String, Object> getEditNoticeList(Notice notice);

	// 공지사항 수정(업데이트)
	int editNotice(Notice notice);

	//공지사항 상태 업데이트
	int updateNoticeST(Notice notice);
	
	// 영화관 목록 조회 
	Map<String, Object> getCinemaMap(int cp);

	//공지사항 갯수 조회	
	int getNoticeListCount();

	//유저 전용 공지사항 조회
	Map<String, Object> userNoticeList(int cp);

	//	 영화 상영 상태 업데이트
	int updateMovieST(Movie movie);

	// 상영 중인 영화, 상영 시간표 조회
	Map<String, Object> getPlayMap();
	
	// 스토어 목록 조회
	Map<String, Object> getStoreMap(int cp);





	



	





}
