package com.kh.kgv.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.management.model.service.ManageStoreService;
import com.kh.kgv.management.model.vo.Event;



@Controller
@RequestMapping("/manager/store_add")
@SessionAttributes({ "loginUser" })
public class ManageStoreController {
	
	@Autowired
	private ManageStoreService service;
	
	private Logger logger = LoggerFactory.getLogger(ManageStoreController.class);
	
	
	
	// 이름 중복 검사
	@ResponseBody
	@GetMapping("/NameDupCheck")
	public int NameDupCheck(String storeName) {
		System.out.println(storeName);
		int result = service.NameDupCheck(storeName);
				
		System.out.println(result);
		return result;
				
	}
	
	
	@ResponseBody
	@PostMapping("/addStore")
	public int addStore(@RequestParam("storeCategory") String storeCategory,
			@RequestParam("storeName") String storeName,
			@RequestParam("storeDesc") String storeDesc,
			@RequestParam("storePrice") int storePrice,
			@RequestParam("storeStock") int storeStock,
			@RequestParam("storeImage") String storeImage) {
		
		logger.debug("storeCategory : " + storeCategory);
		logger.debug("storeCategory : " + storeName);
		logger.debug("storeCategory : " + storeDesc);
		logger.debug("storeCategory : " + storePrice);
		logger.debug("storeCategory : " + storeStock);
		logger.debug("storeCategory : " + storeImage);
		
		Store store  = new Store();
		store.setStoreCategory(storeCategory);
		store.setStoreName(storeName);
		store.setStoreDesc(storeDesc);
		store.setStorePrice(storePrice);
		store.setStoreStock(storeStock);
		store.setStoreImage(storeImage);
		
		int result = service.addStore(store);
		
		
		
		
		return  result;
		
		
		
		
	}
	
	

}
