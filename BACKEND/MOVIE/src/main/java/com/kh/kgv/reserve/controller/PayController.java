package com.kh.kgv.reserve.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.kgv.reserve.model.service.PayService;
import com.kh.kgv.reserve.model.service.ReserveService;
import com.kh.kgv.store.model.vo.StoreCoupon;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private PayService service;
	
	private List<StoreCoupon> storeCouponList = null;
	
	// 결제페이지로 이동하기
	@GetMapping("/pay")
	public String movePay(HttpServletRequest req,
						  Model model) {
		
		HttpSession session = req.getSession();
		
		int priceNo = (int) session.getAttribute("priceNo");
		int bookNo = (int) session.getAttribute("bookNo");
		
		// 예매금액 찾기
		String result = service.serchPrice(bookNo);
		
		model.addAttribute("reservePrice", result);
		
		
		return "pay/pay";
	}
	
	@PostMapping("/selectTicket")
	@ResponseBody
	public List<StoreCoupon> selectCoupon(@RequestParam("COUPONNO") String couponNo,
							Model model) {
		
		System.out.println("쿠폰번호 들어옴?");
		
		storeCouponList = service.selectCoupon(couponNo);
		
		System.out.println("couponNo:::: "+couponNo);
		System.out.println("검색한 쿠폰정보 ::::"+storeCouponList);
		
//		model.addAttribute("storeCouponList", storeCouponList);
		
				
		return storeCouponList;
	}
	

}
