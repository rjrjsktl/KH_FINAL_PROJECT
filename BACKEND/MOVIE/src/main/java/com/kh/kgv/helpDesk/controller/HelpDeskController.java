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
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.Notice;

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

	@RequestMapping("/notice_detail")
	public String noticedetail(
			Model model,
			@PathVariable("noticeNo") int noticeNo,
			HttpSession session,
			HttpServletRequest req,HttpServletResponse resp 
			) {

		
//		// Detail 내용들 가져올 detail
//		Notice detail = service.selectNoticeDetail(noticeNo);
//
//
//
//		if( detail != null ) { 
//
//			Cookie cookie = null; 
//
//			Cookie[] cArr = req.getCookies(); 
//
//			if(cArr != null && cArr.length > 0) { 
//
//				for(Cookie c : cArr) {
//
//					if(c.getName().equals("noticeView")) {
//						cookie = c;
//
//					}
//
//				}
//			}
//
//
//
//			int result = 0;
//
//
//
//			if ( cookie == null ) { // 기존에 "readBoardNo" 이름의 쿠키가 없던 경우
//				cookie = new Cookie("readBoardNo", noticeNo+"");
//				result = service.updateReadCount(noticeNo);
//
//			} else { 
//				String[] temp = cookie.getValue().split("/");
//
//
//
//				List<String> list = Arrays.asList(temp); 
//
//				if( list.indexOf(noticeNo+"") == -1 ) { // 기존 값에 같은 글번호가 없다면 추가
//
//					cookie.setValue( cookie.getValue() + "/" + noticeNo );
//					result = service.updateReadCount(noticeNo); // 조회수 증가 서비스 호출
//
//				}
//			}
//
//
//			// 결과값 이용한 DB 동기화
//			if (result > 0) {
//				detail.setNoticeView(detail.getNoticeView() + 1); // 이미 조회된 데이터 DB 동기화
//
//				cookie.setPath(req.getContextPath());
//				cookie.setMaxAge(60 * 60 * 1);
//				resp.addCookie(cookie);
//
//			}
//		}
//
//		model.addAttribute("detail", detail);
		return "notice/notice_detail";

	}


}


