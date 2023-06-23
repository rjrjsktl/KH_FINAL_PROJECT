package com.kh.kgv.helpDesk.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.customer.model.vo.User;
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


	//공지사항 세부 접속
	@Override
	public Notice selectNoticeDetail(int noticeNo) {
		return dao.selectNoticeDetail(noticeNo);
	}

	//공지사항 이전번호 조회
	@Override
	public Notice getPreviousNotice(int noticeNo) {
		int prevNoticeNo = noticeNo - 1;

		// 이전 게시물의 정보를 데이터베이스에서 조회
		Notice prevNotice = dao.findPrevNoticeNo(prevNoticeNo);

		return prevNotice;
	}

	// 공지사항 다음번호 조회
	@Override
	public Notice getNextNotice(int noticeNo) {
		int nextNoticeNo = noticeNo + 1;

		// 다음 게시물의 정보를 데이터베이스에서 조회
		Notice nextNotice = dao.findNextNoticeNo(nextNoticeNo);

		return nextNotice;
	}

	// 1:1문의 리스트 조회
	@Override
	public Map<String, Object> getMtmList(int cp, int userNo, String userManagerSt) {

		int userManagerStAsInt = 0;
		if(userManagerSt != null) {
			if(userManagerSt.equals("Y")) {
				userManagerStAsInt = 1;
			}else if (userManagerSt.equals("null")) {
				userManagerStAsInt = 0;
			}
		}

		int mtmlistCount = dao.getMtmListCount(userNo, userManagerStAsInt);
		System.out.println("MTM 리스트 카운트 조회-[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[["+mtmlistCount);
		System.out.println("1:1문의 리스트 관리자권한 조회-[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[["+userManagerStAsInt);
		MtmPagenation pagination = new MtmPagenation(cp, mtmlistCount);
		List<Mtm> mtmLists = dao.getMtmList(pagination, userNo, userManagerStAsInt);

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
	public Map<String, Object> getLostList(int cp, int userNo, String userManagerSt) {

		int userManagerStAsInt = 0;
		if(userManagerSt != null) {
			if(userManagerSt.equals("Y")) {
				userManagerStAsInt = 1;
			}else if (userManagerSt.equals("null")) {
				userManagerStAsInt = 0;
			}
		}

		int lostlistCount = dao.getLostListCount(userNo, userManagerStAsInt);

		LostPagenation pagination = new LostPagenation(cp, lostlistCount);

		System.out.println(lostlistCount+"====================================================================");

		List<Mtm> lostLists = dao.lostLists(pagination, userNo, userManagerStAsInt);
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
	public int selectMtmNo(Mtm mtm) {
		return  dao.selectMtmNo(mtm);
	}

	@Override
	public int selectLostNo(LostPackage lost) {
		return dao.selectLostNo(lost);
	}

	@Override
	public int deleteBoard(int mtmNo) {
		return dao.deleteBoard(mtmNo);
	}

	@Override
	public int replyDelete(int mtmNo) {
		return dao.replyDelete(mtmNo);
	}

	@Override
	public int replyWrite(int mtmNo, String content,  String managerNick) {
		return  dao.replyWrite(mtmNo, content, managerNick);
	}

	@Override
	public int getuserMtmListCount(int userNo, String userManagerSt) {
		int userManagerStAsInt = 0;
		if(userManagerSt != null) {
			if(userManagerSt.equals("Y")) {
				userManagerStAsInt = 1;
			}else if (userManagerSt.equals("null")) {
				userManagerStAsInt = 0;
			}
		}
		return dao.getMtmListCount(userNo, userManagerStAsInt);
	}

	@Override
	public int getLostListCount(int userNo, String userManagerSt) {
		int userManagerStAsInt = 0;
		if(userManagerSt != null) {
			if(userManagerSt.equals("Y")) {
				userManagerStAsInt = 1;
			}else if (userManagerSt.equals("null")) {
				userManagerStAsInt = 0;
			}
		}
		return dao.getLostListCount(userNo, userManagerStAsInt);

	}

	@Override
	public int deleteLost(int mtmNo) {
		return dao.deleteLost(mtmNo);
	}

	@Override
	public int replyLostDelete(int lostNo) {
		return dao.replyLostDelete(lostNo);
	}

	@Override
	public int replyLostWrite(int lostNo, String content, String managerNick) {
		return  dao.replyLostWrite(lostNo, content, managerNick);
	}



	@Override
	public int selectmtmPw(int mtmNo) {
		return dao.selectmtmPw(mtmNo);
	}

	@Override
	public int selectUserNo(int mtmNo) {
		return dao.selectUserNo(mtmNo);
	}










}
