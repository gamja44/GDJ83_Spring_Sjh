package com.win.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.win.app.history.HistoryDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.win.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "createAccount", accountDTO);
	}

	public AccountDTO detail(String accountNumber) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountNumber);
	}

	public int updateBalance(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateBalance", accountDTO);
	}

	public int insertHistory(HistoryDTO historyDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertHistory", historyDTO);
	}
}
