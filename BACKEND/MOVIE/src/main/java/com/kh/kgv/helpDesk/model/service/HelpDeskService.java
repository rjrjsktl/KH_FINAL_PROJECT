package com.kh.kgv.helpDesk.model.service;

import java.util.Map;

import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.management.model.vo.Notice;

public interface HelpDeskService {

	Notice selectNoticeDetail(int noticeNo);

	Notice getPreviousNotice(int noticeNo);

	Notice getNextNotice(int noticeNo);

	Map<String, Object> getMtmList(int cp, int userNo);

	Mtm selectmTmDetail(int mtmNo);

	Map<String, Object> getLostList(int cp, int userNo);

	LostPackage selectLostDetail(int lostNo);


	int addmTm(Mtm mtm);

	int addLost(LostPackage lost);


}
