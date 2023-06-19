package com.kh.kgv.items.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
}
