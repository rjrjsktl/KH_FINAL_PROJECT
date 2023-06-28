package com.kh.kgv.store.contoller;

import org.springframework.stereotype.Controller;

import com.kh.kgv.items.model.vo.Genre;
import com.siot.IamportRestClient.IamportClient;

@Controller
public class ImportApiController {
		
	 private IamportClient api;
	 
		
		
	 public ImportApiController() {
		 	
	        // REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
	        this.api = new IamportClient("[복사했던 REST API키]","[복사했던 REST API secret]");
	    }

}
