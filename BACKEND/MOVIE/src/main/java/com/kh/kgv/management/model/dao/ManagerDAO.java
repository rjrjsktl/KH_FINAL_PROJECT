package com.kh.kgv.management.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.TimeTable;
import com.kh.kgv.management.model.vo.Cinema;
import com.kh.kgv.management.model.vo.DailyEnter;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.Pagination;
import com.kh.kgv.management.model.vo.WeeklyEnter;
import com.kh.kgv.mypage.controller.MyPageController;

@Repository
public class ManagerDAO {
	
	
	private Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 관리자 메인 신규 회원 목록 조회
	public List<User> getAllUser() {
		return sqlSession.selectList("managerMapper.getAllUser");
	}
	// 관리자 메인 공지사항 목록 조회
	public List<Notice> getAllNotice() {
		return sqlSession.selectList("managerMapper.getAllNotice");
	}
	
	// 관리자 메인 일일 접속자 수 조회
	public List<DailyEnter> getWeeklyEnter(WeeklyEnter we) {
		return sqlSession.selectList("managerMapper.getDailyEnter", we);
	}
		
	/** 회원 수 조회
	 * @return
	 */
	public int getListCount() {
		return sqlSession.selectOne("managerMapper.getListCount");
	}

	/** 회원 리스트 조회
	 * @return
	 */
	public List<User> selectAll(Pagination pagination) {
		// RowBounds 객체 사용.
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.selectAll", null, rowBounds);
				
	}
	// 회원 관리자 상태 업데이트
	public int updateST(User user) {
		
		return sqlSession.update("managerMapper.updateST", user);
	}
	
	// 회원 이용제한 업데이트
	public int blockST(User user) {
		return sqlSession.update("managerMapper.blockST", user);
	}

	/** 영화 등록 DAO
	 * @param inputMovie
	 * @return
	 */
	public int MovieAdd(Movie inputMovie) {
		System.out.println(" ============= 영화 등록 DAO실행");
		return sqlSession.insert("movieMapper.MovieAdd", inputMovie);
	}

	/** Grade 호출 DAO
	 * @return
	 */
	public List<String> mgradeList() {
		System.out.println(" ===== Grade 호출 dao");
		return sqlSession.selectList("movieMapper.mgradeList");
	}

	/** Genre 호출 DAO
	 * @return
	 */
	public List<String> mgenreList() {
		System.out.println(" ===== Genre 호출 dao");
		return sqlSession.selectList("movieMapper.mgenreList");
	}
	
	/** 영화 목록 수 조회 
	 *  이값이 돌고 movielist에 들어가야 함
	 * @return
	 */
	public int getmovielistCount() {
		return sqlSession.selectOne("movieMapper.getmovielistCount");
	}
	
	/** 위에서 getmovielistCount값을 받은다음에 실행 됨
	 * @param pagination
	 * @return
	 */
	public List<Movie> movieList(Pagination pagination) {
		System.out.println(" ===== MovieListController 호출 dao");
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("movieMapper.movieList", null, rowBounds);
	}
	
	/** 영화 수정 페이지 이동
	 * @param movieNo
	 * @return
	 */
	public Movie getEditMovieList(Movie movie) {
		return sqlSession.selectOne("movieMapper.getEditMovieList", movie);
	}
	
	/** 영화 수정 등록
	 * @param updateMovie
	 * @return
	 */
	public int MovieEdit(Movie updateMovie) {
		return sqlSession.update("movieMapper.MovieEdit", updateMovie);
	}
	
	// 이벤트 목록 수 조회
	public int getEventListCount() {
		return sqlSession.selectOne("managerMapper.getEventListCount");
	}

	// 
	public List<Event> eventList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.eventList", null, rowBounds);
	}

	// 이벤트 수정조회
	public Map<String, Object> getEditEventList(Event event) {
		return sqlSession.selectOne("managerMapper.getEditEventList", event);
	}
	
	// 이벤트 수정(업데이트)
	public int editEvent(Event event) {
		return sqlSession.update("managerMapper.editEvent", event);
	}
	
	//이벤트 상태 업데이트
	public int updateEventST(Event event) {
		return sqlSession.update("managerMapper.updateEventST", event);
	}

	// 공지사항 등록
	public int addNotice(Notice notice) {
		return sqlSession.insert("managerMapper.addNotice", notice);
	}
	
	//공지사항 수 조회
	public int getNoticeListCount() {
		return sqlSession.selectOne("managerMapper.getNoticeListCount");
	}

	//공지사항  조회
	public List<Notice> noticeList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.noticeList", null, rowBounds);
	}
	
	// 공지사항 수정 조회
	public Map<String, Object> getEditNoticeList(Notice notice) {
		
		return sqlSession.selectOne("managerMapper.getEditNoticeList", notice);
	}
	
	// 공지사항 수정(업데이트)
	public int editNotice(Notice notice) {
		return sqlSession.update("managerMapper.editNotice", notice);
	}

	//공지사항 상태 업데이트
	public int updateNoticeST(Notice notice) {
		return sqlSession.update("managerMapper.updateNoticeST", notice);
	}

	
	// 영화관 수 조회
	public int getCinemaCount() {
		return sqlSession.selectOne("cinemaMapper.getCinemaCount");
	}
	
	// 유저용 공지사항 조회
	public List<Notice> userNoticeList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.userNoticeList", null, rowBounds);
	}
	
	// 극장 목록 조회
	public List<Cinema> getCinemaList(Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());		
		
		return sqlSession.selectList("cinemaMapper.getCinemaList", null, rowBounds);
	}
	
	//	 영화 상영 상태 업데이트
	public int updateMovieST(Movie movie) {
		return sqlSession.update("managerMapper.updateMovieST", movie);
	}
	
	// 상영 중인 영화 리스트 조회
	public List<Movie> getPlayingMovieList() {
		return sqlSession.selectList("playMapper.getPlayingMovieList");
	}
	
	// 상영 시간표 조회
	public List<TimeTable> getTimeTableList() {
		return sqlSession.selectList("playMapper.getTimeTableList");
	}
	



}




