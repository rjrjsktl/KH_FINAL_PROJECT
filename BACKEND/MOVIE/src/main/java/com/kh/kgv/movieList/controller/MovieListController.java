package com.kh.kgv.movieList.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.movieList.model.service.MovieService;

@Controller
@RequestMapping("/movieList")
@SessionAttributes({"loginUser"})
public class MovieListController {
	
	@Autowired
	private MovieService service;
	
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
	@RequestMapping("/detail_List/introduce/{movieNo}")
	public String getMovieDetail(
			Model model
			, @PathVariable("movieNo") int movieNo
			) {
		
		System.out.println("영화 상세페이지로 이동함");
		System.out.println("movieNo ============================" + movieNo);
		
		return null;
		
		
	}
}