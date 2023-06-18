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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.helpDesk.model.service.HelpDeskService;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.Notice;
import org.apache.commons.text.StringEscapeUtils;


@Controller
@RequestMapping("/helpDesk")
@SessionAttributes({"loginUser"})
public class HelpDeskController {

	@Autowired
	private ManagerService service;
	@Autowired
	private HelpDeskService services;


	@RequestMapping("/helpDesk_home")
	public String helpDesk(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp	
			) {

		Map<String, Object>userNoticeList = null;

		userNoticeList = service.userNoticeList(cp);

		model.addAttribute("userNoticeList", userNoticeList);

		return "helpDesk/helpDesk_home";
	}

	@RequestMapping("/notice_List")
	public String noticeList(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp) {


		int listCount = 0;
		listCount = service.getNoticeListCount();
		model.addAttribute("listCount", listCount);

		Map<String, Object>userNoticeList = null;

		userNoticeList = service.userNoticeList(cp);
		model.addAttribute("userNoticeList", userNoticeList);


		return "helpDesk/notice_List";
	}


	

	@RequestMapping("/notice_detail/{noticeNo}")
	public String noticedetail(
			Model model,
			@PathVariable("noticeNo") int noticeNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			) {
		Notice detail = services.selectNoticeDetail(noticeNo);
		System.out.println("=========================================================================" + detail);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(detail.getNoticeContent());
		detail.setNoticeContent(unescapedContent);
		model.addAttribute("detail", detail);

		Notice prevNotice = services.getPreviousNotice(noticeNo);
		model.addAttribute("prev", prevNotice);

		Notice nextNotice = services.getNextNotice(noticeNo);
		model.addAttribute("next", nextNotice);

		return "helpDesk/notice_detail";
	}


	@RequestMapping("/mTm_List")
	public String mtmform(
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue="1" ) int cp,
				RedirectAttributes ra,
			HttpSession session,
			HttpServletRequest req,HttpServletResponse resp
			){
		
		User loginUser = (User)session.getAttribute("loginUser");

		
		int userNo = 1000000000;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		Map<String, Object>mtmList = null;
		
		mtmList = services.getMtmList(cp,userNo);
		
		model.addAttribute("mtmList", mtmList);
	
		return "helpDesk/mTm_List";
	}

	
	@RequestMapping("/mtm_detail/{mtmNo}")
	public String mtmdetail(
			Model model,
			@PathVariable("mtmNo") int mtmNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			){
		Mtm mTmdetail = services.selectmTmDetail(mtmNo);
		System.out.println("=========================================================================" + mTmdetail);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(mTmdetail.getMtmContent());
		mTmdetail.setMtmContent(unescapedContent);
		model.addAttribute("mTmdetail", mTmdetail);

		return "helpDesk/mtm_detail";
		
	}











	@RequestMapping("/question_home")
	public String question(
			Model model
			){
		return "helpDesk/question_home";
	}

	@RequestMapping("/lost_List")
	public String lostList(
			Model model
			){
		return "helpDesk/lost_List";
	}

}


