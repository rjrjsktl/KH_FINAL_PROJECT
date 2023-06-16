package com.kh.kgv.movieList.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.movieList.model.service.MovieService;

@Controller
@RequestMapping("/movieList")
@SessionAttributes({"loginUser"})
public class MovieListController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("/detail_List")
	public String moveList(Model model) {
		
		Movie getMovieList  = service.movieList();
		
		
		model.addAttribute("getMovieList", getMovieList);
		
		
		return "movieList/detail_List";
	
	}
}