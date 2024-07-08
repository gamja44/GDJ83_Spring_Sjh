package com.win.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.win.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "createAccount", accountDTO);
	}

	// 기존의 AccountDTO 타입 대신 String 타입의 accountNumber를 받도록 수정
	public AccountDTO detail(String accountNumber) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountNumber);
	}
}
