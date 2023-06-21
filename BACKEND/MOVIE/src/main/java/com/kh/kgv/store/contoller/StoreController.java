package com.kh.kgv.store.contoller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.management.model.service.ManagerService;

import com.kh.kgv.store.model.service.StoreService;

@Controller
@RequestMapping("/store")
@SessionAttributes({"loginUser"})
public class StoreController {

	
	@Autowired
	private StoreService service;
	
	@Autowired
	private ManagerService services;
	
	private Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	
	
	@RequestMapping("/storeMain")
	public String storeMain(Model model
			) {
		
		Map<String, Object> storeMap = null;
		storeMap = service.getStoreMap();
		
		logger.debug("storeMap : " + storeMap);
		model.addAttribute("storeMap", storeMap);
	
		return "store/storeMain";
	}
	
	@RequestMapping("/storeMain/store_detail/{storeNo}")
	public String getStoreDetail(Model model,
			 @PathVariable("storeNo") int storeNo
			 ,Store store
			 
			) {
		
//		store.setStoreNo(storeNo);
		
		Store getStoreDetail = service.getStoreDetail(store);
		
		logger.debug("getStoreDetail : " + getStoreDetail);
		
		model.addAttribute("storeDetail", getStoreDetail);
		
		return "store/store_detail";
	}
	
	

	
}
