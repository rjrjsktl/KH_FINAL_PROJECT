package com.kh.kgv.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.management.model.service.ManageStoreService;



@Controller
@RequestMapping("/manager/store_add")
@SessionAttributes({ "loginUser" })
public class ManageStoreController {
	
	@Autowired
	private ManageStoreService service;
	
	private Logger logger = LoggerFactory.getLogger(ManageStoreController.class);
	
	
	
	// 닉네임 중복 검사
	@ResponseBody
	@GetMapping("/titleDupCheck")
	public int titleDupCheck(String storeTitle) {
		System.out.println(storeTitle);
		int result = service.titleDupCheck(storeTitle);
				
		System.out.println(result);
		return result;
				
	}
	
	
	
	@PostMapping("/addStore")
	public String addStore(Store inputStore) {
		
		logger.debug("inputStore : " + inputStore);
		
		return null;
		
	}
	
	

}
