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

	// 계좌 생성
	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "createAccount", accountDTO);
	}

	// 계좌 상세 조회
	public AccountDTO detail(String accountNumber) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountNumber);
	}

	// 내 계좌 잔고 업데이트
	public int updateFromAccountBalance(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateFromAccountBalance", accountDTO);
	}

	// 상대방 계좌 잔고 업데이트
	public int updateToAccountBalance(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateToAccountBalance", accountDTO);
	}

	// 내 계좌 거래 내역 삽입
	public int insertFromAccountHistory(HistoryDTO historyDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertFromAccountHistory", historyDTO);
	}

	// 상대방 계좌 거래 내역 삽입
	public int insertToAccountHistory(HistoryDTO historyDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertToAccountHistory", historyDTO);
	}

	// 거래내역 조회
	public List<HistoryDTO> getHistoryList(Integer productInfoId) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getHistoryList", productInfoId);
	}
}
