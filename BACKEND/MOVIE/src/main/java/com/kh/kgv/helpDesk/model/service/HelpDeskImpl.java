package com.kh.kgv.helpDesk.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.helpDesk.model.dao.HelpDeskDAO;
import com.kh.kgv.management.model.vo.Notice;



@Service
public class HelpDeskImpl implements HelpDeskService {

	@Autowired
	private HelpDeskDAO dao;
	
	@Override
	public Notice selectNoticeDetail(int noticeNo) {
		return dao.selectNoticeDetail(noticeNo);
		
	}

	@Override
	public Notice getPreviousNotice(int noticeNo) {
		  int prevNoticeNo = noticeNo - 1;

		    // 이전 게시물의 정보를 데이터베이스에서 조회
		    Notice prevNotice = dao.findPrevNoticeNo(prevNoticeNo);

		    return prevNotice;
	}

	@Override
	public Notice getNextNotice(int noticeNo) {
	    int nextNoticeNo = noticeNo + 1;

	    // 다음 게시물의 정보를 데이터베이스에서 조회
	    Notice nextNotice = dao.findNextNoticeNo(nextNoticeNo);

	    return nextNotice;
	}

}
