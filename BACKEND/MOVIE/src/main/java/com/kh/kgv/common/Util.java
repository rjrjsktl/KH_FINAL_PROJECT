package com.kh.kgv.common;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.kgv.items.model.vo.Movie;
import com.kh.kgv.management.model.vo.Event;
import com.kh.kgv.management.model.vo.Notice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@SuppressWarnings("unused")
public class Util {
	// 파일명 변경 메소드
	public static String fileRename(String originFileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int) (Math.random() * 1000000); // 7자리 랜덤 숫자 생성
//		int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = String.format("%07d", ranNum);
//		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

//		return date + str + ext;
		return  str+ ext ;
	}
	
	   // 개행문자 처리 
	   public static String newLineHandling(String content) {
	      return content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	   }
	   
	   // 개행문자 해제
	   public static String newLineClear(String content) {
	      return content.replaceAll("<br>", "\n");
	   }
	   
	   // DB에 배열을 넣었을 경우 ["값"]이런형식으로 오는데 값만 불러오게하는 Util
	   // 영화 리스트 페이지에 적용되는값 다른 것들도 이런 형식으로 사용하면될듯
	   // 밑에 removeQyites 개행 있으니 필요하신분은 Util.removeQuotes(movie1.getMgNo()));
	   // 이런식으로 넣어서 쓰세요 밑에 주석은 넣는 참고 자료니 참고 부탁
	   // 아니면 ManagerController에 moveMovieList 메소드 보시면 이해 가실겁니다.
//	   public static List<Movie> removeQuotesFromList(List<Movie> movielist) {
//		    List<Movie> cleanedList = new ArrayList<>();
//		    for (Movie movie : movielist) {
//		    	String cleanedMgNo = movie.getMgNo().replaceAll("[\"\\[\\]\\\\]", "").replace("&quot;", "");
//
//		        String cleanedGenre = movie.getGenreCode().replaceAll("[\"\\[\\]\\\\]", "").replace("&quot;", "");
//		        // genreCode에 쉼표(,) 추가
//		        cleanedGenre = cleanedGenre.replaceAll(",", ", ");
//		    	// 다른 속성이 있다면 해당 속성도 처리해주세요.
//		        
//		        Movie cleanedMovie = new Movie();
//		        cleanedMovie.setMgNo(cleanedMgNo);
//		        cleanedMovie.setGenreCode(cleanedGenre);
//		        // 다른 속성 추가
//		        cleanedMovie.setMovieRuntime(movie.getMovieRuntime());
//		        cleanedMovie.setMovieTitle(movie.getMovieTitle());
//		        cleanedMovie.setMovieNation(movie.getMovieNation());
//		        cleanedMovie.setMovieOpen(movie.getMovieOpen());
//		        cleanedMovie.setMovieContent(movie.getMovieContent());
//		        cleanedMovie.setMovieImg(movie.getMovieImg());
//		        cleanedMovie.setMovieUploader(movie.getMovieUploader());
//		        cleanedMovie.setMovieDirector(movie.getMovieDirector());
//		        cleanedMovie.setMovieCast(movie.getMovieCast());
//		        
//		        cleanedList.add(cleanedMovie);
//		    }
//		    return cleanedList;
//		}
	   public static String removeQuotes(String input) {
		    return input.replaceAll("[\"\\[\\]\\\\]", "").replaceAll("&quot;", "").replaceAll(",", ", ");
		}
}

//@PostMapping("/notice_list/edit/{noticeNo}/edit_Notice")
//@ResponseBody
//public int editNotice(
//		@RequestParam("no") int  no
//		, @RequestParam("title") String title
//		, @RequestParam("userName") String userName
//		, @RequestParam("content") String content
//		) {
//	Notice  notice = new Notice();
//	notice.setNoticeNo(no);
//	notice.setNoticeTitle(title);
//	notice.setNoticeUploader(userName);
//	notice.setNoticeContent(content);
//	
//	System.out.println("이벤트 수정에서 가지고 온 값들 =================================" + notice);
//
//	int result = service.editNotice(notice);
//
//	return result;
//}
//@GetMapping("/event_list/edit/{eventNo}")
//public String editEvent(
//        Model model,
//        Event event,
//        @PathVariable("eventNo") int eventNo
//		) {
//	
//	Map<String, Object>editEvent = null;
//	
//	event.setEventNo(eventNo);
//	
//	editEvent = service.getEditEventList(event);
//	System.out.println("DAO에서 가지고 온 editEvent : " + editEvent);
//	model.addAttribute("editEvent", editEvent);
//	
//	return "manager/manager_event_edit";
//	
//}








