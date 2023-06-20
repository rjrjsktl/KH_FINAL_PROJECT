package com.kh.kgv.management.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.kh.kgv.common.Util;
import com.kh.kgv.management.model.service.ManagerBenefitsService;
import com.kh.kgv.management.model.vo.Benefits;

@Controller
@RequestMapping("/manager/benefits_add")
@SessionAttributes({ "loginUser" })
public class ManagerBenefitsController {
	
	@Autowired
	private ManagerBenefitsService service;
	
	// 혜택 등록
	@PostMapping("write_Event")
	@ResponseBody
	public int addBenefits(Benefits bene) {
		
		int result = service.addBenefits(bene);
		
		return result;
	}
	
	// 혜택 등록용 이미지 업로드
	@PostMapping("uploadImageFile")
	@ResponseBody
	public String uploadImageFile(@RequestParam("file") MultipartFile multipartFile,
								HttpServletRequest request) {
		
		JsonObject jsonObject = new JsonObject();
		
		// 내부경로로 저장
		String webPath = "/resources/images/benefits_img/";
		
		String fileRoot = request.getServletContext().getRealPath(webPath);
		
		String originalFileName = multipartFile.getOriginalFilename();
		String saveFileName = Util.fileRename(originalFileName);
		
		File targetFile = new File(fileRoot + saveFileName);
		
		
		String a = jsonObject.toString();
		
		
		
		
		
		
		
		return a;
	}
	
}
