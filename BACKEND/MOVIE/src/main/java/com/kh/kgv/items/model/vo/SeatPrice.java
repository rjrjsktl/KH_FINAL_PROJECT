package com.kh.kgv.items.model.vo;

import com.kh.kgv.management.model.vo.Freq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class SeatPrice {
	//  좌석 가격 테이블
	private int spNo;
	private String spTitle;
	private int spRate;
}
