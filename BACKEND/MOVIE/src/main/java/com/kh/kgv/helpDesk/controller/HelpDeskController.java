package com.kh.kgv.helpDesk.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.helpDesk.model.service.HelpDeskService;
import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.login.controller.LoginController;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.Notice;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/helpDesk")
@SessionAttributes({"loginUser"})
public class HelpDeskController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);


	@Autowired
	private ManagerService service;
	@Autowired
	private HelpDeskService services;




	@RequestMapping("/helpDesk_home")
	public String helpDesk(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp	
			) {

		Map<String, Object> getEvnetList = null;
		getEvnetList = service.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);

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

		int userNo = 0;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		Map<String, Object>mtmList = null;

		mtmList = services.getMtmList(cp,userNo);

		int mtmCount = 0;
		mtmCount = services.getMtmListCount(userNo);
		model.addAttribute("mtmCount", mtmCount);
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



	@GetMapping("/mTm_form")
	public String mtmWrite(
			Model model,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp

			) {

		User loginUser = (User)session.getAttribute("loginUser");

		int userNo = 0;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		String path = null;

		if ( userNo > 0) {
			path = "helpDesk/mTm_form";
		} else {
			String referer = req.getHeader("Referer"); // 이전 페이지의 URL을 가져옵니다.
			session.setAttribute("prevPage", referer); // 이전 페이지의 URL을 세션에 저장합니다.

			logger.debug("referer은~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+referer);
			path ="redirect:/user/login";

		}

		System.out.println("userNo"+userNo+"-----------------------------------------------------------------------");


		model.addAttribute("userNo", userNo);
		return path; 
	}


	@PostMapping("/mTm_form")
	public ResponseEntity<Map<String, Object>> addmTm(
			@RequestParam("titleInput") String title, 
			@RequestParam("contentTextarea") String content,
			@RequestParam("inquirySelect") String inquiry,
			HttpSession session) {

		User loginUser = (User)session.getAttribute("loginUser");

		int userNo = 0;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		Mtm mtm = new Mtm();

		mtm.setMtmTitle(title);
		mtm.setMtmContent(content);
		mtm.setMtmType(inquiry);
		mtm.setUserNo(userNo);

		int mtmNo = services.selectMtmNo(mtm); 

		Map<String, Object> response = new HashMap<>();


		response.put("mtmNo", mtmNo);

		System.out.println("mtmNo------------------------------------------------" + mtmNo);


		return ResponseEntity.ok(response);
	}


	@RequestMapping("/lost_List")
	public String lostList(
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue="1" ) int cp,
			HttpSession session,
			RedirectAttributes ra,
			HttpServletRequest req, HttpServletResponse resp
			){

		User loginUser = (User)session.getAttribute("loginUser");


		int userNo = 1000000000;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		Map<String, Object>lostList = null;

		lostList = services.getLostList(cp,userNo);

		int lostCount = 0;

		lostCount = services.getLostListCount(userNo);
		model.addAttribute("lostCount", lostCount);


		model.addAttribute("lostList", lostList);

		return "helpDesk/lost_List";
	}


	@RequestMapping("/lost_detail/{lostNo}")
	public String lostdetail(
			Model model,
			@PathVariable("lostNo") int lostNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			){

		LostPackage lostdetail = services.selectLostDetail(lostNo);
		if(lostdetail != null){
			System.out.println("=========================================================================" + lostdetail);
			String unescapedContent = StringEscapeUtils.unescapeHtml4(lostdetail.getLostContent());
			lostdetail.setLostContent(unescapedContent);
			model.addAttribute("lostdetail", lostdetail);
		} else {
			System.out.println("LostPackage is null for lostNo: " + lostNo);
		}

		return "helpDesk/lost_detail";

	}


	@GetMapping("/lost_form")
	public String lostwrite(
			Model model,
			HttpSession session,		HttpServletRequest req, HttpServletResponse resp
			) {

		User loginUser = (User)session.getAttribute("loginUser");

		int userNo = 0;

		String path = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}
		model.addAttribute("userNo", userNo);

		if ( userNo > 0) {
			path = "helpDesk/lost_form";
		} else {
			String referer = req.getHeader("Referer"); // 이전 페이지의 URL을 가져옵니다.
			session.setAttribute("prevPage", referer); // 이전 페이지의 URL을 세션에 저장합니다.

			logger.debug("referer은~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+referer);
			path ="redirect:/user/login";


		}

		return path; 
	}


	@PostMapping("/lost_form")
	public ResponseEntity<Map<String, Object>> addLost(
			@RequestParam("titleInput") String title, 
			@RequestParam("lostItem") String item, 
			@RequestParam("lostArea") String area, 
			@RequestParam("lostDate") String date, 
			@RequestParam("contentTextarea") String details,
			HttpSession session) {

		User loginUser = (User)session.getAttribute("loginUser");

		int userNo = 0;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		LostPackage lost = new LostPackage();

		lost.setLostTitle(title);
		lost.setUserNo(userNo);
		lost.setLostItem(item);
		lost.setLostLocation(area);
		lost.setLostContent(details);
		lost.setLostDate(date);

		services.addLost(lost);  

		int lostNo = services.selectLostNo(lost); 

		Map<String, Object> response = new HashMap<>();
		response.put("lostNo", lostNo);

		System.out.println("lostNo------------------------------------------------" + lostNo);


		return ResponseEntity.ok(response);
	}






	@RequestMapping("/question_home")
	public String question(
			Model model
			){
		return "helpDesk/question_home";
	}

}


