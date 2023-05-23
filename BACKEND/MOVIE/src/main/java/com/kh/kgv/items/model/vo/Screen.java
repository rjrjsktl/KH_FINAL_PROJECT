package com.kh.kgv.items.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class Screen {
	// 스크린 테이블
	private int screenNo;
	private String screenName;
	private String screenStyle;
	private String screenSeat;
}
