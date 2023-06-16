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
	
	@GetMapping("/areaCinemaList")
	@ResponseBody
	public List<Cinema> getAreaCinemaList(String areaName) {
		
		System.out.println(areaName);
		List<Cinema> cinemaList = service.getAreaCinemaList(areaName);
		return cinemaList;
	}

}
