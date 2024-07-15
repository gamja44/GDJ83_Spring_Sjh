package com.win.app.boards;

import java.sql.Date;

public class BoardDTO {
	private Integer boardNum;
	private Integer boardWriter;
	private String boardTitle;
	private String boardContents;
	private Date createDate;
	private Date updateDate;
	private Integer boardHit;
	private String boardCategory;

	// Getters and Setters
	public Integer getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}

	public Integer getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(Integer boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(Integer boardHit) {
		this.boardHit = boardHit;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
}
