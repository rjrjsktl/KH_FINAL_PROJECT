package com.kh.kgv.helpDesk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.helpDesk.model.service.HelpDeskService;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.Notice;
import org.apache.commons.text.StringEscapeUtils;


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


	@Autowired
	private HelpDeskService services;
	
	@RequestMapping("/notice_detail/{noticeNo}")
	public String noticedetail(
			Model model,
			@PathVariable("noticeNo") int noticeNo,
			HttpSession session,
			HttpServletRequest req,HttpServletResponse resp 
			) {

		Notice detail = services.selectNoticeDetail(noticeNo);


		

		model.addAttribute("detail", detail);
		return "helpDesk/notice_detail";

	}


}


