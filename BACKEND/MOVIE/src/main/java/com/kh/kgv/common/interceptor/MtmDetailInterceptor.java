//package com.kh.kgv.common.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.kh.kgv.helpDesk.controller.HelpDeskController;
//import com.kh.kgv.helpDesk.model.service.HelpDeskService;
//
//@SuppressWarnings("deprecation")
//public class MtmDetailInterceptor implements HandlerInterceptor   {
//	
//	
////	checkPwservice 수정필요
//	
//	
//	  private final HelpDeskController checkPwService;
//
//	    public MtmDetailInterceptor(HelpDeskController checkPwService) {
//	        this.checkPwService = checkPwService;
//	    }
//	    
//	    @Override
//	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//	        String mtmNo = request.getRequestURI().split("/")[2];
//	        String path = checkPwService.checkPw(mtmNo, request.getSession()); 
//
//	        if (!path.contains("mtm_detail")) {
//	            response.sendRedirect(path);
//	            return false;
//	        }
//	        
//	        return true;
//	    }
//}
