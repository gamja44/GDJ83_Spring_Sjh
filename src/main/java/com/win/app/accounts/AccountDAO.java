package com.win.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.win.app.accounts.AccountDAO.";

	public int createAccount(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "createAccount", accountDTO);
	}

}
