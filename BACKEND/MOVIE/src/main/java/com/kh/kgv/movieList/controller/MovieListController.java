package com.kh.kgv.movieList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.common.Util;
import com.kh.kgv.common.Util.SessionUtil;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.movieList.model.service.MovieService;

@Controller
@RequestMapping("/movieList")
@SessionAttributes({"loginUser"})
public class MovieListController {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ManagerService services;
	
//	메인페이지 -> 영화 -> 무비차트 이동 시 영화 목록 조회
	@RequestMapping("/detail_List")
	public String moveList(Model model) {
		
		Map<String, Object>getMovieList = null;
		System.out.println("DB에서 가지고온 getMovieList : =============================================" + getMovieList);
		getMovieList = service.movieList();
		
		model.addAttribute("getMovieList", getMovieList);
		
		
		return "movieList/detail_List";
	
	}
	
	// 영화 세부내용
	// 기존 영화 수정 재사용.
	@RequestMapping("/detail_List/introduce/{movieNo}")
	public String getMovieDetail(
			Model model
			, Movie movie
			, HttpSession session
			, RedirectAttributes ra
			, HttpServletResponse response
			, @PathVariable("movieNo") int movieNo
			) throws Exception {
		
		
		
		
		List<String> mgradelist = services.mgradeList();
		System.out.println("mgradelist 값 :::::" + mgradelist);
		
		model.addAttribute("mgradelist", mgradelist);
		// movie genre 값 얻어오기
		List<String> mgenrelist = services.mgenreList();
		System.out.println("mgenrelist 값 :::::" + mgenrelist);
		
		model.addAttribute("mgenrelist", mgenrelist);
		
		// 요기부터 수정페이지에 movieNo 보냄
		movie.setMovieNo(movieNo);
		
		Movie getMovieDetail = services.getEditMovieList(movie);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(getMovieDetail.getMgNo());
		//  ["공포","컬트","재난","범죄","호러"] 에서 [ ] 와 " " 제거하기
		unescapedContent = unescapedContent.replaceAll("\\[|\\]", "").replaceAll("\"", "");
		// 공포,컬트,재난,범죄,호러(공백없음) 를 공포, 컬트, 재난, 범죄, 호러 (공백추가) 로 변경하기
		getMovieDetail.setMgNo(unescapedContent);
		
		String genreChange = StringEscapeUtils.unescapeHtml4(getMovieDetail.getGenreName());
		genreChange = genreChange.replaceAll("\\[|\\]", "").replaceAll("\"", "");
		genreChange = genreChange.replaceAll(",", ", ");
		getMovieDetail.setGenreName(genreChange);
		
		String contents = StringEscapeUtils.unescapeHtml4(getMovieDetail.getMovieContent());
		getMovieDetail.setMovieContent(contents);
		
		// 세션에서 유저 데이터 받아오기
		User  loginUser = (User) SessionUtil.getSession().getAttribute("loginUser");
		
		
		// 관람 등급 가져오기
		String getMg = getMovieDetail.getMgNo();
		
	
		if(loginUser == null  && getMg.contains("청소년")) {
			
		Util.alertAndMovePage(response, "로그인 후 이용 가능합니다.", "/movie/movieList/detail_List");
				
			return null;
			
		}	else if (loginUser != null  && getMg.contains("청소년")) {
			
			// 사용자 출생연도 가져오기 (앞 4자리만 가지고 옴)
			int  userDate = Integer.parseInt(StringUtils.left(loginUser.getUserBirth(), 4));
			
			// 연도만 가져오기
			int year = Year.now().getValue();
			
			System.out.println("userDate =============================================" + userDate);
			System.out.println("year =============================================" + year);
			//  현재 연도- 사용자 출생연도
			int ageCheck =  year - userDate;
			System.out.println("ageCheck =============================================" + ageCheck);
			
			// 성인 확인 절차
			if(ageCheck < 18) {
				
				Util.alertAndMovePage(response, "성인만 이용 가능 합니다.", "/movie/movieList/detail_List");
				
				return null;
			} 		
			
		}
	
		model.addAttribute("MovieDetail", getMovieDetail);
		
		
		return "movieList/introduce";
		
		
	}
}