package com.kh.kgv.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.kgv.management.model.service.ManagerService;

@Controller
@RequestMapping("/movie")
public class beforeManagerController {
	
	@Autowired
	private ManagerService service;

}
