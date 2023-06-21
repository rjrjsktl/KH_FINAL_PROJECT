package com.kh.kgv.mypage.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.Review;
import com.kh.kgv.mypage.controller.MyPageController;

@Repository
public class MyPageDAO {

	private Logger logger = LoggerFactory.getLogger(MyPageController.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 현재 로그인한 회원의 암호화된 비밀번호 조회 DAO
	 * @param userNo
	 * @return encPw
	 */
	public String selectEncPw(int userNo) {
		return sqlSession.selectOne("myPageMapper.selectEncPw", userNo);
	}
	
	/** 비밀번호 변경 DAO
	 * @param paramMap
	 * @return result
	 */
	public int changePw(Map<String, Object> paramMap) {
		return sqlSession.update("myPageMapper.changePw", paramMap);
	}

	/** 회원 탈퇴 DAO
	 * @param userNo
	 * @return result
	 */
	public int secession(int userNo) {
		return sqlSession.update("myPageMapper.secession", userNo);
	}

	/** 회원 정보 수정 DAO
	 * @param paramMap
	 * @return
	 */
	public int updateInfo(Map<String, Object> paramMap) {
		logger.info("뜬다 updateInfo.dao 페이지 들어왔다");
		return sqlSession.update("myPageMapper.updateInfo", paramMap);
	}

	/** 리뷰 불러오기 DAO
	 * @param userNo
	 * @return
	 */
	public List<Review> myReviewList(int userNo) {
		logger.info("review::dao 실행 ㄱㄱㄱ");
		return sqlSession.selectList("myPageMapper.myReviewList", userNo);
	}

//	/** 리뷰 5개씩 불러오기 DAO
//	 * @param userNo
//	 * @param startMovie
//	 * @param endMovie
//	 * @return
//	 */
//	public List<Review> getReviewListInRange(Map<String, Object> paramMap) {
//		logger.info("review::dao 실행 ㄱㄱㄱ");
//		return sqlSession.selectList("myPageMapper.getReviewListInRange", paramMap);
//	}

}
