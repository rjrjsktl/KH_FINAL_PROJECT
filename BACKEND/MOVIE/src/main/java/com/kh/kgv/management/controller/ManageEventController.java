package com.kh.kgv.management.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.kh.kgv.management.model.service.ManagerService;

@Controller
@RequestMapping("/manager/event_add")
@SessionAttributes({ "loginUser" })
public class ManageEventController {

	@Autowired
	private ManagerService service;

	@PostMapping("/write_Event")
	public String addEvent() {

		return null;
	}
	
	@PostMapping("uploadImageFile")
	@ResponseBody
	public String uploadImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		

//		  String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

		
		// 내부경로로 저장
		String webPath = "/resources/images/fileupload/";
		
	    String fileRoot = request.getServletContext().getRealPath(webPath);
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
	    try {
	        InputStream fileStream = multipartFile.getInputStream();
	        FileUtils.copyInputStreamToFile(fileStream, targetFile);    // 파일 저장
	        jsonObject.addProperty("url", request.getContextPath() + "/resources/fileupload/" + savedFileName); // contextroot + resources + 저장할 내부 폴더명
	        jsonObject.addProperty("responseCode", "success");
				
	    } catch (IOException e) {
	        FileUtils.deleteQuietly(targetFile);    // 저장된 파일 삭제
	        jsonObject.addProperty("responseCode", "error");
	        e.printStackTrace();
		}
		String a = jsonObject.toString();
		System.out.println("================================================= 이미지 는?? : : " + a);
		return a;
		
	}	
}
