package com.kh.kgv.helpDesk.model.service;

import java.util.Map;

import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.management.model.vo.Notice;

public interface HelpDeskService {

	Notice selectNoticeDetail(int noticeNo);
	Notice getPreviousNotice(int noticeNo);
	Notice getNextNotice(int noticeNo);
	
	int selectMtmNo(Mtm mtm);
	Map<String, Object> getMtmList(int cp, int userNo, String userManagerSt);
	Mtm selectmTmDetail(int mtmNo);
	int addmTm(Mtm mtm);
	int getuserMtmListCount(int userNo, String userManagerSt);
	int deleteBoard(int mtmNo);
	int replyDelete(int mtmNo);
	int replyWrite(int mtmNo, String content, String managerNick);

	int selectLostNo(LostPackage lost);
	Map<String, Object> getLostList(int cp, int userNo, String userManagerSt);
	LostPackage selectLostDetail(int lostNo);
	int addLost(LostPackage lost);
	int getLostListCount(int userNo, String userManagerSt);
	int deleteLost(int mtmNo);
	int replyLostDelete(int lostNo);
	int replyLostWrite(int lostNo, String content, String managerNick);
	
	// 게시물 비밀번호 관련
	int selectmtmPw(int mtmNo);
	int selectUserNo(int mtmNo);
	





}
