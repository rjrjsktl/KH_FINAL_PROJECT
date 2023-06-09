package com.kh.kgv.management.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.dao.ManagerDAO;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Pagination;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO dao;



	@Override
	public Map<String, Object> selectAll(int cp) {
		
		// 회원 수 조회
		int listCount = dao.getListCount();
		System.out.println("========================================listCount : " + listCount );
		
		// 조회한 회원을 pagination 에 담기
		Pagination pagination = new Pagination(cp, listCount);
		
		// 회원 리스트 조회
		List<User>userList = dao.selectAll(pagination);
		
		Map<String, Object>getUserList = new HashMap<String, Object>();
		getUserList.put("pagination", pagination);
		getUserList.put("userList", userList);
		
		return getUserList;
	}


	// 회원 관리자 상태 업데이트
	@Override
	public int updateST(User user) {
		return dao.updateST(user);
	}
	
	// 영화 등록
	@Override
	public int MovieAdd(Movie inputMovie) {
			
		System.out.println("==============영화등록 serviceimpl");
			
		int result = dao.MovieAdd(inputMovie);
		System.out.println("serviceImpl result:" + result);
		return result;
	}


	/** Grade 호출 서비스
	 *
	 */
	@Override
	public List<String> mgradeList() {
		System.out.println("===== Grade 호출 service");
		
		return dao.mgradeList();
	}


	/** genre 호출 서비스
	 *
	 */
	@Override
	public List<String> mgenreList() {
		System.out.println("===== Genre 호출 service");
		
		return dao.mgenreList();
	}


	/** movielist 호출 서비스
	 *
	 */
	@Override
	public List<Movie> movieList(Movie movie) {
		System.out.println("===== movieList 호출 service");
		
		return dao.movieList(movie);
	}


	@Override
	public Map<String, Object> eventList(int cp) {
		// 회원 수 조회
		int eventlistCount = dao.getEventListCount();
		
		// 조회한 회원을 pagination 에 담기
		Pagination pagination = new Pagination(cp, eventlistCount);
		
		// 회원 리스트 조회
		List<Event>eventList = dao.eventList(pagination);
		
		Map<String, Object>getEventList = new HashMap<String, Object>();
		getEventList.put("pagination", pagination);
		getEventList.put("eventList", eventList);
		
		return getEventList;
	}
	
	
	
	
	
}
