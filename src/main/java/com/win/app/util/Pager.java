package com.win.app.util;

public class Pager {
	private String kind;
	private String search;
	private Long startRow;
	private Long lastRow;
	private Long page;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;

	public void init() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		if (this.search == null) {
			this.search = "";
		}
		this.makeRow();
	}

	public void makeRow() {
		long perPage = 10L;
		this.startRow = (this.page - 1) * perPage + 1;
		this.lastRow = this.page * perPage;
	}

	public void makeNum(long totalCount) {
		long perPage = 10L;

		long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage++;
		}

		long perBlock = 5L;
		long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		long curBlock = this.page / perBlock;
		if (this.page % perBlock != 0) {
			curBlock++;
		}

		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;

		this.pre = curBlock != 1;
		this.next = curBlock != totalBlock;

		if (curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}

	// Getters and Setters
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
}
