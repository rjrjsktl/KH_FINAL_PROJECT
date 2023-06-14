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

}
