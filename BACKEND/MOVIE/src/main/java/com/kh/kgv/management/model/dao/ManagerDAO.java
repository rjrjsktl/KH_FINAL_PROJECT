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
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Pagination;
import com.kh.kgv.mypage.controller.MyPageController;

@Repository
public class ManagerDAO {
	
	
	private Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
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
///////////////////////// 값이 null로 오는데 확인해봐야함
	public List<Movie> movieList(Movie movie) {
		System.out.println(" ===== MovieListController 호출 dao");
		
		return sqlSession.selectList("movieMapper.movieList", movie);
	}

	
	public int getEventListCount() {
		return sqlSession.selectOne("managerMapper.getEventListCount");
	}

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
	

}
