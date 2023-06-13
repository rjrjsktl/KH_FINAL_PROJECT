package com.kh.kgv.helpDesk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.kgv.management.model.service.ManagerService;

@Controller
@RequestMapping("/helpDesk")
public class HelpDeskController {

	@Autowired
	private ManagerService service;


	@RequestMapping("/helpDesk_home")
	public String helpDesk() {
		return "helpDesk/helpDesk_home";
	}

	@RequestMapping("/notice_List")
	public String noticeList(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp) {

		Map<String, Object>getNoticeList = null;

		getNoticeList = service.noticeList(cp);

		model.addAttribute("getNoticeList", getNoticeList);

		return "helpDesk/notice_List";
	}





}
