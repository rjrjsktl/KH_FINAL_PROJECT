package com.kh.kgv.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	@GetMapping("/choicePlay")
	public String enterReserve() {
		return "reserve/choicePlay";
	}
}
