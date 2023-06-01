package com.kh.kgv.customer.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data를 쓰면, @Getter @Setter @RequiredArgsConstructor @ToString @EqulasAndHashCode를 한번에 설정한다.
@NoArgsConstructor
@AllArgsConstructor

public class User {

	// 회원 테이블
	private int userNo;
	private String userEmail;
	private String userPw;
	private String userName;
	private String userNick;
	private int userTel;
	private String userAddr;
	private String userBirth;
	private String userGender;
	private String userRegDate;
	private String UserSt;
	private String userImg;
	private int userPoint;
	private String userSns;
	private String userChage;
	private String userDelete;
}