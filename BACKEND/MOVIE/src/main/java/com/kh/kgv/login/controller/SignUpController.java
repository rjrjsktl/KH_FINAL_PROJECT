package com.kh.kgv.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SignUpController {
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp/signUp";
	}
	

}
