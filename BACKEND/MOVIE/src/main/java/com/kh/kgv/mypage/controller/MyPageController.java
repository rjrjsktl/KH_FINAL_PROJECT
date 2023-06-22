package com.kh.kgv.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.Review;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.mypage.model.service.MyPageService;

@Controller
@RequestMapping("/myPage")
@SessionAttributes({"loginUser"}) // session scope에서 loginUser를 얻어옴
public class MyPageController {

	private Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private MyPageService service;
	
	@Autowired
	private ManagerService managerService;
	
	// 마이페이지 첫번째 화면
	// 로그인o -> 로그인page, 로그인x -> myPage
	@GetMapping("/myPgMain")
	public String myPgMain(HttpServletRequest req
//						, HttpServletResponse resp
						, RedirectAttributes ra
						, Model model
						) throws IOException {
		
		logger.info("1. 마이페이지 버튼 누름");
		
		String message = null;
		String path = null;
		
		HttpSession session = req.getSession(false);
		if( session != null && session.getAttribute("loginUser") != null) {
			logger.info("로그인 o 마페 ㄱㄱ");
			path = "myPage/myPage_home";
		} else {
			logger.info("로그인 x 로페 ㄱㄱ");
			message = "로그인 부터 하시라옹";

//			String referer = req.getHeader("Referer"); // 이전 페이지의 URL을 가져옵니다.
//	        session.setAttribute("prevPage", referer); // 이전 페이지의 URL을 세션에 저장합니다.
	           
	        path = "redirect:/user/login"; 
		}
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	// ===========================================================================================
	// ===========================================================================================
	// 사이드바 페이지 이동 영역
	@GetMapping("/myHome")
	public String myHome(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_home";
	}
	
	@GetMapping("/myMtm")
	public String myMtm(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_myMtmList";
	}
	
	@GetMapping("/myLostItem")
	public String myLostItem(Model model) {
		logger.info("LostList페이지 들어옴");
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_myLostList";
	}
	
	@GetMapping("/info")
	public String info(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_info";
	}
	
	@GetMapping("/myReview")
	public String myReview(
							Model model
//							, @RequestParam Map<String,Object> paramMap
							, @ModelAttribute("loginUser") User loginUser
							, RedirectAttributes ra) {
		
		logger.info("review페이지 시작");
//		logger.info("loginUserNo:::::" + loginUser.getUserNo() );
//		// 로그인된 회원의 번호를 paramMap 추가
//		
//		int userNo = loginUser.getUserNo();
//		
//		List<Review> myReviewList = service.myReviewList(userNo);
//
//		model.addAttribute("myReviewList", myReviewList);
//
//		logger.info("myReviewList::::" + myReviewList);

		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
		
		return "myPage/myPage_myReview";
	}
	
	@GetMapping("/myMovie")
	public String myMovie(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_myMovie";
	}
	
	@GetMapping("/changePw")
	public String changePw(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_changePw";
	}
	
	@GetMapping("/secession")
	public String secession(Model model) {
		
		// 메인 이벤트 목록 가지고 오기 - 7개
		Map<String, Object> getEvnetList = null;
		getEvnetList = managerService.mainEventList();
		model.addAttribute("getEvnetList", getEvnetList);
				
		return "myPage/myPage_secession";
	}
	
	// 사이드바 페이지 이동 영역
	// ===========================================================================================
	// ===========================================================================================
	
	// 회원 정보 수정
	@PostMapping("/info")
	public String updateInfo(@ModelAttribute("loginUser") User loginUser 
							, @RequestParam Map<String, Object> paramMap // 요청시 전달된 파라미터를 구분하지 않고 모두 Map에 담아서 얻어옴
							, String[] updateAddr
							, RedirectAttributes ra ) {
		
		logger.info("뜬다 updateInfo.info 페이지 들어왔다");
		
		// 파라미터를 저장한 paramMap에 회원번호, 주소를 추가
		String userAddr = String.join(",,", updateAddr); // 주소 배열 -> 문자열 변환
		
		// 주소가 미입력 되었을 때
		if(userAddr.equals(",,,,")) userAddr = null;
		
		paramMap.put("userNo", loginUser.getUserNo());
		paramMap.put("userAddr", userAddr);
		
		// 회원 정보 수정 서비스 호출
		int result = service.updateInfo(paramMap);
		
		String message = null;
		logger.info("돌아온 result:::" + result);
		if(result > 0) {
			message = "회원 정보가 수정되었습니다.";
			// DB - Session의 회원 정보 동기화
			loginUser.setUserNick( (String) paramMap.get("updateNick")  );
			
			loginUser.setUserTel( (String) paramMap.get("updateTel") );
			
			loginUser.setUserAddr( (String) paramMap.get("userAddr") );
			
		}else {
			message = "회원 정보 수정 실패...";
		}
		ra.addFlashAttribute("message", message);
		
		return "redirect:info";
	}
	
	// ===========================================================================================
	// ===========================================================================================
	
	// 회원 비밀번호 변경
	@PostMapping("/changePw")
	public String changePw( @RequestParam Map<String,Object> paramMap
							, @ModelAttribute("loginUser") User loginUser
							, RedirectAttributes ra) {
		
		// 로그인된 회원의 번호를 paramMap 추가
		paramMap.put( "userNo", loginUser.getUserNo() );
		
		// 비밀번호 변경 서비스 호출
		int result = service.changePw(paramMap);
		
		String message = null;
		
		if( result > 0 ) {
			// 변경 -> info
			message = "비밀번호가 변경되었습니다.";
		} else {
			// 실패 -> changePw
			message = "현재 비밀번호가 일치하지 않습니다.";
		}
		ra.addFlashAttribute("message", message);
		
		return "redirect:changePw";
	}
	
	// ===========================================================================================
	// ===========================================================================================
	
	// 회원 탈퇴
	@PostMapping("/secession") // session 의 회원정보 + 입력받은 파라미터(비밀번호)
	public String secession( @ModelAttribute("loginUser") User loginUser
							, SessionStatus status
							, HttpServletRequest req
							, HttpServletResponse resp
							, RedirectAttributes ra ) {
		
		// 회원 탈퇴 서비스 호출
		int result = service.secession(loginUser);
		
		String message = null;
		String path = null;
		
		if(result > 0) {
			// 탈퇴 성공 -> 메인페이지
			message = "탈퇴 되었습니다";
			path = "/";
			
			// 세션 없애기
			status.setComplete(); 
			
			
			// 쿠키 없애기
			Cookie cookie = new Cookie("saveId", "");
			cookie.setMaxAge(0);
			cookie.setPath(req.getContextPath());
			resp.addCookie(cookie);
			
		} else {
			// 탈퇴 실패 -> secession
			message = "현재 비밀번호가 일치하지 않습니다.";
			path = "secession";
			
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:" + path;
	}
	
	// Java 서버 예시 (Spring Framework)
	@PostMapping("/loadReviewCards")
	@ResponseBody
	public List<Review> loadReviewCards(@RequestParam int loadedCards
									, @RequestParam int cardsPerLoad
									, @ModelAttribute("loginUser") User loginUser
									, @RequestParam Map<String, Object> paramMap
									, Model model
														) {
		logger.info("reviewCards시작됨?");
		int userNo = loginUser.getUserNo();
		paramMap.put("userNo", userNo);
	    paramMap.put("loadedCards", loadedCards);
	    paramMap.put("cardsPerLoad", cardsPerLoad);
	    
	    List<Review> myReviewList = service.loadReviewCards(paramMap); // 데이터베이스에서 추가 데이터 조회

	    model.addAttribute("myReviewList", myReviewList);
	    logger.info("myReviewList", myReviewList);
	    return myReviewList;
	}

	
	
//	@PostMapping("myReview/addReview")
//	@ResponseBody
//	public List<Review> addReviewList(
//									@ModelAttribute("loginUser") User loginUser,
//									@RequestParam Map<String,Object> paramMap,
//	                                  @RequestParam("startMovie") int startMovie,
//	                                  @RequestParam("endMovie") int endMovie) {
//
//	    logger.info("addReviewList 호출");
//	    logger.info("loginUserNo:::::" + loginUser.getUserNo());
//
//	    int userNo = loginUser.getUserNo();
//	    
//	    paramMap.put("userNo", userNo);
//	    paramMap.put("startMovie", startMovie);
//	    paramMap.put("endMovie", endMovie);
//	    // startMovie와 endMovie를 사용하여 원하는 범위의 데이터를 가져오도록 수정
//	    List<Review> myReviewList = service.getReviewListInRange(paramMap);
//
//	    logger.info("myReviewList::::" + myReviewList);
//
//	    return myReviewList;
//	}
	
}
