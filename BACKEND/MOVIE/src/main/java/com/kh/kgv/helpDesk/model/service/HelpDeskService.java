package com.kh.kgv.helpDesk.model.service;

import java.util.Map;

import com.kh.kgv.management.model.vo.Notice;

public interface HelpDeskService {

	Notice selectNoticeDetail(int noticeNo);

	Notice getPreviousNotice(int noticeNo);

	Notice getNextNotice(int noticeNo);

	Map<String, Object> getMtmList(int cp, int userNo);

}
