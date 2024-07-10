package com.win.app.accounts;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.win.app.history.HistoryDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Transactional
	public boolean transfer(String fromAccount, String toAccount, Double amount) throws Exception {
		AccountDTO fromAccountDTO = accountDAO.detail(fromAccount);
		AccountDTO toAccountDTO = accountDAO.detail(toAccount);

		if (fromAccountDTO == null || toAccountDTO == null) {
			return false;
		}

		if (fromAccountDTO.getBalance() < amount) {
			return false;
		}

		// Update balances
		fromAccountDTO.setBalance(fromAccountDTO.getBalance() - amount);
		toAccountDTO.setBalance(toAccountDTO.getBalance() + amount);

		int fromUpdateResult = accountDAO.updateFromAccountBalance(fromAccountDTO);
		int toUpdateResult = accountDAO.updateToAccountBalance(toAccountDTO);

		if (fromUpdateResult == 0 || toUpdateResult == 0) {
			throw new Exception("Failed to update account balances.");
		}

		// Insert transaction history
		Date currentTime = new Date();

		HistoryDTO fromHistory = new HistoryDTO();
		fromHistory.setProduct_info_id(fromAccountDTO.getProduct_info_id());
		fromHistory.setHistory_time(new java.sql.Date(currentTime.getTime()));
		fromHistory.setAmount(-amount);
		fromHistory.setBalance(fromAccountDTO.getBalance());
		fromHistory.setType("Transfer Out");

		HistoryDTO toHistory = new HistoryDTO();
		toHistory.setProduct_info_id(toAccountDTO.getProduct_info_id());
		toHistory.setHistory_time(new java.sql.Date(currentTime.getTime()));
		toHistory.setAmount(amount);
		toHistory.setBalance(toAccountDTO.getBalance());
		toHistory.setType("Transfer In");

		accountDAO.insertFromAccountHistory(fromHistory);
		accountDAO.insertToAccountHistory(toHistory);

		return true;
	}

	public int add(AccountDTO accountDTO) throws Exception {
		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(String accountNumber) throws Exception {
		return accountDAO.detail(accountNumber);
	}

	public List<HistoryDTO> getHistoryList(ListOption listOption) throws Exception {
		return accountDAO.getHistoryList(listOption);
	}
}
