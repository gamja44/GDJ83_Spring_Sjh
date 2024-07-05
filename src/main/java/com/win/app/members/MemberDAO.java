package com.win.app.members;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.members.MemberDAO.";

	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
	}

	public MemberDTO getMemberById(int m_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberById", m_id);
	}

	public int updateMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateMember", memberDTO);
	}
}
