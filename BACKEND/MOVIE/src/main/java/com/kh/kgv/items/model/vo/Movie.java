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
	private String movieImg;
	private int moviePlayed;
	private int movieWatched;
	private String movieRegdate;
	private String movieUpload;
	private String movieFixdate;
	private String movieChanger;
	private String genreCode;
}
