package com.kh.kgv.main.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.kgv.main.controller.model.service.EnterCheckService;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.DailyEnter;

@Controller
@SessionAttributes({"loginUser"})
public class MainController {



	/*
	 * http://localhost:8080/comm/main
	 * http://localhost:8080/comm/
	 * 
	 * */

	//	접속 수 확인
	@Autowired
	private EnterCheckService service;
	
	@Autowired
	private ManagerService services;
	

	@RequestMapping("/main")
	public String mainForward(HttpServletRequest request,  DailyEnter de,
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp
			) {
		String pageMove = null;

		// IP 찾는 로직
		// 사용하려면  "메뉴RUN > Run Configurations > Arguments >에서 -Djava.net.preferIPv4Stack=true" 추가해야함
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null) { ip = request.getRemoteAddr(); }

		de.setDeIp(ip);

		int result = service.inputEnter(de);

		if(result > 0) {
			System.out.println("접속한 아이피 주소는 : " + ip);
			pageMove = "common/main";
		} else {
			System.out.println("접속 기록을 추가하지 못함.");
		}
		
		Map<String, Object>getNoticeList = null;

		// 회원 리스트 얻어오기
		getNoticeList = services.noticeList(cp);
		
		model.addAttribute("getNoticeList", getNoticeList);

		System.out.println("관리자_공지사항 목록 이동");
		
		return pageMove;
	}
	

	

}

