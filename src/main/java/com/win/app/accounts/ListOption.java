package com.win.app.accounts;

public class ListOption {

	private String accountNumber;
	private Integer order; // 0 desc, 1 asc

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}