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
//	
//	@RequestMapping("/specialTheater")
//	public String specialTheater() {
//		return "theater/normalTheater";
//	}
}
