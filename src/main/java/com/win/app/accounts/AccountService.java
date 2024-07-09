package com.win.app.accounts;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.history.HistoryDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	// 계좌 생성
	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAccount_number("AB" + calendar.getTimeInMillis());
		accountDTO.setBalance(0.0); // 초기 잔고 설정

		return accountDAO.add(accountDTO);
	}

	// 계좌 상세 조회
	public AccountDTO detail(String accountNumber) throws Exception {
		return accountDAO.detail(accountNumber);
	}

	// 금액 이체
	public boolean transfer(String fromAccount, String toAccount, Double amount) throws Exception {
		AccountDTO fromAccountDTO = accountDAO.detail(fromAccount);
		AccountDTO toAccountDTO = accountDAO.detail(toAccount);

		if (fromAccountDTO.getBalance() >= amount) {
			fromAccountDTO.setBalance(fromAccountDTO.getBalance() - amount);
			toAccountDTO.setBalance(toAccountDTO.getBalance() + amount);

			// 내 계좌 잔고 업데이트
			accountDAO.updateFromAccountBalance(fromAccountDTO);

			// 상대방 계좌 잔고 업데이트
			accountDAO.updateToAccountBalance(toAccountDTO);

			// 내 계좌 거래 내역 기록
			HistoryDTO fromHistory = new HistoryDTO();
			fromHistory.setProduct_info_id(fromAccountDTO.getProduct_info_id());
			fromHistory.setAmount(-amount);
			fromHistory.setBalance(fromAccountDTO.getBalance());
			fromHistory.setType("Transfer Out");

			// 내 계좌 거래 내역 삽입
			accountDAO.insertFromAccountHistory(fromHistory);

			// 상대방 계좌 거래 내역 기록
			HistoryDTO toHistory = new HistoryDTO();
			toHistory.setProduct_info_id(toAccountDTO.getProduct_info_id());
			toHistory.setAmount(amount);
			toHistory.setBalance(toAccountDTO.getBalance());
			toHistory.setType("Transfer In");

			// 상대방 계좌 거래 내역 삽입
			accountDAO.insertToAccountHistory(toHistory);

			return true;
		} else {
			return false;
		}
	}
}
