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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	// 고객센터 접속
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

	// 고객센터 리스트 출력
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

	// 고객센터 세부사항 진입
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

	// 1:1문의 리스트 출력-------------------------------------------------
	@RequestMapping("/mTm_List")
	public String mtmList(
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue="1" ) int cp,
			RedirectAttributes ra,

			HttpSession session,
			HttpServletRequest req,HttpServletResponse resp
			){

		User loginUser = (User)session.getAttribute("loginUser");
		int userNo = 0;
		String userManagerSt = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
			userManagerSt = loginUser.getUserManagerSt();
		}

		Map<String, Object>mtmList = null;
		mtmList = services.getMtmList(cp,userNo,userManagerSt);

		//	로그인세션에 해당하는 MtmListcount를 받아오는 새로운 컨트롤러작성
		int userMtmListCount = services.getuserMtmListCount(userNo,userManagerSt);

		model.addAttribute("mtmList", mtmList);
		model.addAttribute("userMtmListCount",userMtmListCount);

		return "helpDesk/mTm_List";
	}

	// 1:1문의 세부사항 진입
	@RequestMapping("/mtm_detail/{mtmNo}")
	public String mtmdetail(
			Model model,
			@PathVariable("mtmNo") int mtmNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			){
		Mtm mTmdetail = services.selectmTmDetail(mtmNo);
		User loginUser = (User)session.getAttribute("loginUser");
		
		int userNo = 0;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
		}

		System.out.println("=========================================================================" + mTmdetail);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(mTmdetail.getMtmContent());
		mTmdetail.setMtmContent(unescapedContent);
		model.addAttribute("mTmdetail", mTmdetail);
		mTmdetail.setUserNo(userNo);


		return "helpDesk/mtm_detail";
	}

	// 1:1문의 게시물 삽입 Get
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

	// 1:1문의 게시물 삽입 Post
	@PostMapping("/mTm_form")
	public ResponseEntity<Map<String, Object>> addmTm(
			@RequestParam("titleInput") String title, 
			@RequestParam("contentTextarea") String content,
			@RequestParam("inquirySelect") String inquiry,
			HttpSession session) {

		User loginUser = (User)session.getAttribute("loginUser");

		int userNo = 0;
		String userNick = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
			userNick = loginUser.getUserNick();
		}

		Mtm mtm = new Mtm();

		content = content.replaceAll("\n", "<br>");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");

		mtm.setMtmTitle(title);
		mtm.setMtmContent(content);
		mtm.setMtmType(inquiry);
		mtm.setUserNo(userNo);
		mtm.setMtmWriter(userNick);

		services.addmTm(mtm);  

		int mtmNo = services.selectMtmNo(mtm);

		Map<String, Object> response = new HashMap<>();


		response.put("mtmNo", mtmNo);

		System.out.println("mtmNo------------------------------------------------" + mtmNo);


		return ResponseEntity.ok(response);
	}

	// 1:1문의 게시물 삭제
	@GetMapping("/deleteMtm/{mtmNo}")
	public String mtmDelete(
			@PathVariable("mtmNo") int mtmNo,
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer
			) {

		String path = null;
		String message = null;

		int result = services.deleteBoard(mtmNo);

		if(result > 0 ) {
			path = "helpDesk/mTm_List";
			message = "글 삭제에 성공했다.";

		}else {
			path = "referer";  
		}

		ra.addFlashAttribute("message",message);


		return "redirect:/" +path;
	}

	// 1:1문의 리플삭제
	@GetMapping("/replyDelete/{mtmNo}")
	public String replyDelete(
			@PathVariable("mtmNo") int mtmNo,
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer
			) {

		String path = null;
		String message = null;

		int result = services.replyDelete(mtmNo);

		if(result > 0 ) {
			path = "helpDesk/mtm_detail/{mtmNo}";
			message = "댓글 삭제에 성공했다.";

		}else {
			path = "referer";  
		}

		ra.addFlashAttribute("message",message);

		return "redirect:/" +path;
	}

	// 1:1문의 리플 등록
	@PostMapping("/replyWrite/{mtmNo}")
	public ResponseEntity<?> replyWrite(
			@PathVariable("mtmNo") int mtmNo,
			@RequestParam("contentTextarea") String content,
			Model model,	HttpSession session,
			RedirectAttributes ra
			){
		User loginUser = (User)session.getAttribute("loginUser");

		String managerNick = null;

		if(loginUser != null) {
			managerNick = loginUser.getUserNick();
		}

		content = content.replaceAll("\n", "<br>");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");


		int result = services.replyWrite(mtmNo, content, managerNick); 

		if(result > 0 ) {
			return ResponseEntity.ok("{\"redirectUrl\": \"/helpDesk/mtm_detail/" + mtmNo + "\"}");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

		}	    
	}




	////////////////////////////////////////////////////////////////////////////////////////////////////////////// 아래부터는 분실물리스트

	// 잃어버린물건 리스트 출력
	@RequestMapping("/lost_List")
	public String lostList(
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue="1" ) int cp,
			HttpSession session,
			RedirectAttributes ra,
			HttpServletRequest req, HttpServletResponse resp
			){

		User loginUser = (User)session.getAttribute("loginUser");


		int userNo = 0;
		String userManagerSt = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
			userManagerSt = loginUser.getUserManagerSt();
		}

		Map<String, Object>lostList = null;

		lostList = services.getLostList(cp,userNo,userManagerSt);


		int userLostCount = services.getLostListCount(userNo, userManagerSt);
		model.addAttribute("lostCount", userLostCount);


		model.addAttribute("lostList", lostList);

		return "helpDesk/lost_List";
	}

	// 잃어버린물건 세부사항 진입
	@RequestMapping("/lost_detail/{lostNo}")
	public String lostdetail(
			Model model,
			@PathVariable("lostNo") int lostNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			){

		User loginUser = (User)session.getAttribute("loginUser");
		String userNick = loginUser.getUserNick();


		LostPackage lostdetail = services.selectLostDetail(lostNo);
		if(lostdetail != null){
			System.out.println("=========================================================================" + lostdetail);
			String unescapedContent = StringEscapeUtils.unescapeHtml4(lostdetail.getLostContent());
			lostdetail.setLostContent(unescapedContent);
			model.addAttribute("lostdetail", lostdetail);
			model.addAttribute("userNick", userNick);

		} else {
			System.out.println("LostPackage is null for lostNo: " + lostNo);
		}

		return "helpDesk/lost_detail";

	}

	// 잃어버린물건 삽입 Get
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

	// 잃어버린물건 삽입 Post
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
		String userNick = null;

		if(loginUser != null) {
			userNo = loginUser.getUserNo();
			userNick = loginUser.getUserNick();

		}

		LostPackage lost = new LostPackage();

		details = details.replaceAll("\n", "<br>");
		details = details.replaceAll("\r\n", "<br>");
		details = details.replaceAll(" ", "&nbsp;");

		lost.setLostTitle(title);
		lost.setUserNo(userNo);  
		lost.setLostItem(item);
		lost.setLostLocation(area);
		lost.setLostContent(details);
		lost.setLostDate(date);
		lost.setLostWriter(userNick);

		services.addLost(lost);  

		int lostNo = services.selectLostNo(lost); 

		Map<String, Object> response = new HashMap<>();
		response.put("lostNo", lostNo);

		System.out.println("lostNo------------------------------------------------" + lostNo);


		return ResponseEntity.ok(response);
	}

	// 잃어버린물건 삭제
	@GetMapping("/deleteLost/{lostNo}")
	public String lostDelete(
			@PathVariable("lostNo") int lostNo,
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer
			) {

		String path = null;
		String message = null;

		int result = services.deleteLost(lostNo);

		if(result > 0 ) {
			path = "helpDesk/lost_List";
			message = "글 삭제에 성공했다.";

		}else {
			path = "referer";  
		}

		ra.addFlashAttribute("message",message);


		return "redirect:/" +path;
	}

	//잃어버린물건 답글 삭제
	@GetMapping("/replyLostDelete/{lostNo}")
	public String replyLostDelete(
			@PathVariable("lostNo") int lostNo,
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer
			) {

		String path = null;
		String message = null;

		int result = services.replyLostDelete(lostNo);

		if(result > 0 ) {
			path = "helpDesk/lost_detail/{lostNo}";
			message = "댓글 삭제에 성공했다.";

		}else {
			path = "referer";  
		}

		ra.addFlashAttribute("message",message);

		return "redirect:/" +path;
	}

	//replyLostWrite

	@PostMapping("/replyLostWrite/{lostNo}")
	public ResponseEntity<?> replyLostWrite(
			@PathVariable("lostNo") int lostNo,
			@RequestParam("contentTextarea") String content,
			Model model,	HttpSession session,
			RedirectAttributes ra
			){
		User loginUser = (User)session.getAttribute("loginUser");

		String managerNick = null;

		if(loginUser != null) {
			managerNick = loginUser.getUserNick();
		}

		content = content.replaceAll("\n", "<br>");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");


		int result = services.replyLostWrite(lostNo, content, managerNick); 

		if(result > 0 ) {
			return ResponseEntity.ok("{\"redirectUrl\": \"/helpDesk/lost_detail/" + lostNo + "\"}");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

		}	    
	}



	@RequestMapping("/question_home")
	public String question(
			Model model
			){
		return "helpDesk/question_home";
	}



	@GetMapping("/checkPw/{mtmNo}")
	public String checkPw (
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			@PathVariable("mtmNo") int mtmNo,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer,
			HttpSession session
			) {

		String path = null;

		User loginUser = (User)session.getAttribute("loginUser");
		int userNo = 0;
		String userManagerSt = null;


		if(loginUser != null ) {
			userNo = loginUser.getUserNo();
			userManagerSt = loginUser.getUserManagerSt();
		}
		else {
			userManagerSt = "N";
		}

		int mtmPw = 0;

		mtmPw = services.selectmtmPw(mtmNo);
		
		int mtmUserNo = services.selectUserNo(mtmNo);

		System.out.println("현재 접속중인 유저넘버는?"+userNo);
		System.out.println("현재 접속하려고하는 게시물의 비밀번호는?"+mtmPw);
		System.out.println("현재 접속하려고하는 게시물의 유저 번호는?"+mtmUserNo);
		System.out.println("현재 접속하려고하는 유저는 관리자인가요? "+userManagerSt);



		// 비회원이 비밀번호가 입력되어있는 게시물에 접근할 경우
		// >>>>>>> 로그인페이지로 이동시킨다.
		if ( userNo == 0 && mtmPw != 0 ) {
			path = "redirect:/user/login";
		} 

		// 로그인은 되어있는데 회원레벨이 관리자일 경우
		// 또는 게시물의 비밀번호가 0일 경우
		// 바로  보내버린다.
		if (userManagerSt.equals("Y") || mtmPw == 0) {
			path = "redirect:/helpDesk/mtm_detail/" + mtmNo;
		} 
		
		// 로그인은 되어있는데 세션의 회원번호가 테이블의 userNo와 같을경우
		// >> 바로 보내버린다.
		
		else if (userNo == mtmUserNo ) {
			path = "redirect:/helpDesk/mtm_detail/" + mtmNo;
		}

		// 로그인은 되어있는데 회원레벨이 일반고객일 경우
		// 비밀번호 입력창으로 보내버린다.
		else if (userManagerSt.equals("N") && userNo != 0) {
			path = "helpDesk/checkPw";
		} 

		System.out.println(path);

		return path;
	}


	@ResponseBody
	@PostMapping("/checkPw/{mtmNo}")
	public int comparePw (
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			@PathVariable("mtmNo") int mtmNo,
			@RequestParam("password") int password,
			Model model,
			RedirectAttributes ra,
			HttpSession session
			) {
		
		
		System.out.println("현재 접속하려고하는 게시물의 비밀번호는?");
		System.out.println(password);
		
		int mtmPw = 0;
		mtmPw = services.selectmtmPw(mtmNo);
//		DB에있는 mtmPw의 값을 저장
		
	
		int result = 0;
	
	    if(mtmPw == password) {
	    	result = 1;
	    
	    } else {
	    	result = 0;
	    }
	    
	    System.out.println(result+1);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    System.out.println(result);
	    
	    
	    return result;
		
	}


}


