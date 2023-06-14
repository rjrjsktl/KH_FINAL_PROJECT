package com.kh.kgv.movieList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movieList")
public class MovieListController {
	
	@RequestMapping("/movieList")
	public String moveList() {
		return "movieList/movieList";
	
	}
}