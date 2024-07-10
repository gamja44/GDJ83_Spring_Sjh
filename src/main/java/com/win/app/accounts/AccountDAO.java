package com.win.app.accounts;

import java.util.List;

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

	public int updateFromAccountBalance(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateFromAccountBalance", accountDTO);
	}

	public int updateToAccountBalance(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateToAccountBalance", accountDTO);
	}

	public int insertFromAccountHistory(HistoryDTO historyDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertFromAccountHistory", historyDTO);
	}

	public int insertToAccountHistory(HistoryDTO historyDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertToAccountHistory", historyDTO);
	}

	public List<HistoryDTO> getHistoryList(ListOption listOption) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getHistoryList", listOption);
	}
}
