package com.kh.kgv.helpDesk.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.helpDesk.model.vo.LostPagenation;
import com.kh.kgv.helpDesk.model.vo.LostPackage;
import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.helpDesk.model.vo.MtmPagenation;
import com.kh.kgv.management.model.vo.Notice;

@Repository
public class HelpDeskDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//mtmlistCount
	public int getMtmListCount() {
		return sqlSession.selectOne("mtmMapper.getMtmCount");
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
		return sqlSession.selectOne("lostMapper.lostdetail");

	}



	
	







}
