package com.kh.kgv.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.management.model.service.ManagePlayService;
import com.kh.kgv.management.model.vo.Cinema;

@Controller
@RequestMapping("/manager/play_add")
@SessionAttributes({ "loginUser" })
public class ManagePlayController {
	
	@Autowired
	private ManagePlayService service;
	
	/*
	@GetMapping("/cinemaDupCheck")
	@ResponseBody
	public int cinemaDupCheck(String cinemaName) {
		int result = service.cinemaDupCheck(cinemaName);
		System.out.println(result);
		return result;
	} 
	*/
	
	@GetMapping("/areaCinemaList")
	@ResponseBody
	public List<Cinema> getAreaCinemaList(String areaName) {
		
		System.out.println(areaName);
		List<Cinema> cinemaList = service.getAreaCinemaList(areaName);
		for(Cinema cinema : cinemaList) {
			System.out.println(cinema.getCinemaName());
		}
		return cinemaList;
	}

}
