package com.kh.kgv.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	@RequestMapping("/choicePlay")
	public String enterReserve() {
		return "reserve/choicePlay";
	}
}
