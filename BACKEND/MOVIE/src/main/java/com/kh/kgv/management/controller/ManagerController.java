package com.kh.kgv.management.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kh.kgv.common.Util;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.management.model.service.ManageStoreService;
import com.kh.kgv.management.model.service.ManagerService;
import com.kh.kgv.management.model.vo.CinemaPrice;
import com.kh.kgv.management.model.vo.DailyEnter;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.WeeklyEnter;
import com.kh.kgv.management.model.vo.banner;
import com.kh.kgv.movieList.model.service.MovieService;
import com.kh.kgv.mypage.controller.MyPageController;

@Controller
@RequestMapping("/manager")
@SessionAttributes({ "loginUser" })
public class ManagerController {

	private Logger logger = LoggerFactory.getLogger(MyPageController.class);

	@Autowired
	private ManagerService service;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ManageStoreService services;

	// 관리자_메인페이지 이동
	@GetMapping("/main")
	public String moveMain(Model model) {

		// 관리자 메인 신규 회원 목록 조회
		List<User> getUser = null;
		getUser = service.getAllUser();

		// 관리자 메인 공지사항 목록 조회
		List<Notice> getNotice = null;
		getNotice = service.getAllNotice();

		// 관리자 메인 상영중인 영화
		Map<String, Object> getMovieList = null;
		getMovieList = movieService.mainMovieList();
		model.addAttribute("getUser", getUser);
		model.addAttribute("getNotice", getNotice);
		model.addAttribute("getMovieList", getMovieList);

		System.out.println("관리자_메인페이지 이동");
		return "manager/managerPage";
	}

	// ===================================================
	// ===================================================

	// 관리자_회원 리스트 이동
	@GetMapping("/member")
	public String moveMember(Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		Map<String, Object> getUserList = null;

		// 회원 리스트 얻어오기
		getUserList = service.selectAll(cp);

		model.addAttribute("getUserList", getUserList);

		System.out.println("관리자_회원 리스트 이동");
		return "manager/manager_member_list";
	}

	// ===================================================
	// ===================================================

	// 관리자 메인 일일 접속자 수 조회
	@ResponseBody
	@PostMapping("/getDailyEnter")
	public List<DailyEnter> getDailyEnter(@RequestParam("today") String today,
			@RequestParam("lastWeek") String lastWeek, WeeklyEnter we) {

		System.out.println(today + " today  ========================");
		System.out.println(lastWeek + " today  ========================");

		we.setToday(today);
		we.setLastWeek(lastWeek);

		List<DailyEnter> dailyEnter = null;
		dailyEnter = service.getWeeklyEnter(we);

		System.out.println(
				dailyEnter + " ==============================================================================");

		return dailyEnter;
	}

	// ===================================================
	// ===================================================

