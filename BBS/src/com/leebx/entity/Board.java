package com.leebx.entity;

import java.util.Date;

public class Board {
	private int boardId;
	private String boardName;
	private Date cateDate;
	private int forcumId;
	private int memberId;

	public int getForcumId() {
		return forcumId;
	}

	public void setForcumId(int forcumId) {
		this.forcumId = forcumId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public Date getCateDate() {
		return cateDate;
	}

	public void setCateDate(Date cateDate) {
		this.cateDate = cateDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}
