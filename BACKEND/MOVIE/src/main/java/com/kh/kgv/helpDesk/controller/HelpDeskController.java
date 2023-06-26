package com.kh.kgv.helpDesk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
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
import com.kh.kgv.helpDesk.model.vo.Quest;
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

	// 고객센터 세부사항 진입 문제는 userNo이 없어서 카운트증가가 안되는데 어떻게하지..
	@RequestMapping("/notice_detail/{noticeNo}")
	public String noticedetail(
			Model model,
			@PathVariable("noticeNo") int noticeNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			) {
		Notice detail = services.selectNoticeDetail(noticeNo);


		if( detail != null ) {
			Cookie cookie = null;
			Cookie[] cArr = req.getCookies();
			if(cArr != null && cArr.length > 0) {
				for(Cookie c : cArr) {
					if(c.getName().equals("readnoticeNo")) {
						cookie = c;
					}
				}
				int result = 0;
				if ( cookie == null ) { 
					cookie = new Cookie("readnoticeNo", noticeNo+"");
					result = service.updateNoticeView(noticeNo);
					System.out.println("공지사항 카운트 업데이트 결과는 1성공 0실패입니다."+result);
				} else { 
					String[] temp = cookie.getValue().split("/");
					List<String> list = Arrays.asList(temp);
					if( list.indexOf(noticeNo+"") == -1 ) { 
						System.out.println("공지사항 카운트 업데이트 결과는 1성공 0실패입니다."+result);
						cookie.setValue( cookie.getValue() + "/" + noticeNo );
						result = service.updateNoticeView(noticeNo); 
					}
				}

				if (result > 0) {
					detail.setNoticeView(detail.getNoticeView() + 1); 

					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60 * 60 * 1);
					resp.addCookie(cookie);

				}
			}
		}

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



	// 1:1 문의 리스트 출력-------------------------------------------------
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

		int userMtmListCount = services.getuserMtmListCount(userNo,userManagerSt);

		model.addAttribute("mtmList", mtmList);
		model.addAttribute("userMtmListCount",userMtmListCount);

		return "helpDesk/mTm_List";
	}

	//1:1 문의사항 비밀번호 Get맵핑
	@GetMapping("/checkPw/{mtmNo}")
	public String checkPw (
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			@PathVariable("mtmNo") int mtmNo,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			) {

		User loginUser = (User)session.getAttribute("loginUser");

		String path = services.checkPasswordAccess(mtmNo, loginUser, cp);

		System.out.println(path);

		return path;
	}

	// 1:1 문의사항 비밀번호 Post맵핑
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

		return result;

	}

	// 1:1 문의사항 세부정보 확인
	@RequestMapping("/mtm_detail/{mtmNo}")
	public String mtmdetail(
			Model model,
			@PathVariable("mtmNo") int mtmNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(value = "cp", required = false, defaultValue="1") int cp

			){


		User loginUser = (User)session.getAttribute("loginUser");

		// Add password check here
		String checkResult = services.checkPasswordAccess(mtmNo, loginUser, cp);
		if (!("redirect:/helpDesk/mtm_detail/" + mtmNo + "?cp=" + cp).equals(checkResult)) {
			return checkResult;
		}

		System.out.println(checkResult);


		Mtm mTmdetail = services.selectmTmDetail(mtmNo);

		if (mTmdetail == null) {
			return "helpDesk/error";
		}

		int userNo = 0;

		if(loginUser != null ) {
			userNo = loginUser.getUserNo();
		}

		if( mTmdetail != null ) { 
			if( mTmdetail.getUserNo() != userNo ) {

				Cookie cookie = null;

				Cookie[] cArr = req.getCookies();

				if(cArr != null && cArr.length > 0) {

					for(Cookie c : cArr) {
						if(c.getName().equals("readMtmdNo")) {
							cookie = c;
						}
					}
				}

				int result = 0;

				if ( cookie == null ) { // 기존에 "readBoardNo" 이름의 쿠키가 없던 경우
					cookie = new Cookie("readMtmdNo", mtmNo+"");
					result = services.updateReadCount(mtmNo);

				} else { 

					String[] temp = cookie.getValue().split("/");


					List<String> list = Arrays.asList(temp); // 배열 -> List 변환

					if( list.indexOf(mtmNo+"") == -1 ) { // 기존 값에 같은 글번호가 없다면 추가

						cookie.setValue( cookie.getValue() + "/" + mtmNo );
						result = services.updateReadCount(mtmNo); // 조회수 증가 서비스 호출

					}
				}


				// 결과값 이용한 DB 동기화
				if (result > 0) {
					mTmdetail.setMtmCount(mTmdetail.getMtmCount() + 1); // 이미 조회된 데이터 DB 동기화

					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60 * 60 * 1);
					resp.addCookie(cookie);

				}
			}
		}

		System.out.println("=========================================================================" + mTmdetail);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(mTmdetail.getMtmContent());
		mTmdetail.setMtmContent(unescapedContent);



		model.addAttribute("mTmdetail", mTmdetail);
		mTmdetail.setUserNo(userNo);
		model.addAttribute("cp", cp);



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
			String referer = req.getHeader("Referer"); 
			session.setAttribute("prevPage", referer); 

			path ="redirect:/user/login";

		}

		model.addAttribute("userNo", userNo);
		return path; 
	}

	// 1:1문의 게시물 삽입 Post
	@PostMapping("/mTm_form")
	public ResponseEntity<Map<String, Object>> addmTm(
			@RequestParam("titleInput") String title, 
			@RequestParam("contentTextarea") String content,
			@RequestParam("inquirySelect") String inquiry,
			@RequestParam("open") int open, 
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
		mtm.setMtmPw(open);  

		System.out.println(open);



		services.addmTm(mtm);  

		int mtmNo = services.selectMtmNo(mtm);

		Map<String, Object> response = new HashMap<>();

		response.put("mtmNo", mtmNo);

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
			path = "helpDesk/mTm_List"+"?cp="+cp;
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
		model.addAttribute("lostList", lostList);
		model.addAttribute("lostCount", userLostCount);

		return "helpDesk/lost_List";
	}

	// 잃어버린물건 비밀번호 GetMapping
	@GetMapping("/checkLostPw/{lostNo}")
	public String checkLostPw (
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			@PathVariable("lostNo") int lostNo,
			Model model,
			RedirectAttributes ra,
			@RequestHeader ("referer") String referer,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp
			) {

		User loginUser = (User)session.getAttribute("loginUser");

		String path = services.checkLostPasswordAccess(lostNo, loginUser, cp);

		System.out.println(path);

		return path;
	}

	// 잃어버린물건 비밀번호 Post맵핑
	@ResponseBody
	@PostMapping("/checkLostPw/{lostNo}")
	public int compareLostPw (
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp,
			@PathVariable("lostNo") int lostNo,
			@RequestParam("password") int password,
			Model model,
			RedirectAttributes ra,
			HttpSession session
			) {

		System.out.println("현재 접속하려고하는 게시물의 비밀번호는?");
		System.out.println(password);

		int lostPw = 0;
		lostPw = services.selectmtmLostPw(lostNo);
		//		DB에있는 mtmPw의 값을 저장


		int result = 0;

		if(lostPw == password) {
			result = 1;

		} else {
			result = 0;
		}

		return result;

	}

	// 잃어버린물건 세부사항 진입
	@RequestMapping("/lost_detail/{lostNo}")
	public String lostdetail(
			Model model,
			@PathVariable("lostNo") int lostNo,
			HttpSession session,
			HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(value = "cp", required = false, defaultValue="1") int cp
			){

		User loginUser = (User)session.getAttribute("loginUser");

		String checkResult = services.checkLostPasswordAccess(lostNo, loginUser, cp);
		if (!("redirect:/helpDesk/lost_detail/" + lostNo + "?cp=" + cp).equals(checkResult)) {
			return checkResult;
		}

		System.out.println(checkResult);

		LostPackage lostdetail = services.selectLostDetail(lostNo);

		if (lostdetail == null) {
			return "helpDesk/error";
		}

		int userNo = 0;

		if(loginUser != null ) {
			userNo = loginUser.getUserNo();
		}

		if( lostdetail != null ) { 
			if( lostdetail.getUserNo() != userNo ) {

				Cookie cookie = null;

				Cookie[] cArr = req.getCookies();

				if(cArr != null && cArr.length > 0) {

					for(Cookie c : cArr) {
						if(c.getName().equals("readLostdNo")) {
							cookie = c;
						}
					}
				}

				int result = 0;

				if ( cookie == null ) { 
					cookie = new Cookie("readLostdNo", lostNo+"");
					result = services.updateLostReadCount(lostNo);

				} else { 

					String[] temp = cookie.getValue().split("/");


					List<String> list = Arrays.asList(temp);

					if( list.indexOf(lostNo+"") == -1 ) { 

						cookie.setValue( cookie.getValue() + "/" + lostNo );
						result = services.updateLostReadCount(lostNo); 

					}
				}


				if (result > 0) {
					lostdetail.setLostView(lostdetail.getLostView() + 1);

					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60 * 60 * 1);
					resp.addCookie(cookie);

				}
			}
		}



		System.out.println("=========================================================================" + lostdetail);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(lostdetail.getLostContent());
		lostdetail.setLostContent(unescapedContent);
		model.addAttribute("lostdetail", lostdetail);
		model.addAttribute("cp", cp);


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
			@RequestParam("open") int open,
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
		lost.setLostPw(open);

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
			path = "helpDesk/lost_List"+"?cp="+cp;
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


	@GetMapping("/question_home")
	public String question(
			Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp
			) {
		
		int questNum = 0;
		
		int qescount = services.getcountquestNum(questNum);
		model.addAttribute("qescount",qescount);

		return "helpDesk/question_home";
	}

	@PostMapping("/question_home")
	@ResponseBody
	public int postQuestion(
			Model model,
			@RequestParam("questNum") int questNum
			) {
		
		System.out.println(questNum);
		
		
		int qescount = services.getcountquestNum(questNum);
//		String qestitle = services.getTitle(questNum);

		model.addAttribute("qescount",qescount);
		
		System.out.println(qescount);
		
		System.out.println(model);
		
		return qescount;
	}
}