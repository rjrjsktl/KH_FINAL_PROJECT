package com.kh.kgv.management.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kh.kgv.management.model.service.ManagerService;

@Controller
@RequestMapping("/event_add")
@SessionAttributes({ "loginUser" })
public class ManagerEventController {

	@Autowired
	private ManagerService service;

	@PostMapping("/write_Event")
	public String addEvent() {

		return null;

	}
//	@Override
//	public void profileUpload(String email, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
//	response.setContentType("text/html;charset=utf-8");
//	PrintWriter out = response.getWriter();
//	// 업로드할 폴더 경로
//	String realFolder = request.getSession().getServletContext().getRealPath("profileUpload");
//	UUID uuid = UUID.randomUUID();
//
//	// 업로드할 파일 이름
//	String org_filename = file.getOriginalFilename();
//	String str_filename = uuid.toString() + org_filename;
//
//	System.out.println("원본 파일명 : " + org_filename);
//	System.out.println("저장할 파일명 : " + str_filename);
//
//	String filepath = realFolder + "\\" + email + "\\" + str_filename;
//	System.out.println("파일경로 : " + filepath);
//
//	File f = new File(filepath);
//	if (!f.exists()) {
//	f.mkdirs();
//	}
//	file.transferTo(f);
//	out.println("profileUpload/"+email+"/"+str_filename);
//	out.close();
//	}
}
