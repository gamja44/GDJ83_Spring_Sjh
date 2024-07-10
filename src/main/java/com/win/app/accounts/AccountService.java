package com.win.app.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.app.history.HistoryDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(String accountNumber) throws Exception {
		return accountDAO.detail(accountNumber);
	}

	public boolean transfer(String fromAccount, String toAccount, Double amount) throws Exception {
		// Transfer logic
		return true;
	}

	public List<HistoryDTO> getHistoryList(ListOption listOption) throws Exception {
		return accountDAO.getHistoryList(listOption);
	}
}
