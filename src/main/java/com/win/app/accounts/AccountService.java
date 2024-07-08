package com.win.app.accounts;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAccount_number("AB" + calendar.getTimeInMillis());
		accountDTO.setBalance(0.0); // 초기 잔고 설정

		return accountDAO.add(accountDTO);
	}
}
