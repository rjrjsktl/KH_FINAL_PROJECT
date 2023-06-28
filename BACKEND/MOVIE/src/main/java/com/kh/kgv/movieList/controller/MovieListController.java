package com.kh.kgv.movieList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.common.Util;
import com.kh.kgv.common.Util.SessionUtil;
import com.kh.kgv.customer.model.vo.Review;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.helpDesk.model.vo.Mtm;
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

	//	메인페이지 -> 영화 -> 상영중인영화 이동 시 영화 목록 조회
	@RequestMapping("/detail_List")
	public String moveList(Model model) {

		Map<String, Object>getMovieList = null;
		System.out.println("DB에서 가지고온 getMovieList : =============================================" + getMovieList);
		getMovieList = service.movieList();

		model.addAttribute("getMovieList", getMovieList);


		return "movieList/detail_List";

	}
	//	메인페이지 -> 영화 -> 전체 영화목록 이동 시 영화 목록 조회
	// 위에꺼 재활용
	@RequestMapping("/all_List")
	public String allMoveList(Model model) {

		Map<String, Object>getMovieList = null;
		System.out.println("DB에서 가지고온 getMovieList : =============================================" + getMovieList);
		getMovieList = service.movieList();

		model.addAttribute("getMovieList", getMovieList);


		return "movieList/all_List";

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
			, @PathVariable("movieNo") int movieNo,
	         @RequestParam(value = "cp", required = false, defaultValue="1") int cp
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

			Util.alertAndBackPage(response, "성인 인증이 필요합니다.");

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

				Util.alertAndBackPage(response, "성인만 이용 가능 합니다.");

				return null;
			} 		

		}

		///// DB에 저장되어있는 review 땡겨오기..

		
		String userNick = null;
		
		if ( loginUser !=null) {
			userNick = loginUser.getUserNick();
		}

		int reviewCount = service.getCountReviews(movieNo);

		System.out.println(reviewCount);

		Map<String, Object>reviewList = null;

		reviewList = service.getReviewList(movieNo, cp);


		model.addAttribute("reviewCount",reviewCount);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("userNick", userNick);
		

		System.out.println(model);
		
		System.out.println("userNick"+"userNick"+userNick+"userNickuserNickuserNickuserNickuserNickuserNickuserNickuserNickuserNick");

		//////////////////////////////////////////////




		model.addAttribute("MovieDetail", getMovieDetail);


		return "movieList/introduce";

	}


	@ResponseBody
	@PostMapping("/detail_List/introduce/{movieNo}")
	public String addmTm(
			@RequestParam("starRating") int revLike, 
			@RequestParam("reviewText") String content,
			@PathVariable("movieNo") int movieNo,
			HttpServletResponse resp,

			HttpSession session) {


		User loginUser = (User)session.getAttribute("loginUser");

	

		int userNo = 0;
		String userNick = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
			userNick = loginUser.getUserNick();
		}

		Review review = new Review();
		
		int revNo = review.getRevNo();

		content = content.replaceAll("\n", "<br>");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");

		review.setRevContent(content);
		review.setUserNo(userNo);
		review.setRevLike(revLike);
		review.setMovieNo(movieNo);
		review.setUserNick(userNick);
		review.setRevNo(revNo);

		int result = service.addReview(review);  



		return null;
	}
	
	@ResponseBody
	@RequestMapping("/detail_List/introduce/{movieNo}/{cp}")
	public List<Review> getMoreReviews(
	    @PathVariable("movieNo") int movieNo,
	    @PathVariable("cp") int cp) throws Exception {

	    Map<String, Object> reviewList = service.getReviewList(movieNo, cp);
	    return (List<Review>) reviewList.get("reviewList");
	}
	
	@ResponseBody
	@PostMapping("/detail_List/introduce/deleteReview/{revNo}")
	public String deleteReview(@PathVariable("revNo") int revNo) {
		
	    int result = service.deleteReview(revNo); // 해당 리뷰를 삭제

	    String ns = null;
	    
	    if (result > 0) {
	        return "redirect:/detail_List";
	    } else {
	        return "error";
	    }
	    
	    
	}
	





}