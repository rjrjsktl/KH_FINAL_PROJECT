package com.kh.kgv.management.model.vo;

import com.kh.kgv.customer.model.vo.Sns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class Event {
	// 이벤트 테이블
	private int eventNo;
	private int userNo;
	private int bookNo;
	private String eventTitle;
	private String eventContent;
	private String eventStart;
	private String eventEnd;
	private String eventStatus;
}
