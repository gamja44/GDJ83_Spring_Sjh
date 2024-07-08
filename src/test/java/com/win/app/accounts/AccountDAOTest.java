package com.win.app.accounts;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDAOTest {
	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void detail() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_number("AB1720419625101");
	}

}
