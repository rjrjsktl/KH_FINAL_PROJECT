package com.kh.kgv.helpDesk.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.helpDesk.model.dao.HelpDeskDAO;
import com.kh.kgv.helpDesk.model.vo.LostPagenation;
import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.helpDesk.model.vo.MtmPagenation;
import com.kh.kgv.management.model.dao.ManagerDAO;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.Pagination;



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

	@Override
	public Map<String, Object> getMtmList(int cp, int userNo) {
		

		int mtmlistCount = dao.getMtmListCount();

		MtmPagenation pagination = new MtmPagenation(cp, mtmlistCount);

		List<Mtm> mtmLists = dao.getMtmList(pagination, userNo);

		Map<String, Object> getMtmList = new HashMap<String, Object>();
		getMtmList.put("pagination", pagination);
		getMtmList.put("mtmLists", mtmLists);

		return getMtmList;
		
	}

	@Override
	public Mtm selectmTmDetail(int mtmNo) {
		return dao.selectmTmDetail(mtmNo);
	}

	@Override
	public Map<String, Object> getLostList(int cp, int userNo) {
		
		int lostlistCount = dao.getLostListCount();

		LostPagenation pagination = new LostPagenation(cp, lostlistCount);

		List<Mtm> lostLists = dao.lostLists(pagination, userNo);

		Map<String, Object> getMtmList = new HashMap<String, Object>();
		getMtmList.put("pagination", pagination);
		getMtmList.put("lostLists", lostLists);

		return getMtmList;
	}

	@Override
	public LostPackage selectLostDetail(int lostNo) {
		System.out.println(lostNo+"서비스");
		return dao.selectLostDetail(lostNo);
	}



	@Override
	public int addmTm(Mtm mtm) {
		return dao.addmTm(mtm);

	}

	@Override
	public int addLost(LostPackage lost) {
		return dao.addLost(lost);
	}

	@Override
	public int getMtmListCount(int userNo) {
		return dao.getMtmListCount(userNo);
	}

	@Override
	public int getLostListCount(int userNo) {
		return dao.getLostListCount(userNo);

	}

	@Override
	public int selectMtmNo(Mtm mtm) {
		return  dao.selectMtmNo(mtm);
	}

	@Override
	public int selectLostNo(LostPackage lost) {
		return dao.selectLostNo(lost);
	}

}
