package com.kh.kgv.management.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.kh.kgv.common.Util;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;

@Controller
@RequestMapping("/manager")
@SessionAttributes({"loginUser"})
public class ManagerController {
	
	@Autowired
	private ManagerService service;

	// 관리자_메인페이지 이동
	@GetMapping("/main")
	public String moveMain(
			Model model
			) {
		
		// 관리자 메인 신규 회원 목록 조회
		List<User>getUser = null;
		getUser = service.getAllUser();
		
		// 관리자 메인 공지사항 목록 조회
		List<Notice>getNotice = null;
		getNotice = service.getAllNotice();
		 
		model.addAttribute("getUser", getUser);
		model.addAttribute("getNotice", getNotice);
		
		
		System.out.println("관리자_메인페이지 이동");
		return "manager/managerPage";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_회원 리스트 이동
	@GetMapping("/member")
	public String moveMember(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp
			) {
		Map<String, Object>getUserList = null;
		
		// 회원 리스트 얻어오기
		getUserList = service.selectAll(cp);
		 
		model.addAttribute("getUserList", getUserList);
	
		System.out.println("관리자_회원 리스트 이동");
		return "manager/manager_member_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 회원 관리자 상태 업데이트
	@ResponseBody
	@PostMapping("/Manager_ST")
		public int  changeMgSt(
			@RequestParam("MST") String mst
			, @RequestParam("userId") String userId
			, User user
				) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + mst);
		System.out.println("AJAX로 가지고 온 userId의 값은 : " + userId);
		
		user.setUserManagerSt(mst);
		user.setUserEmail(userId);
		
		int result = service.updateST(user);
		
		if(result > 0) {
			System.out.println("관리자 상태 변경 완료");
			 result = 1;
			
		} else {
			System.out.println("관리자 상태 변경 실패");
			result = 0;
		}
		return result;
	}
	
	// ===================================================
	// ===================================================
	
