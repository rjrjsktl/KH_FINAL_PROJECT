package com.kh.kgv.store.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

	
	@RequestMapping("/storeMain")
	public String storeMain() {
		return "store/storeMain";
	}
	
}