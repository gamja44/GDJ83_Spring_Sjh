package com.win.app.history;

import java.sql.Date;

public class HistoryDTO {
	private Integer history_id;
	private Integer product_info_id;
	private Date history_time;
	private Double amount;
	private Double balance;
	private String type;

	public Integer getHistory_id() {
		return history_id;
	}

	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}

	public Integer getProduct_info_id() {
		return product_info_id;
	}

	public void setProduct_info_id(Integer product_info_id) {
		this.product_info_id = product_info_id;
	}

	public Date getHistory_time() {
		return history_time;
	}

	public void setHistory_time(Date history_time) {
		this.history_time = history_time;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
