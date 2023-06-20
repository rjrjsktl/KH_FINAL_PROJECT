package com.kh.kgv.helpDesk.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.helpDesk.model.vo.LostPagenation;
import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.helpDesk.model.vo.MtmPagenation;
import com.kh.kgv.login.controller.LoginController;
import com.kh.kgv.management.model.vo.Notice;

@Repository
public class HelpDeskDAO {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);


	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//mtmlistCount
	
	public int getMtmListCount() {
		return sqlSession.selectOne("mtmMapper.getMtmCount");
	}
	
	public int getMtmListCount(int userNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userNo", userNo);
		User users = new User();
		params.put("managerSt", users.getUserManagerSt());
		System.out.println("현재 접속중인 유저 넘버는 =====================%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+userNo);
		return sqlSession.selectOne("mtmMapper.getUserMtmCount", params);
	}
	

	public Notice selectNoticeDetail(int noticeNo) {
		return sqlSession.selectOne("managerMapper.noticeDetail", noticeNo);
	}


	public Notice findPrevNoticeNo(int prevNoticeNo) {
		return sqlSession.selectOne("managerMapper.noticePrevNo", prevNoticeNo);
	}


	public Notice findNextNoticeNo(int nextNoticeNo) {
		return sqlSession.selectOne("managerMapper.noticeNextNo", nextNoticeNo);
	}


	public List<Mtm> getMtmList(MtmPagenation pagination, int userNo) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
	    Map<String, Object> params = new HashMap<>();
	    params.put("userNo", userNo);
	    
		System.out.println("현재 접속중인 유저 넘버는 ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆"+userNo);
		
		
		return sqlSession.selectList("mtmMapper.userMtmList", params , rowBounds);
	}


	public Mtm selectmTmDetail(int mtmNo) {
		return sqlSession.selectOne("mtmMapper.mtmDetail", mtmNo);
	}

	

	public int getLostListCount() {
		return sqlSession.selectOne("lostMapper.getLostCount");
	}
	

	public List<Mtm> lostLists(LostPagenation pagination, int userNo) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
	    Map<String, Object> params = new HashMap<>();
	    params.put("userNo", userNo);
		
		return sqlSession.selectList("lostMapper.userLostList", params , rowBounds);
	}


	public LostPackage selectLostDetail(int lostNo) {
		System.out.println(lostNo+"DAO");
		return sqlSession.selectOne("lostMapper.lostdetail",lostNo);

	}


	public int addmTm(Mtm mtm) {
		
		return sqlSession.insert("mtmMapper.addmTm", mtm);
		
	}

	public int addLost(LostPackage lost) {
		return sqlSession.insert("lostMapper.addLost", lost);
	}

	public int getLostListCount(int userNo) {
		return sqlSession.selectOne("lostMapper.getUserLostCount", userNo);
	}

	public int selectMtmNo(Mtm mtm) {
		return sqlSession.selectOne("mtmMapper.selectMtmNo", mtm);
	}

	public int selectLostNo(LostPackage lost) {
		return sqlSession.selectOne("lostMapper.selectLostNo", lost);
	}

	public int deleteBoard(int mtmNo) {
		return sqlSession.update("mtmMapper.deleteBoard", mtmNo);
	}







	
	







}
