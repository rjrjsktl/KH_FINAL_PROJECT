package com.kh.kgv.store.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.common.Util;
import com.kh.kgv.common.Util.SessionUtil;
import com.kh.kgv.customer.model.vo.User;
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
	
	
	@ResponseBody
	@PostMapping("/storeMain/store_detail/{storeNo}/getStorePayment")
	public String getStorePayment (
			Model model,
			@RequestParam("totalPrice") int totalPrice
			,@RequestParam("totalCount") int totalCount,
			@PathVariable("storeNo") int storeNo,
			Store store
			,HttpServletRequest request)  {
		
		  HttpSession session = request.getSession();
		
		
		  session.setAttribute("totalPrice", totalPrice);
		    session.setAttribute("totalCount", totalCount);
		    
		    
		logger.debug(" totalPrice : " + totalPrice);
		logger.debug(" totalCount : " + totalCount);
		
		return "store/store_payment";
	
		
	}
	
	

	@GetMapping("/login") 	
	@RequestMapping("/storeMain/store_detail/store_payment/{storeNo}")
	public String storePayment ( 
			@PathVariable("storeNo") int storeNo 			
			,Store store
			,Model model
			,HttpServletResponse response
			,HttpServletRequest request
			,HttpSession session) throws Exception{

		int totalPrice = (int) session.getAttribute("totalPrice");
	    int totalCount = (int) session.getAttribute("totalCount");
	    
	    logger.debug(" totalPrice************** : " + totalPrice);
	    logger.debug(" totalCount*************** : " + totalCount);
		
		logger.debug(" store : " + store);
		Store getStore = service.getStoreDetail(store);
		
		
		model.addAttribute("storeDetail", getStore);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("totalCount", totalCount);
		
		
		
		User  loginUser = (User) SessionUtil.getSession().getAttribute("loginUser");
		
		if(loginUser == null ) {
			
			Util.alertAndBackPage(response, "로그인을 하셔야 합니다.");
					
			 
			return null;
			}
		
		return  "store/store_payment";
	}
	

	

	
}
