package com.kh.kgv.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.login.model.service.SignUpService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	@Autowired
	private SignUpService service;
	
	
	// 회원가입 sns 화면
		@RequestMapping("/signUp_sns")
		public String signUp_sns() {
			return "signUp/signUp_sns";
		}
			
		// 이메일 회원가입 창
		@RequestMapping("/signUp")
		public String signUp() {
			return "signUp/signUp";
		}
	
		// 이메일 중복 검사
		@ResponseBody
		@GetMapping("/emailDupCheck")
		public int emailDupCheck(String userEmail) {
			
			int result = service.emailDupCheck(userEmail);
			
			
			System.out.println(result);
			return result;
		}
		
		// 닉네임 중복 검사
		@ResponseBody
		@GetMapping("/nicknameDupCheck")
		public int nicknameDupCheck(String userNick) {
			
			int result = service.nicknameDupCheck(userNick);
			
			System.out.println(result);
			return result;
			
		}
		
		//이름 중복 검사
		@ResponseBody
		@GetMapping("nameDupCheck")
		public int nameDupCheck(String userName ) {
			
			int result = service.nameDupCheck(userName);
			
			System.out.println(result);
			return result;
		}
		
		//회원 가입
		@PostMapping("/signUp")
		public String signUp(User inputUser
							,String[] userAddr
							,RedirectAttributes ra	) {
			
			inputUser.setUserAddr( String.join(",,", userAddr));
			
			if (inputUser.getUserAddr().equals(",,,,")) {
				
				inputUser.setUserAddr(null);
			}
			
			System.out.println(inputUser + "============================================================");
			
			int result = service.signUp(inputUser);
			
			System.out.println(result);
			String message =null;
			String path =null;
			
			
			if(result > 0) {
				message = "회원가입 성공!";
				path = "redirect:/";
			}else {
				message = "회원가입 실패";
				path = "redirect:/signUp/signUp_sns";
			}
			
			ra.addFlashAttribute("message", message);
			return path;
		}
		
}
