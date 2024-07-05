package com.win.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public int createAccount(AccountDTO accountDTO) throws Exception {
		return accountDAO.createAccount(accountDTO);
	}
}