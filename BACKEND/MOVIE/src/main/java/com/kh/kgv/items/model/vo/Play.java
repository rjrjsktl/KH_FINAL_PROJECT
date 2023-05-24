package com.kh.kgv.items.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class Play {
	// 현재 상영중인 영화 테이블
	private int playNo;
	private int movieNo;
	private int screenNo;
	private String playStart;
	private String playEnd;
	private String playRegDate;
	private String playUploader;
	private String playFixDate;
	private String playChanger;
}
