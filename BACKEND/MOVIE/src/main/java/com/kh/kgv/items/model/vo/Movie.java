package com.kh.kgv.items.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
	// 영화 테이블
	private int movieNo;
	private String movieRuntime;
	private String  movieTitle;
	private String movieNation;
	private String movieOpen;
	private String mgNo;
	private String movieContent;
	private String movieDirector; // 감독
	private String movieCast;	// 출연진
	private int moviePlayed;
	private int movieWatched;
	private String movieRegdate;
	private String movieUploader;
	private String genreCode;
	private String movieImg1;
	private String movieImg2;
	private String movieImg3;
	private String movieImg4;
	private String movieImg5;
	private String movieImg6;
}
