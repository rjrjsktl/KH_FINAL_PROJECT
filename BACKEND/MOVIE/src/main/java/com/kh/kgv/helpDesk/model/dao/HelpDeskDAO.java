package com.kh.kgv.helpDesk.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.helpDesk.model.vo.Mtm;
import com.kh.kgv.management.model.vo.Notice;
import com.kh.kgv.management.model.vo.Pagination;

@Repository
public class HelpDeskDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Notice selectNoticeDetail(int noticeNo) {
		return sqlSession.selectOne("managerMapper.noticeDetail", noticeNo);
	}


	public Notice findPrevNoticeNo(int prevNoticeNo) {
		return sqlSession.selectOne("managerMapper.noticePrevNo", prevNoticeNo);
	}


	public Notice findNextNoticeNo(int nextNoticeNo) {
		return sqlSession.selectOne("managerMapper.noticeNextNo", nextNoticeNo);
	}


	public List<Mtm> getMtmList(int userNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		return sqlSession.selectList("mtmMapper.userMtmList", userNo , rowBounds);
	}






}