	// 회원 이용제한 업데이트
	@ResponseBody
	@PostMapping("/Block_ST")
	public int  blockUser(
			@RequestParam("BST") String bst
			, @RequestParam("userId") String userId
			, User user
			) {
		
		user.setUserBlock(bst);
		user.setUserEmail(userId);
		
		int result = service.blockST(user);
		
		if(result > 0) {
			System.out.println("유저 이용제한 상태 변경 완료");
			result = 1;
			
		} else {
			System.out.println("유저 이용제한 상태 변경 실패");
			result = 0;
		}
		return result;
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_영화 등록 
	@ResponseBody
	@PostMapping("/movie_add")
	public int MovieAdd(Movie inputMovie
//							, RedirectAttributes ra 
							) {
		System.out.println("영화 등록 기능 수행");
			
		System.out.println("inputMovie: " + inputMovie);
			
		int result = service.MovieAdd(inputMovie);
			
		System.out.println("controller result:" + result);
		
	
		System.out.println("등록 ㄱㄱ");	
//		if(result > 0) {
//			message = "영화 등록 성공";
//			path = "/manager/movie_add";
//		} else {
//			message = "영화 등록 실패";
//			path = "/manager/movie_add";
//		}
			
//		ra.addFlashAttribute("message", message);
//		return "redirect:" + path;
		return result;
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_1:1 문의 목록 이동
	@GetMapping("/ask_list")
	public String moveAskList() {
		System.out.println("관리자_1:1 문의 목록 이동");
		return "manager/manager_ask_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_영화 목록 이동
	@GetMapping("/movie_list")
	public String moveMovieList(Model model) {
		// movielist 값 얻어오기
		Movie movie = new Movie();
		List<Movie> movielist = service.movieList(movie);
		System.out.println("movielist 값 :::::" + movielist);
		
		// movielist에서 따온 값 가공하기
//	    List<Movie> cleanedMovielist = Util.removeQuotes(movielist);
	    List<Movie> cleanedList = new ArrayList<>();
	    	for (Movie movie1 : movielist) {
	    		Movie cleanedMovie = new Movie();
	    		cleanedMovie.setMgNo(Util.removeQuotes(movie1.getMgNo()));
	    		cleanedMovie.setGenreCode(Util.removeQuotes(movie1.getGenreCode()));
	    		cleanedMovie.setMovieRuntime(movie1.getMovieRuntime());
	    		cleanedMovie.setMovieTitle(movie1.getMovieTitle());
	    		cleanedMovie.setMovieNation(movie1.getMovieNation());
	    		cleanedMovie.setMovieOpen(movie1.getMovieOpen());
	    		cleanedMovie.setMovieContent(movie1.getMovieContent());
	    		cleanedMovie.setMovieImg(movie1.getMovieImg());
	    		cleanedMovie.setMovieUploader(movie1.getMovieUploader());
	    		cleanedMovie.setMovieDirector(movie1.getMovieDirector());
	    		cleanedMovie.setMovieCast(movie1.getMovieCast());
	        
	    		cleanedList.add(cleanedMovie);
	    	}
	    
        // 다른 속성이 있다면 해당 속성에 대해서도 동일한 방식으로 처리
	    System.out.println("cleanedList 값 :::::" + cleanedList);
	    model.addAttribute("movielist", cleanedList);
//		model.addAttribute("movielist", movielist);
		
		System.out.println("관리자_영화 목록 이동");
		return "manager/manager_movie_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_영화 등록 이동
//	@GetMapping("/movie_add")
//	public String moveMovieAdd(Model model) {
//	    // movie grade 값 얻어오기
//	    List<String> mgradelist = service.mgradeList();
//	    // movie genre 값 얻어오기
//	    List<String> mgenrelist = service.mgenreList();
//	    
//	    // mgNo 값을 가공하여 적절한 형태로 변환
//	    List<String> cleanedMgradelist = new ArrayList<>();
//	    for (String mgrade : mgradelist) {
//	        String cleanedGrade = mgrade.replaceAll("[\"\\[\\]\\\\]", "").replace("&quot;", "");
//	        cleanedMgradelist.add(cleanedGrade);
//	    }
//	    System.out.println("cleanedMgradelist 값 :::::" + cleanedMgradelist);
//	    // genreCode 값을 가공하여 적절한 형태로 변환
//	    List<String> cleanedMgenrelist = new ArrayList<>();
//	    for (String mgenre : mgenrelist) {
//	        String cleanedGenre = mgenre.replaceAll("[\"\\[\\]\\\\]", "").replace("&quot;", "");
//	        cleanedMgenrelist.add(cleanedGenre);
//	    }
//	    System.out.println("cleanedMgenrelist 값 :::::" + cleanedMgenrelist);
//	    // Model에 데이터 추가
//	    model.addAttribute("mgradelist", cleanedMgradelist);
//	    model.addAttribute("mgenrelist", cleanedMgenrelist);
//	    
//	    return "manager/manager_movie_add";
//	}
	@GetMapping("/movie_add")
	public String moveMovieAdd(Model model) {

		
		// movie grade 값 얻어오기
		List<String> mgradelist = service.mgradeList();
		System.out.println("mgradelist 값 :::::" + mgradelist);
		
		model.addAttribute("mgradelist", mgradelist);
		// movie genre 값 얻어오기
		List<String> mgenrelist = service.mgenreList();
		System.out.println("mgenrelist 값 :::::" + mgenrelist);
		model.addAttribute("mgenrelist", mgenrelist);
		
		System.out.println("관리자_영화 등록 이동");
		return "manager/manager_movie_add";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_극장 등록 이동
	@GetMapping("/manager_cinema_add")
	public String moveCinemaAdd() {
		System.out.println("관리자_극장 등록 이동");
		return "manager/manager_cinema_add";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_극장 목록 이동
	@GetMapping("/manager_cinema_list")
	public String moveCinemaList() {
		System.out.println("관리자_극장 목록 이동");
		return "manager/manager_cinema_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_극장 가격 관리 이동
	@GetMapping("/manager_cinema_price")
	public String moveCinemaPrice() {
		System.out.println("관리자_극장 가격 관리 이동");
		return "manager/manager_cinema_price";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_상영시간 목록 이동
	@GetMapping("/play_list")
	public String movePlayList() {
		System.out.println("관리자_상영시간 목록 이동");
		return "manager/manager_movie_play_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_상영시간 등록 이동
	@GetMapping("/play_add")
	public String movePlayAdd() {
		System.out.println("관리자_상영시간 등록 이동");
		return "manager/manager_movie_play_add";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_이벤트 목록 이동
	@GetMapping("/event_list")
	public String moveEventList(
			Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp
			) {
		
	Map<String, Object>getEventList = null;
	
	// 이벤트 리스트 얻어오기
	getEventList = service.eventList(cp);
	 
	model.addAttribute("getEventList", getEventList);

		System.out.println("관리자_이벤트 목록 이동");
		return "manager/manager_event_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_이벤트 등록 이동
	@GetMapping("/event_add")
	public String moveEventAdd() {
		System.out.println("관리자_이벤트 등록 이동");
		return "manager/manager_event_add";
	}
	
	// ===================================================
	// ===================================================
	
		// 이벤트 수정
	@GetMapping("/event_list/edit/{eventNo}")
	public String editEvent(
	        Model model,
	        Event event,
	        @PathVariable("eventNo") int eventNo
			) {
		
		Map<String, Object>editEvent = null;
		
		event.setEventNo(eventNo);
		
		editEvent = service.getEditEventList(event);
		System.out.println("DAO에서 가지고 온 editEvent : " + editEvent);
		model.addAttribute("editEvent", editEvent);
		
		return "manager/manager_event_edit";
		
	}
	
	// ===================================================
	// ===================================================
	
	// 이벤트 수정(업데이트)
	@PostMapping("/event_list/edit/{eventNo}/edit_Event")
	@ResponseBody
	public int editEvent(
			@RequestParam("no") int  no
			, @RequestParam("title") String title
			, @RequestParam("start") String start
			, @RequestParam("end") String end
			, @RequestParam("content") String content
			) {
		Event event = new Event();
		event.setEventNo(no);
		event.setEventTitle(title);
		event.setEventStart(start);
		event.setEventEnd(end);
		event.setEventContent(content);
		
		System.out.println("이벤트 수정에서 가지고 온 값들 =================================" + event);
	
		int result = service.editEvent(event);

		return result;
	}
	
	// ===================================================
	// ===================================================
	
	//이벤트 상태 업데이트
	@ResponseBody
	@PostMapping("/event_ST")
		public int  changeEventSt(
			@RequestParam("EST") String est
			, @RequestParam("eventNo") int eventNo
			, Event  event
				) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + est);
		System.out.println("AJAX로 가지고 온 userId의 값은 : " + eventNo);
		
		event.setEventStatus(est);
		event.setEventNo(eventNo);
		
		int result = service.updateEventST(event);
		
		if(result > 0) {
			System.out.println("이벤트 상태 변경 완료");
			 result = 1;
			
		} else {
			System.out.println("이벤트 상태 변경 실패");
			result = 0;
		}
		return result;
	}
	
		// ===================================================
		// ===================================================
	
		// 이벤트 수정용 이미지 업로드
		@PostMapping("/event_list/edit/{eventNo}/edit_Event/uploadImageFile")
		@ResponseBody
		public String uploadImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
			JsonObject jsonObject = new JsonObject();

//			  String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

			// 내부경로로 저장
			String webPath = "/resources/images/fileupload/";

			String fileRoot = request.getServletContext().getRealPath(webPath);

			String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
			String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
			String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
				jsonObject.addProperty("url", request.getContextPath() + webPath + savedFileName); // contextroot +
																									// resources + 저장할 내부
																									// 폴더명
				jsonObject.addProperty("responseCode", "success");

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}
			String a = jsonObject.toString();
			System.out.println("================================================= 이미지 는?? : : " + a);
			return a;

		}
		
		// ===================================================
		// ===================================================
	
	// 관리자_공지사항 목록 이동
	@GetMapping("/notice_list")
	public String moveNoticeList(	Model model
			, @RequestParam(value = "cp", required = false, defaultValue="1" ) int cp) {
			
			Map<String, Object>getNoticeList = null;
			
			// 회원 리스트 얻어오기
			getNoticeList = service.noticeList(cp);
			 
			model.addAttribute("getNoticeList", getNoticeList);
		
		System.out.println("관리자_공지사항 목록 이동");
		return "manager/manager_notice_list";
	}
	
	// ===================================================
	// ===================================================
	
	// 관리자_공지사항 등록 이동
	@GetMapping("/notice_add")
	public String moveNoticeAdd() {
		System.out.println("관리자_공지사항 등록 이동");
		return "manager/manager_notice_add";
	}
	
	
	// ===================================================
	// ===================================================
	
	// 공지사항 등록
	@ResponseBody
	@PostMapping("/notice_add/write_Notice")
	public int addNotice(
			@RequestParam("title") String title
			, @RequestParam("content") String content
			, @RequestParam("userName") String userName
			) {
		Notice notice = new Notice();
		
		notice.setNoticeTitle(title);
		notice.setNoticeContent(content);
		notice.setNoticeUploader(userName);
		
		System.out.println("=============================================== notice : " + notice);
		
		int result = service.addNotice(notice);
		
		if(result > 0) {
			System.out.println("공지사항 등록 완료");
			 result = 1;
			
		} else {
			System.out.println("공지사항 등록 실패");
			result = 0;
		}
		return result;
	}
	
	// ===================================================
	// ===================================================
	
	// 공지사항 수정 조회
	@GetMapping("/notice_list/edit/{noticeNo}")
	public String editNotice(
	        Model model,
	        Notice notice,
	        @PathVariable("noticeNo") int noticeNo
			) {
		
		Map<String, Object>editNotice = null;
		
		notice.setNoticeNo(noticeNo);
		
		editNotice = service.getEditNoticeList(notice);
		System.out.println("DAO에서 가지고 온 editNotice : " + editNotice);
		model.addAttribute("editNotice", editNotice);
		
		return "manager/manager_notice_edit";
		
	}
	
	// ===================================================
	// ===================================================
	
	// 공지사항 수정(업데이트)
		@PostMapping("/notice_list/edit/{noticeNo}/edit_Notice")
		@ResponseBody
		public int editNotice(
				@RequestParam("no") int  no
				, @RequestParam("title") String title
				, @RequestParam("userName") String userName
				, @RequestParam("content") String content
				) {
			Notice  notice = new Notice();
			notice.setNoticeNo(no);
			notice.setNoticeTitle(title);
			notice.setNoticeUploader(userName);
			notice.setNoticeContent(content);
			
			System.out.println("이벤트 수정에서 가지고 온 값들 =================================" + notice);
		
			int result = service.editNotice(notice);

			return result;
		}
	
	// ===================================================
	// ===================================================
		
		//공지사항 상태 업데이트
		@ResponseBody
		@PostMapping("/notice_ST")
			public int  changeNoticeSt(
				@RequestParam("NST") String nst
				, @RequestParam("noticeNo") int noticeNo
				, Notice  notice
					) {
			
			notice.setNoticeStatus(nst);
			notice.setNoticeNo(noticeNo);
			
			int result = service.updateNoticeST(notice);
			
			if(result > 0) {
				System.out.println("공지사항 상태 변경 완료");
				 result = 1;
				
			} else {
				System.out.println("공지사항 상태 변경 실패");
				result = 0;
			}
			return result;
		}
		
			// ===================================================
			// ===================================================
	
	// 공지사항 등록용 이미지 업로드
		@PostMapping("/notice_add/noticeUploadImageFile")
		@ResponseBody
		public String noticeUploadImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
			JsonObject jsonObject = new JsonObject();

//			  String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

			// 내부경로로 저장
			String webPath = "/resources/images/fileupload/";

			String fileRoot = request.getServletContext().getRealPath(webPath);

			String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
			String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
			String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
				jsonObject.addProperty("url", request.getContextPath() + webPath + savedFileName); // contextroot +
																									// resources + 저장할 내부
																									// 폴더명
				jsonObject.addProperty("responseCode", "success");

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}
			String a = jsonObject.toString();
			System.out.println("================================================= 이미지 는?? : : " + a);
			return a;

		}
		
		// ===================================================
		// ===================================================
			
				// 공지사항 수정용 이미지 업로드
				@PostMapping("/notice_list/edit/{noticeNo}/edit_Notice/uploadImageFile")
				@ResponseBody
				public String uploadNoticeEditImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
					JsonObject jsonObject = new JsonObject();

//					  String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

					// 내부경로로 저장
					String webPath = "/resources/images/fileupload/";

					String fileRoot = request.getServletContext().getRealPath(webPath);

					String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
					String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
					String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

					File targetFile = new File(fileRoot + savedFileName);
					try {
						InputStream fileStream = multipartFile.getInputStream();
						FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
						jsonObject.addProperty("url", request.getContextPath() + webPath + savedFileName); // contextroot +
																											// resources + 저장할 내부
																											// 폴더명
						jsonObject.addProperty("responseCode", "success");

					} catch (IOException e) {
						FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
						jsonObject.addProperty("responseCode", "error");
						e.printStackTrace();
					}
					String a = jsonObject.toString();
					System.out.println("================================================= 이미지 는?? : : " + a);
					return a;

				}
				
				// ===================================================
				// ===================================================
				
				//관리자_스토어 물품 목록
				@GetMapping("/store_list")
				public String moveStoreList() {
					System.out.println("관리자_스토어 물품 목록");
					return "manager/manager_store_list";
				}
		
				// ===================================================
				// ===================================================
				
				// 관리자_스토어 물품 등록
				@GetMapping("/store_add")
				public String moveStoreAdd() {
					System.out.println("관리자_스토어 물품 등록");
					return "manager/manager_store_add";
				}
				
				// ===================================================
				// ===================================================
}
