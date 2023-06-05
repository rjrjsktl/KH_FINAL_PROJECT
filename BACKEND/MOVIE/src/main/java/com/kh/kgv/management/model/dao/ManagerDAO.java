package com.kh.kgv.management.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.kgv.customer.model.vo.User;
import com.kh.kgv.management.model.vo.Pagination;

@Repository
public class ManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/** 회원 수 조회
	 * @return
	 */
	public int getListCount() {
		return sqlSession.selectOne("managerMapper.getListCount");
	}

	/** 회원 리스트 조회
	 * @return
	 */
	public List<User> selectAll(Pagination pagination) {
		// RowBounds 객체 사용.
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		System.out.println(" ============================================== offset + " + offset);
		
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.selectAll", null, rowBounds);
				
	}

	public int updateST(User user) {
		
		return sqlSession.update("managerMapper.updateST");
	}

	

}
