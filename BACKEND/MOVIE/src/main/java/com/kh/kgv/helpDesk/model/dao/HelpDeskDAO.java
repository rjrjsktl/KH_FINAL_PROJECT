package com.kh.kgv.helpDesk.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.management.model.vo.Notice;

@Repository
public class HelpDeskDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Notice selectNoticeDetail(int noticeNo) {
		return sqlSession.selectOne("managerMapper.noticeDetail", noticeNo);

	}

}
