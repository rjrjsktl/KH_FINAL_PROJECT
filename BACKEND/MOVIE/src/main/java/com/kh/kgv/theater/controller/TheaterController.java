package com.kh.kgv.theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theater")
public class TheaterController {
	
	@RequestMapping("/normalTheater")
	public String normalTheater() {
		return "theater/normalTheater";
	}
	
	@RequestMapping("/specialTheater")
	public String specialTheater() {
		return "theater/specialTheater";
	}
	
	
	@RequestMapping("/theaterS")
	public String specialS() {
		return "theater/theaterS";
	}
	
	@RequestMapping("/theaterS2")
	public String specialS2() {
		return "theater/theaterS2";
	}
	
	@RequestMapping("/theaterS3")
	public String specialS3() {
		return "theater/theaterS3";
	}
	
	@RequestMapping("/theaterS4")
	public String specialS4() {
		return "theater/theaterS4";
	}
	
	@RequestMapping("/theaterS5")
	public String specialS5() {
		return "theater/theaterS5";
	}
	
	
}
