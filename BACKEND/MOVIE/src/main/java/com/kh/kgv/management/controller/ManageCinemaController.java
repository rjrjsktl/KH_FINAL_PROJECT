package com.kh.kgv.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/manager/manager_cinema_add")
@SessionAttributes({ "loginUser" })
public class ManageCinemaController {
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

}
