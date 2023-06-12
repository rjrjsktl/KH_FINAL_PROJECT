package com.kh.kgv.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.management.model.service.ManageCinemaService;

@Controller
@RequestMapping("/manager/manager_cinema_add")
@SessionAttributes({ "loginUser" })
public class ManageCinemaController {
	
	@Autowired
	private ManageCinemaService service;
	
	// private Logger logger = LoggerFactory.getLogger(ManageCinemaController.class);

	@PostMapping("/test")
	public String enrollCinema(
			@RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomStatus") String[] roomStatus
			) {
		
		// Gson gson = new Gson();
		System.out.println(cinemaName);
		System.out.println(roomStatus[0].replace("&quot;", "\""));
		return "redirect:/";
	}
	
	
	@GetMapping("/cinemaDupCheck")
	@ResponseBody
	public int cinemaDupCheck(String cinemaName) {
		System.out.println(cinemaName);
		int result = service.cinemaDupCheck(cinemaName);
		return result;
	} 

}
