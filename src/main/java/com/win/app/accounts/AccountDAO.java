package com.win.app.accounts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.members.MemberDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.win.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "createAccount", accountDTO);
	}

	public List<AccountDTO> list(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", memberDTO);
	}
}
