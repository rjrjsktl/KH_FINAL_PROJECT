package com.kh.kgv.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser"})
public class MainController {
	
	/*
	 * http://localhost:8080/comm/main
	 * http://localhost:8080/comm/
	 * 
	 * */
	
	
	@RequestMapping("/main")
	public String mainForward() {
		
		return "common/main";
		
	}
}