	// 회원 관리자 상태 업데이트
	@ResponseBody
	@PostMapping("/Manager_ST")
	public int changeMgSt(@RequestParam("MST") String mst, @RequestParam("userId") String userId, User user) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + mst);
		System.out.println("AJAX로 가지고 온 userId의 값은 : " + userId);

		user.setUserManagerSt(mst);
		user.setUserEmail(userId);

		int result = service.updateST(user);

		if (result > 0) {
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
	public int blockUser(@RequestParam("BST") String bst, @RequestParam("userId") String userId, User user) {

		user.setUserBlock(bst);
		user.setUserEmail(userId);

		int result = service.blockST(user);

		if (result > 0) {
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

	// 관리자_1:1 문의 목록 이동
	@GetMapping("/ask_list")
	public String moveAskList() {
		System.out.println("관리자_1:1 문의 목록 이동");
		return "manager/manager_ask_list";
	}

	// ===================================================
	// ===================================================

	// 영화 등록 페이지
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

	// 관리자_영화 등록
	@ResponseBody
	@PostMapping("/movie_add")
	public int MovieAdd(Movie inputMovie
	// , RedirectAttributes ra
	) {
		System.out.println("영화 등록 기능 수행");

		System.out.println("inputMovie: " + inputMovie);

		int result = service.MovieAdd(inputMovie);

		System.out.println("controller result:" + result);

		System.out.println("등록 ㄱㄱ");
		// if(result > 0) {
		// message = "영화 등록 성공";
		// path = "/manager/movie_add";
		// } else {
		// message = "영화 등록 실패";
		// path = "/manager/movie_add";
		// }

		// ra.addFlashAttribute("message", message);
		// return "redirect:" + path;
		return result;
	}

	// ===================================================
	// ===================================================

	// 관리자_영화 목록 이동
	@GetMapping("/movie_list")
	public String moveMovieList(Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		// 페이지네이션 10개씩 자르기
		Map<String, Object> getMovieList = null;
		logger.info("1. 페이지네이션 시작 cp들어간다잇");
		getMovieList = service.movieList(cp);

		model.addAttribute("getMovieList", getMovieList);
		logger.info("end: 마지막에 들어오는 getMovieList값::::" + getMovieList);

		System.out.println("관리자_영화 목록 이동");
		return "manager/manager_movie_list";
	}

	// ===================================================
	// ===================================================

	// 영화 상영 상태 업데이트
	@ResponseBody
	@PostMapping("/Movie_ST")
	public int changeMovieSt(@RequestParam("MST") String mst, @RequestParam("movieNo") int movieNo, Movie movie) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + mst);
		System.out.println("AJAX로 가지고 온 Movie의 값은 : " + movieNo);

		movie.setMovieSt(mst);
		movie.setMovieNo(movieNo);

		int result = service.updateMovieST(movie);

		if (result > 0) {
			System.out.println("영화 상영 상태 변경 완료");
			result = 1;

		} else {
			System.out.println("영화 상영 상태 변경 실패");
			result = 0;
		}
		return result;
	}

	// ===================================================
	// ===================================================

	// list에서 수정버튼 눌렀을 경우 등록페이지로 넘어가면서
	// movieNo에 따른 정보를 가져와서 보여줘야함
	@GetMapping("/movie_list/edit/{movieNo}")
	public String editMovie(Model model, Movie movie, @PathVariable("movieNo") int movieNo) {
		List<String> mgradelist = service.mgradeList();
		System.out.println("mgradelist 값 :::::" + mgradelist);

		model.addAttribute("mgradelist", mgradelist);
		// movie genre 값 얻어오기
		List<String> mgenrelist = service.mgenreList();
		System.out.println("mgenrelist 값 :::::" + mgenrelist);

		model.addAttribute("mgenrelist", mgenrelist);

		// 요기부터 수정페이지에 movieNo 보냄
		movie.setMovieNo(movieNo);

		Movie editMovie = service.getEditMovieList(movie);
		String unescapedContent = StringEscapeUtils.unescapeHtml4(editMovie.getMgNo());
		unescapedContent = unescapedContent.replaceAll("\\[|\\]", "").replaceAll("\"", "");
		editMovie.setMgNo(unescapedContent);

		String genreChange = StringEscapeUtils.unescapeHtml4(editMovie.getGenreName());
		genreChange = genreChange.replaceAll("\\[|\\]", "").replaceAll("\"", "");
		editMovie.setGenreName(genreChange);

		logger.info("editMovie ::::: " + editMovie);

		model.addAttribute("editMovie", editMovie);

		return "manager/manager_movie_edit";
	}

	// ===================================================
	// ===================================================

	// 영화 수정 등록
	@ResponseBody
	@PostMapping("/movie_list/edit/{movieNo}/movie_edit")
	public int MovieEdit(Movie updateMovie, @PathVariable("movieNo") int movieNo) {
		logger.info("영화 수정 기능 수행");

		logger.info("updateMovie" + updateMovie);

		int result = service.MovieEdit(updateMovie);

		logger.info("update result:::" + result);

		return result;
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
	public String moveCinemaList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> cinemaMap = null;
		cinemaMap = service.getCinemaMap(cp);
		model.addAttribute("cinemaMap", cinemaMap);

		System.out.println("관리자_극장 목록 이동");
		return "manager/manager_cinema_list";
	}

	// ===================================================
	// ===================================================

	// 관리자_극장 가격 목록 이동
	@GetMapping("/manager_cinemaPrice_list")
	public String moveCinemaPriceList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> cinemaPriceMap = null;
		cinemaPriceMap = service.getCinemaPriceMap(cp);
		model.addAttribute("cinemaMap", cinemaPriceMap);

		System.out.println("관리자_가격 목록 이동");
		return "manager/manager_cinemaPrice_list";
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

	// 관리자_극장 가격 수정 이동
	@GetMapping("/manager_cinemaPrice_list/edit/{priceNo}")
	public String moveCinemaPriceEdit(
			Model model, CinemaPrice price, @PathVariable("priceNo") int priceNo) {

		Map<String, Object> editPrice = null;

		price.setPriceNo(priceNo);

		editPrice = service.getEditPriceList(price);
		System.out.println("DAO에서 가지고 온 editEvent : " + editPrice);
		model.addAttribute("editPrice", editPrice);

		System.out.println("관리자_극장 가격 수정 이동");
		return "manager/manager_cinemaPrice_list_edit";
	}

	// ===================================================
	// ===================================================

	// 관리자_극장 가격 중복 조회
	@PostMapping("/manager_cinema_price/check")
	@ResponseBody
	public Boolean checkCinemaPrice(
			@RequestParam("checkScreen") String checkScreen, @RequestParam("checkWeek") String checkWeek,
			@RequestParam("checkTime") String checkTime, CinemaPrice cp) {

		cp.setScreenStyle(checkScreen);
		cp.setPriceDay(checkWeek);
		cp.setPriceTime(checkTime);

		Boolean result = service.checkPrice(cp);

		if (result) {
			System.out.println("이미 가격이 DB에 있음");
		} else {
			System.out.println("가격이 DB에 없음");
		}

		return result;
	}

	// ===================================================
	// ===================================================

	// 관리자_극장 가격 등록
	@PostMapping("/manager_cinema_price/add")
	@ResponseBody
	public int addCinemaPrice(
			@RequestParam("screenType") String screenType, @RequestParam("chooseDay") String chooseDay,
			@RequestParam("chooseTime") String chooseTime, @RequestParam("teen") String teen,
			@RequestParam("normal") String normal, @RequestParam("elder") String elder,
			@RequestParam("special") String special, @RequestParam("couple") String couple, CinemaPrice cp) {

		cp.setScreenStyle(screenType);
		cp.setPriceDay(chooseDay);
		cp.setPriceTime(chooseTime);
		cp.setPriceTeen(teen);
		cp.setPriceNormal(normal);
		cp.setPriceElder(elder);
		cp.setPriceSpecial(special);
		cp.setPriceCouple(couple);

		int result = service.addCinemaPrice(cp);

		if (result > 0) {
			System.out.println("가격을 DB에 추가 완료");
		} else {
			System.out.println("가격을 DB에 추가 실패");
		}

		return result;
	}

	// ===================================================
	// ===================================================

	// 관리자_극장 가격 수정
	@ResponseBody
	@PostMapping("/manager_cinemaPrice_list/edit/{priceNo}/edit")
	public int EditCinemaPrice(
			@RequestParam("screenType") String screenType, @RequestParam("chooseDay") String chooseDay,
			@RequestParam("chooseTime") String chooseTime, @RequestParam("teen") String teen,
			@RequestParam("normal") String normal, @RequestParam("elder") String elder,
			@RequestParam("special") String special, @RequestParam("couple") String couple,
			@RequestParam("priceNo") int priceNo, CinemaPrice cp) {

		cp.setScreenStyle(screenType);
		cp.setPriceDay(chooseDay);
		cp.setPriceTime(chooseTime);
		cp.setPriceTeen(teen);
		cp.setPriceNormal(normal);
		cp.setPriceElder(elder);
		cp.setPriceSpecial(special);
		cp.setPriceCouple(couple);
		cp.setPriceNo(priceNo);

		int result = service.EditCinemaPrice(cp);

		return result;
	}

	// ===================================================
	// ===================================================

	// 관리자_상영영화 목록 이동
	@GetMapping("/play_list")
	public String movePlayList(
			Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		Map<String, Object> getMovieList = null;
		getMovieList = movieService.managerMovieList(cp);

		model.addAttribute("getMovieList", getMovieList);

		System.out.println("관리자_상영시간 목록 이동");
		return "manager/manager_movie_play_list";
	}

	// ===================================================
	// ===================================================

	// 관리자_상영시간 등록 이동
	@GetMapping("/play_add")
	public String movePlayAdd(Model model) {

		Map<String, Object> playMap = null;
		playMap = service.getPlayMap();
		model.addAttribute("playMap", playMap);

		System.out.println("관리자_상영시간 등록 이동");
		return "manager/manager_movie_play_add";
	}

	// ===================================================
	// ===================================================

	// 관리자_이벤트 목록 이동
	@GetMapping("/event_list")
	public String moveEventList(Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> getEventList = null;

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
	public String editEvent(Model model, Event event, @PathVariable("eventNo") int eventNo) {

		Map<String, Object> editEvent = null;

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
	public int editEvent(@RequestParam("no") int no, @RequestParam("title") String title,
			@RequestParam("start") String start, @RequestParam("end") String end,
			@RequestParam("content") String content) {
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

	// 이벤트 상태 업데이트
	@ResponseBody
	@PostMapping("/event_ST")
	public int changeEventSt(@RequestParam("EST") String est, @RequestParam("eventNo") int eventNo, Event event) {
		System.out.println("AJAX로 가지고 온 ST의 값은 : " + est);
		System.out.println("AJAX로 가지고 온 userId의 값은 : " + eventNo);

		event.setEventStatus(est);
		event.setEventNo(eventNo);

		int result = service.updateEventST(event);

		if (result > 0) {
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

		// String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

		// 내부경로로 저장
		String webPath = "/resources/images/fileupload/";

		String fileRoot = request.getServletContext().getRealPath(webPath);

		String originalFileName = multipartFile.getOriginalFilename();
		// String extension =
		// originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = Util.fileRename(originalFileName);

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
	public String moveNoticeList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> getNoticeList = null;

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
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("userName") String userName)

	{
		Notice notice = new Notice();

		notice.setNoticeTitle(title);
		notice.setNoticeContent(content);
		notice.setNoticeUploader(userName);

		System.out.println("=============================================== notice : " + notice);

		int result = service.addNotice(notice);

		if (result > 0) {
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
	public String editNotice(Model model, Notice notice, @PathVariable("noticeNo") int noticeNo) {

		Map<String, Object> editNotice = null;

		notice.setNoticeNo(noticeNo);

		editNotice = service.getEditNoticeList(notice);
		model.addAttribute("editNotice", editNotice);

		return "manager/manager_notice_edit";

	}

	// ===================================================
	// ===================================================

	// 공지사항 수정(업데이트)
	@PostMapping("/notice_list/edit/{noticeNo}/edit_Notice")
	@ResponseBody
	public int editNotice(@RequestParam("no") int no, @RequestParam("title") String title,
			@RequestParam("userName") String userName, @RequestParam("content") String content) {
		Notice notice = new Notice();
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

	// 공지사항 상태 업데이트
	@ResponseBody
	@PostMapping("/notice_ST")
	public int changeNoticeSt(@RequestParam("NST") String nst, @RequestParam("noticeNo") int noticeNo, Notice notice) {

		notice.setNoticeStatus(nst);
		notice.setNoticeNo(noticeNo);

		int result = service.updateNoticeST(notice);

		if (result > 0) {
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

		// String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

		// 내부경로로 저장
		String webPath = "/resources/images/fileupload/";

		String fileRoot = request.getServletContext().getRealPath(webPath);

		String originalFileName = multipartFile.getOriginalFilename();
		// String extension =
		// originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = Util.fileRename(originalFileName);

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
	public String uploadNoticeEditImageFile(@RequestParam("file") MultipartFile multipartFile,
			HttpServletRequest request) {
		JsonObject jsonObject = new JsonObject();

		// String fileRoot = "C:\\Users\\cropr\\Desktop\\test"; // 외부경로로 저장을 희망할때.

		// 내부경로로 저장
		String webPath = "/resources/images/fileupload/";

		String fileRoot = request.getServletContext().getRealPath(webPath);

		String originalFileName = multipartFile.getOriginalFilename();
		// String extension =
		// originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = Util.fileRename(originalFileName);

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

	// 관리자_스토어 물품 목록
	@GetMapping("/store_list")
	public String moveStoreList(Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> storeMap = null;
		storeMap = service.getStoreMap(cp);
		model.addAttribute("storeMap", storeMap);

		System.out.println("관리자_스토어 물품 목록");
		return "manager/manager_store_list";
	}

	// ===================================================
	// ===================================================

	// 관리자 스토어 물품 수정
	@GetMapping("/store_list/edit/{storeNo}")
	public String editStore(@PathVariable("storeNo") int storeNo, Model model, Store store) {

		store.setStoreNo(storeNo);

		Store editStore = service.getEditStoreList(store);

		model.addAttribute("editStore", editStore);

		return "manager/manager_store_edit";
	}

	//// 스토어 수정 등록
	@ResponseBody
	@PostMapping("/store_list/edit/{storeNo}/store_edit")
	public int StoreEdit(Store updateStore, @PathVariable("storeNo") int storeNo) {
		logger.info("스토어 수정 기능 수행");

		logger.info("updateStore" + updateStore);

		int result = service.StoreEdit(updateStore);

		logger.info("update result:::" + result);

		return result;
	}

	// 스토어 수정 이름 중복 검사
	@ResponseBody
	@GetMapping("/store_list/edit/{storeNo}/store_edit/NameDupChecks")
	public int NameDupChecks(String storeName) {
		System.out.println(storeName);
		int result = services.NameDupCheck(storeName);

		System.out.println(result);
		return result;

	}

	// 스토어 수정 이미지 업로드
	@PostMapping("/store_list/edit/{storeNo}/store_edit/uploadImageFile")
	@ResponseBody
	public String storeUpdateImageFile(@RequestParam("file") MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		JsonArray jsonArray = new JsonArray();

		String webPath = "/resources/images/storeimg/";

		String fileRoot = request.getSession().getServletContext().getRealPath(webPath);

		for (MultipartFile multipartFile : multipartFiles) {
			JsonObject jsonObject = new JsonObject();

			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = Util.fileRename(originalFileName);

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				jsonObject.addProperty("", request.getContextPath() + webPath + savedFileName);

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}

			jsonArray.add(jsonObject);
		}

		String jsonResult = jsonArray.toString();
		System.out.println("이미지: " + jsonResult);
		return jsonResult;
	}

	// 관리자_스토어 물품 등록
	@GetMapping("/store_add")
	public String moveStoreAdd() {
		System.out.println("관리자_스토어 물품 등록");
		return "manager/manager_store_add";
	}

	// ===================================================
	// ===================================================

	// 테스트 페이지 이동
	@GetMapping("/manager_testPage")
	public String moveTest() {
		System.out.println("테스트 페이지 이동");
		return "manager/manager_testPage";
	}

	// ===================================================
	// ===================================================

	// 영화 등록 이미지 업로드
	@PostMapping("/movie_add/uploadImageFile")
	@ResponseBody
	public String movieUploadImageFile(@RequestParam("file") MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		JsonArray jsonArray = new JsonArray();

		String webPath = "/resources/images/testFolder/";
		String fileRoot = request.getServletContext().getRealPath(webPath);

		for (MultipartFile multipartFile : multipartFiles) {
			JsonObject jsonObject = new JsonObject();

			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = Util.fileRename(originalFileName);

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				jsonObject.addProperty("", request.getContextPath() + webPath + savedFileName);

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}

			jsonArray.add(jsonObject);
		}

		String jsonResult = jsonArray.toString();
		System.out.println("이미지: " + jsonResult);
		return jsonResult;
	}

	// ===================================================
	// ===================================================

	// 영화 수정 이미지 업로드
	@PostMapping("/movie_list/edit/{movieNo}/movie_edit/uploadImageFile")
	@ResponseBody
	public String movieUpdateImageFile(@RequestParam("file") MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		JsonArray jsonArray = new JsonArray();

		String webPath = "/resources/images/testFolder/";
		String fileRoot = request.getServletContext().getRealPath(webPath);

		for (MultipartFile multipartFile : multipartFiles) {
			JsonObject jsonObject = new JsonObject();

			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = Util.fileRename(originalFileName);

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				jsonObject.addProperty("", request.getContextPath() + webPath + savedFileName);

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}

			jsonArray.add(jsonObject);
		}

		String jsonResult = jsonArray.toString();
		System.out.println("이미지: " + jsonResult);
		return jsonResult;
	}

	// ===================================================
	// ===================================================

	// 관리자_분실물 목록 이동
	@GetMapping("/lost_list")
	public String moveLostList() {
		System.out.println("관리자_분실물 목록 이동");
		return "manager/manager_lost_list";
	}

	// ===================================================
	// ===================================================

	// 관리자_배너 목록 이동
	@GetMapping("/banner_list")
	public String moveBannerList(
			Model model, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> getBannerList = null;
		getBannerList = service.getBannerList(cp);

		model.addAttribute("getBannerList", getBannerList);

		System.out.println("관리자_배너 목록 이동");

		return "manager/manager_banner_list";
	}
	// ===================================================
	// ===================================================

	// 관리자_배너 등록 이동
	@GetMapping("/banner_add")
	public String moveBannerAdd() {

		System.out.println("관리자_배너등록 등록 이동");

		return "manager/manager_banner_add";
	}
	// ===================================================
	// ===================================================

	// 관리자_배너 등록
	@PostMapping("/banner_add/insert")
	@ResponseBody
	public int bannerAdd(@RequestParam("title") String title, @RequestParam("url") String url,
			@RequestParam("movieImg1") String img, banner banner) {
		banner.setBannerTitle(title);
		banner.setBannerUrl(url);
		banner.setBannerImg(img);

		int result = service.addBanner(banner);

		return result;
	}

	// ===================================================
	// ===================================================

	// 관리자_배너 수정 이동
	@GetMapping("/banner_list/edit/{bannerNo}")
	public String moveBannerEdit(
			banner banner, Model model, @PathVariable("bannerNo") int bannerNo) {

		Map<String, Object> editBannerList = null;

		banner.setBannerNo(bannerNo);

		editBannerList = service.getEditBannerList(banner);

		model.addAttribute("editBannerList", editBannerList);

		System.out.println("관리자_배너 수정 이동");

		return "manager/manager_banner_edit";
	}

	// ===================================================
	// ===================================================

	// 관리자_배너 수정
	@PostMapping("/banner_list/edit/{bannerNo}/edit")
	@ResponseBody
	public int editBanner(
			banner banner, @RequestParam("title") String title, @RequestParam("url") String url,
			@RequestParam("movieImg1") String img, @RequestParam("bannerNo") int bannerNo) {

		banner.setBannerTitle(title);
		banner.setBannerUrl(url);
		banner.setBannerImg(img);
		banner.setBannerNo(bannerNo);

		System.out.println("=======================들어온 banner는 : " + banner);

		// int result = 1;

		int result = service.editBanner(banner);

		return result;

	}

	// ===================================================
	// ===================================================

	// 관리자_배너 상태 업데이트
	@ResponseBody
	@PostMapping("/banner_ST")
	public int changeBannerSt(
			@RequestParam("BST") String bst, @RequestParam("bannerNo") int bannerNo, banner banner) {

		banner.setBannerSt(bst);
		banner.setBannerNo(bannerNo);

		int result = service.updateBannerST(banner);

		if (result > 0) {
			System.out.println("배너 상태 변경 완료");
			result = 1;

		} else {
			System.out.println("배너 상태 변경 실패");
			result = 0;
		}
		return result;
	}

	// ===================================================
	// ===================================================

	// 배너 등록 이미지 업로드
	@PostMapping("/banner_add/bannerUploadImage")
	@ResponseBody
	public String bannerUploadImageFile(@RequestParam("file") MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		JsonArray jsonArray = new JsonArray();

		String webPath = "/resources/images/banner_img/";
		String fileRoot = request.getServletContext().getRealPath(webPath);

		for (MultipartFile multipartFile : multipartFiles) {
			JsonObject jsonObject = new JsonObject();

			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = Util.fileRename(originalFileName);

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				jsonObject.addProperty("", request.getContextPath() + webPath + savedFileName);

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}

			jsonArray.add(jsonObject);
		}

		String jsonResult = jsonArray.toString();
		System.out.println("이미지: " + jsonResult);
		return jsonResult;
	}

	// ===================================================
	// ===================================================
	// 배너 수정 이미지 업로드
	@PostMapping("/banner_list/edit/{bannerNo}/uploadImageFile")
	@ResponseBody
	public String bannerEditImageFile(@RequestParam("file") MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		JsonArray jsonArray = new JsonArray();

		String webPath = "/resources/images/banner_img/";
		String fileRoot = request.getServletContext().getRealPath(webPath);

		for (MultipartFile multipartFile : multipartFiles) {
			JsonObject jsonObject = new JsonObject();

			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = Util.fileRename(originalFileName);

			File targetFile = new File(fileRoot + savedFileName);
			try {
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				jsonObject.addProperty("", request.getContextPath() + webPath + savedFileName);

			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				jsonObject.addProperty("responseCode", "error");
				e.printStackTrace();
			}

			jsonArray.add(jsonObject);
		}

		String jsonResult = jsonArray.toString();
		System.out.println("이미지: " + jsonResult);
		return jsonResult;
	}

	// ===================================================
	// ===================================================

	// 관리자_혜택 목록 이동
	@GetMapping("/benefits_list")
	public String moveBenefitsList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> getBenefitsList = null;
		getBenefitsList = service.getBenefitsList(cp);
		model.addAttribute("getBenefitsList", getBenefitsList);

		System.out.println("관리자_혜택 목록 이동");

		return "manager/manager_benefits_list";
	}

	// ===================================================
	// ===================================================

	// 관리자_혜택 등록 이동
	@GetMapping("/benefits_add")
	public String moveBenefitsAdd() {
		System.out.println("관리자_혜택 등록 이동");
		return "manager/manager_benefits_add";
	}

	// ===================================================
	// ===================================================

	// 관리자_혜택 등록 이동
	@GetMapping("/event_list/edit/{eventNotest}")
	public String moveBenefitsEdit(Model model,
			CinemaPrice price,
			@PathVariable("priceNo") int priceNo) {

		Map<String, Object> editPrice = null;

		price.setPriceNo(priceNo);

		editPrice = service.getEditPriceList(price);
		System.out.println("DAO에서 가지고 온 editEvent : " + editPrice);
		model.addAttribute("editPrice", editPrice);

		System.out.println("관리자_극장 가격 수정 이동");
		return "manager/manager_benfits_list_edit";
	}

}
